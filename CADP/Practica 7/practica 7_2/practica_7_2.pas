program practica_7_2;
type
  poliza = 1..6;

  cliente = record
    cod_cli: integer;
    dni: integer;
    nombre: string[20];
    apellido: string[20];
    cod_poliza: poliza;
    monto: real;
  end;
  
  v_adicional = array[poliza] of real;

  lista_c = ^nodo_c;
  nodo_c = record
    dato: cliente;
    sig: lista_c;
end;
procedure leer_cliente(var c: cliente);
begin
  readln(c.cod_cli);
  readln(c.dni);
  readln(c.nombre);
  readln(c.apellido);
  readln(c.cod_poliza);
  readln(c.monto);
end;
procedure agregar_cliente(var l: lista_c; c: cliente);
var
  nuevo: lista_c;
begin
  new(nuevo);
  nuevo^.dato := c;
  nuevo^.sig := l;
  l := nuevo;
end;
procedure generar_lista(var l: lista_c);
var
  c: cliente;
begin
  repeat
    leer_cliente(c);
    agregar_cliente(l, c);
  until (c.cod_cli = 1122);
end;
function cumple_b(n: integer): boolean;
var
  cant: integer;
begin
  cant := 0;
  while (n <> 0) and (cant <= 2) do begin
    if ((n mod 10) = 9) then
      cant := cant + 1;
    n := n div 10;
  end;
  cumple_b := (cant >= 2);
end;
procedure iprimir_cliente(c: cliente; mon_adi: v_adicional);
begin
  writeln('Codigo cliente: ', c.cod_cli);
  writeln('DNI: ', c.dni);
  writeln('Nombre: ', c.nombre);
  writeln('Apellido: ', c.apellido);
  writeln('Codigo de poliza: ', c.cod_poliza);
  writeln('Monto adicional: ', c.monto + mon_adi[c.cod_poliza]);
end;

procedure recorrer_lista(l: lista_c; mon_adi: v_adicional);
begin
  while (l <> Nil) do begin
    iprimir_cliente(l^.dato, mon_adi);
    if cumple_b(l^.dato.dni) then
      writeln('Cumple con la condicion de tener al menos dos 9 en el DNI');
      writeln('Cliente: ', l^.dato.nombre, ' ', l^.dato.apellido);
    l := l^.sig;
  end;
end;
procedure eliminar_cliente(var l: lista_c; cli: cliente);
var
  ant, act: lista_c;
begin
  ant := l;
  act := l;
  while (act <> Nil) and (act^.dato.cod_cli <> cli.cod_cli) do begin
    ant := act;
    act := act^.sig;
  end;
  if (act = ant) then
    l:= l^.sig
  else
    ant^.sig := act^.sig;
  dispose(act);
end;
var
  monto_adicional: v_adicional;
  lista_clientes: lista_c;
begin
  cargar_monto_adicional(monto_adicional);
  lista_clientes := Nil;
  generar_lista(lista_clientes);
  recorrer_lista(lista_clientes, monto_adicional);
  eliminar_cliente(lista_clientes, cli);
end.