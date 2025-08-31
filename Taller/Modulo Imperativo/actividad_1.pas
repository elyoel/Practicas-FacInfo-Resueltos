
{
Se desea procesar la información de las ventas de productos de un comercio (como máximo 50). 
Implementar un programa que invoque los siguientes módulos:
a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce el día de la venta, código del producto (entre 1 y 15) y cantidad vendida
 (como máximo 99 unidades). El código y el dia deben generarse automáticamente (random) y la cantidad se debe leer. El ingreso de las ventas finaliza con el día de venta 0 
 (no se procesa).
b. Un módulo que muestre el contenido del vector resultante del punto a).
c. Un módulo que ordene el vector de ventas por código.
d. Un módulo que muestre el contenido del vector resultante del punto c).
e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos valores que se ingresan como parámetros. 
f. Un módulo que muestre el contenido del vector resultante del punto e).
g. Un módulo que retorne la información (ordenada por código de producto de menor a mayor) de cada código par de producto junto a la cantidad total de productos vendidos.
h. Un módulo que muestre la información obtenida en el punto g).
}

Program actividad_1;
Const dimF = 50;
Type dias = 0..31;
  rango1 = 0..15;
  rango2 = 1..99;
  rango3 = 0..dimF;
  venta = Record
    dia: dias;
    codigoP: rango1;
    cantidad: rango2;
  End;
  vector = array [1..dimF] Of venta;
  elemento = Record
    codigoP: rango1;
    cantTotal: integer;
  End;
  lista = ^nodo;
  nodo = Record
    dato: elemento;
    sig: lista;
  End;

Procedure AlmacenarInformacion (Var v: vector; Var dimL: rango3);

Procedure LeerVenta (Var v: venta);
Begin
  Randomize;
  write ('Dia: ');
  v.dia := random(32);
  writeln (v.dia);
  If (v.dia <> 0)
    Then
    Begin
      write ('Codigo de producto: ');
      v.codigoP := random(16) + 1;
      writeln (v.codigoP);
      write ('Ingrese cantidad (entre 1 y 99): ');
      readln (v.cantidad);
    End;
End;

Var unaVenta: venta;
Begin
  dimL := 0;
  LeerVenta (unaVenta);
  While (unaVenta.dia <> 0)  And ( dimL < dimF ) Do
    Begin
      dimL := dimL + 1;
      v[dimL] := unaVenta;
      LeerVenta (unaVenta);
    End;
End;

Procedure ImprimirVector (v: vector; dimL: rango3);

Var 
  i: integer;
Begin
    For i := 1 to dimL do
    begin
        write('Dia :');
        writeln(v[i].dia);
        write('Codigo :');
        writeln(v[i].codigoP);
        write('Cantidad :');
        writeln(v[i].cantidad);
    end;
End;

Procedure Ordenar (Var v: vector; dimL: rango3);

Var i, j, pos: rango3;
  item: venta;

Begin
  For i:= 1 To dimL - 1 Do
    Begin {busca el mínimo y guarda en pos la posición}
      pos := i;
      For j := i+1 To dimL Do
        If (v[j].codigoP < v[pos].codigoP) Then pos := j;

   {intercambia v[i] y v[pos]}
      item := v[pos];
      v[pos] := v[i];
      v[i] := item;
    End;
End;

Procedure Eliminar (Var v: vector; Var dimL: rango3; valorInferior, valorSuperior: rango1);

Function BuscarPosicion (v: vector; dimL: rango3; elemABuscar: rango1): rango3;
Var pos: rango3;
Begin
  pos := 1;
  While (pos <= dimL) And (elemABuscar > v[pos].codigoP) Do
    pos := pos + 1;
  If (pos > dimL) Then BuscarPosicion := 0
  Else BuscarPosicion := pos;
End;

Function BuscarPosicionDesde (v: vector; dimL, pos : integer; elemABuscar: rango1): rango3;
Begin
  While (pos <= dimL) And (elemABuscar >= v[pos].codigoP) Do
    pos := pos + 1;
  If (pos > dimL) Then BuscarPosicionDesde := dimL
  Else BuscarPosicionDesde := pos - 1;
End;

Var posInferior, posSuperior, salto, i: rango3;
Begin
  posInferior := BuscarPosicion (v, dimL, valorInferior);
  If (posInferior <> 0) Then
    Begin
      {Hay una mejor manera es la que se ocurrio en el momento.
       la idea era completarlo con las variables 'i' y 'salto' utlizando un for
       lo que se me ocurrio en le momento fue utilizar un while y modificar posSuperior sumando 1
       modificando la idea original}
      posSuperior := BuscarPosicionDesde (v, dimL, posInferior, valorSuperior) + 1;
      While (posSuperior <= dimL) do 
        Begin
            v[posInferior] := v[posSuperior];
            posInferior := posInferior + 1;
            posSuperior := posSuperior + 1;
        End;
            dimL := dimL - (posSuperior - posInferior);
    End;
End;

Procedure GenerarLista (v: vector; dimL: rango3; Var L: lista);

Procedure AgregarAtras (Var L, ult: lista; elem: elemento);
var nue: lista;
Begin
    new(nue);
    nue^.dato := elem;
    nue^.sig := Nil;
    If (L <> Nil) Then
        ult^.sig := Nue
    else
        L := nue;
    ult := nue; 
End;

Var 
  i: rango3;
  ult: lista;
  e: elemento;
Begin
  L := Nil;
  ult := Nil;
  i := 1;
  While (i<= dimL) Do
    Begin
      e.codigoP :=  v[i].codigoP;
      e.cantTotal := 0;
      While ((i<= dimL) And (e.codigoP =  v[i].codigoP)) Do
        Begin
          e.cantTotal := e.cantTotal + v[i].cantidad;
          i := i + 1;
        End;
      AgregarAtras (L, ult, e);
    End;
End;

Procedure ImprimirLista (L: lista);
Begin
    While (L <> Nil) do
    begin
        write('Codigo :');
        writeln(L^.dato.codigoP);
        write('Cantidad :');
        writeln(L^.dato.cantTotal);
        L:= L^.sig;
    end;
End;

Var v: vector;
  dimL: rango3;
  valorInferior, valorSuperior: rango1;
  L: lista;

Begin
  AlmacenarInformacion (v, dimL);
  writeln;
  If (dimL = 0) Then writeln ('--- Vector sin elementos ---')
  Else
    Begin
      writeln ('--- Vector ingresado --->');
      writeln;
      ImprimirVector (v, dimL);
      writeln;
      writeln ('--- Vector ordenado --->');
      writeln;
      Ordenar (v, dimL);
      ImprimirVector (v, dimL);
      write ('Ingrese valor inferior: ');
      readln (valorInferior);
      write ('Ingrese valor superior: ');
      readln (valorSuperior);
      Eliminar (v, dimL, valorInferior, valorSuperior);
      If (dimL = 0) Then writeln ('--- Vector sin elementos, luego de la eliminacion ---')
      Else
        Begin
          writeln;
          writeln ('--- Vector luego de la eliminacion --->');
          writeln;
          ImprimirVector (v, dimL);
          GenerarLista (v, dimL, L);
          If (L = Nil) Then writeln ('--- Lista sin elementos ---')
          Else
            Begin
              writeln;
              writeln ('--- Lista obtenida --->');
              writeln;
              ImprimirLista (L);
            End;
        End;
    End;

End.
