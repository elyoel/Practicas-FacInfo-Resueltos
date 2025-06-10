program ex_1;
Type
  lista = ^nodo;
  nodo = Record
    elem: integer;
    sig: lista;
  end;

procedure insertar_ordenado(var ls: lista; valor: integer);
var
  ant, act, nuevo: lista;
begin
  new(nuevo);
  nuevo^.elem:= valor;
  ant:= ls; 
  act:= ls;
  while (act <> Nil) and (act^.elem < valor) do begin
    ant:= act;
    act:= act^.sig;
  end;

  if (act = ant) then begin
    nuevo^.sig:= ls;
    ls:= nuevo;
  end
  else begin
    ant^.sig:= nuevo;
    nuevo^.sig:= act;
  end;
end;
procedure generar_ls(var ls: lista);
var
  num: integer;
begin
  readln(num);
  while (num <> -1) do begin
    insertar_ordenado(ls, num);
    readln(num);
  end;
end;
procedure imprimir_ls(ls: lista);
begin
  while (ls <> Nil) do begin
    writeln(ls^.elem);
    ls:= ls^.sig;
  end;
end;
procedure eliminar(var ls: lista; num: integer);
var
  ant, act: lista;
begin
  ant:= ls;
  act:= ls;

  while (act <> Nil) and (act^.elem < num) do begin
    ant:= act;
    act:= act^.sig;
  end;

  if (act <> Nil) and (num = act^.elem) then begin
    if (act = ls) then
      ls:= ls^.sig
    else
      ant^.sig:= act^.sig;
    dispose(act);
  end;
end;
function existe(ls: lista; num: integer):boolean;
var 
  aux: boolean;
begin
  aux:= False;
  while (ls <> Nil) do
    if (ls^.elem = num) then
    begin
      aux:= True;
      ls:= Nil;
    end
    else
      ls:= ls^.sig;
  existe:= aux;
end;

var
  list: lista;
begin
   list:= Nil;
   generar_ls(list);
   imprimir_ls(list);
   if existe(list, 10) then
     eliminar(list, 10)
   else
     writeln('elemento no existe');
   writeln('-------------');
   imprimir_ls(list);
end.