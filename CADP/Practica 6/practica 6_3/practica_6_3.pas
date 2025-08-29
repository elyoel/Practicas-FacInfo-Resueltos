
Program JugamosConListas;
Type 
  lista = ^nodo;
  nodo = Record
    num : integer;
    sig : lista;
  End;
Procedure armarNodo(Var L, U: lista; v: integer);
Var 
  aux : lista;
Begin
  new(aux);
  aux^.num := v;
  aux^.sig := Nil;
  if (L = Nil) then
    L := aux;
  else
    U^.sig := aux;
  U := aux;
End;
Var 
  pri, ult : lista;
  valor : integer;
Begin
  pri := Nil;
  writeln('Ingrese un numero');
  read(valor);
  While (valor <> 0) Do
  Begin
    armarNodo(pri, ult, valor);
    writeln('Ingrese un numero');
    read(valor);
  End;
{imprimir lista}
  writeln('Lista: ');
  While (pri <> Nil) Do
  Begin
    write(pri^.num, ' ');
    pri := pri^.sig;
  End;
  writeln;
End.
