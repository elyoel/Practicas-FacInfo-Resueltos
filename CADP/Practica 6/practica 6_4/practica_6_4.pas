Program practice_6_4;
const
  corte = -1;
type
  producto = record
    codigo: integer;
    descripcion: string[50];
    stok_actual: integer;
    stok_minimo: integer;
    precio: real;
  end;

  lista_p= ^nodo_p;
  nodo_p = record
    dato: producto;
    sig: lista_p;
  end;

procedure leer_producto(var p: producto);
begin
  write('Ingrese codigo del producto: ');
  readln(p.codigo);
  if (p.codigo <> corte) then
  begin
    write('Ingrese descripcion del producto: ');
    readln(p.descripcion);
    write('Ingrese stok actual: ');
    readln(p.stok_actual);
    write('Ingrese stok minimo: ');
    readln(p.stok_minimo);
    write('Ingrese precio: ');
    readln(p.precio);
  end;
end;
procedure agregar_adelante(var l: lista_p; p: producto);
var
  nuevo: lista_p;
begin
  new(nuevo);
  nuevo^.dato := p;
  nuevo^.sig := l;
  l := nuevo;
end;
procedure cargar_lista(var l: lista_p);
var
  p: producto;
begin
  leer_producto(p);
  while (p.codigo <> corte) do
  begin
    agregar_adelante(l, p);
    leer_producto(p);
  end;
end;
function calcular_porcentaje(l:lista_p): real;
var
   total, cant: integer;
begin
  total:= 0;
  cant:= 0; 
  while (l <> Nil) do
  begin
    if (l^.dato.stok_actual < l^.dato.stok_minimo) then
      total := total + 1;
    cant:= cant + 1;
    l := l^.sig;
  end;
  if (total = 0) then
    calcular_porcentaje := 0
  else
    calcular_porcentaje := (total / cant) * 100;
end;

function contar_pares(n: integer): integer;
var
  contador: integer;
begin
  contador := 0;
  while (n <> 0) do
  begin
    if (n mod 10) mod 2 = 0 then
      contador := contador + 1;
    n := n div 10;
  end;
  contar_pares := contador;
end;

procedure informar_descripcion(l: lista_p);
begin
  while (l <> Nil) do
  begin
    if (contar_pares(l^.dato.codigo) >= 3) then
      writeln('Descripcion del producto: ', l^.dato.descripcion);
    l := l^.sig;
  end;
end;

procedure informar_dos_economicos(l: lista_p; var min1, min2: producto);
begin
  while (l <> Nil) do
  begin
    if (l^.dato.precio < min1.precio) then
    begin
      min2 := min1;
      min1 := l^.dato
    end
    else if (l^.dato.precio < min2.precio) then
    begin
      min2 := l^.dato;
    end;
    l := l^.sig;
  end;
  writeln('Producto mas economico: Codigo ', min1.codigo, ' Precio: ', min1.precio:0:2);
  writeln('Segundo producto mas economico: Codigo ', min2.codigo, ' Precio: ', min2.precio:0:2);


end;
    
var
  lista: lista_p;
  min1, min2: producto;
begin
  lista := Nil;
  min1.precio:= MaxInt;
  min2.precio:= MaxInt;
  cargar_lista(lista);
    
  writeln('Porcentaje de productos con stok actual menor al stok minimo: ', calcular_porcentaje(lista):0:2, '%');
  informar_descripcion(lista);
  informar_dos_economicos(lista, min1, min2);
end.