program practica_7_1;
type
  cod_genero= 1..5;
  personas = record
    dni: integer;
    nombre: string;
    apellido: string;
    edad: integer;
    cod_gen: cod_genero;
  end;
  
  lista_c = ^nodo_c;
  nodo_c = record
    elem: personas;
    sig: lista_c;
  end;
  arreglo_genero= array [cod_genero] of integer;

  max = record
    cod_gen: cod_genero;
    cant: integer;
  end;

procedure leer(var per: personas);
begin 
  writeln('Ingrese DNI: ');
  readln(per.dni);
  writeln('Ingrese nombre: ');
  readln(per.nombre);
  writeln('Ingrese apellido: ');
  readln(per.apellido);
  writeln('Ingrese edad: ');
  readln(per.edad);
  writeln('Ingrese codigo de genero (1-5): ');
  readln(per.cod_gen);
end;

procedure agregarAdelante(var ls: lista_c; per: personas);
var
  nue: lista_c;
begin
  new(nue);
  nue^.elem:= per;
  nue^.sig:= ls;
  ls:= nue;
end;
procedure crearLista(var ls: lista_c);
var
  p: personas;
begin
  repeat
    leer(p);
    agregarAdelante(ls, p);
  until (p.dni = 33);
end;
function cumpleCondicion(n:integer):boolean;
var 
  par, impar: integer;
begin
  impar:= 0;
  par:= 0;
  while (n <> 0) do
  begin
    if (n MOD 10) MOD 2 = 0 then
      par:= par + 1
    else
      impar:= impar + 1;
    n:= n DIV 10;
  end;
  cumpleCondicion:= (par > impar);
end;
procedure inicializarVector(var v:arreglo_genero);
var i:cod_genero;
begin
    for i := 1 to 5 do
      v[i]:= 0;
end;

procedure recorrerLista(ls: lista_c; var v: arreglo_genero);
var
  cant: integer;
begin
  cant:= 0;
  while (ls <> Nil) do
  begin
    if cumpleCondicion(ls^.elem.dni) then
      cant:= cant + 1;
    v[ls^.elem.cod_gen]:= v[ls^.elem.cod_gen] + 1;  
    ls:= ls^.sig;
  end;
  writeln('Cantidad de personas cuyo DNI contiene mas digitos pares que impares: ', cant);
end;
procedure calcularMaximos(v: arreglo_genero);
var 
  i: cod_genero;
  max1, max2: max;
begin
  max1.cant:= -1;
  for i := 1 to 5 do
  begin
    if (v[i] > max1.cant) then
    begin
      max2:= max1;
      max1.cant:= v[i];
      max1.cod_gen:= i;
    end
    else
      if (v[i] > max2.cant) then
      begin
        max2.cant:= v[i];
        max2.cod_gen:= i;
      end;
  end;
  writeln('Los dos codigos de genero mas elegidos: ', max1.cod_gen, ' ', max2.cod_gen);
end;
procedure eliminar(dni: integer; var ls: lista_c);
var
  act, ant: lista_c;
begin
  act:= ls;
  ant:= ls;
  while (act <> Nil) and (act^.elem.dni <> dni) do
  begin
    ant:= act;
    act:= act^.sig;
  end;
  if (act <> Nil) then
    if (act = ant) then
      ls:= ls^.sig
    else
      ant^.sig:= act^.sig;
    dispose(act);
end;
var
  lista: lista_c;
  cant_gen: arreglo_genero;
begin
  lista:= Nil;
  inicializarVector(cant_gen);
  crearLista(lista);
  recorrerLista(lista, cant_gen);
  calcularMaximos(cant_gen);

  eliminar(un_dni, lista);//le paso un dni x
end.

