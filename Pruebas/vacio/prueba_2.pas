Program prueba_2;
const 
  dimF = 15;

Type vector = array [1..dimF] Of integer;

Procedure CargarVector (Var v: vector; Var dimL: integer);
var i: integer;
Begin
  Randomize;
  for i:= 1 to dimF do
    v[i]:= 120 + i;
  dimL:= dimF;
End;

Function  ObtenerMaximo(v: vector; dimL: integer): integer;
  Procedure ObtenerMaximoRecursivo(v: vector; dimL: integer; Var max1: integer);
  Begin
    If (dimL >= 1) Then begin
      If (v[dimL] > max1) Then max1 := v[dimL];
      ObtenerMaximoRecursivo(v, (dimL - 1), max1);
    end;
  End;
Var 
  max1: integer;
Begin
  max1:= -1;
  ObtenerMaximoRecursivo(v, dimL, max1);
  writeln('valor maximo');
  ObtenerMaximo := max1;
End;


{Function  BuscarValor (v: vector; dimL, valor: integer): boolean;
  function buscar(v: vector; dimL, valor: integer; encontre: boolean):integer;
  begin
    If NOT(encontre) AND (dimL > 0);
      If (v[dimL] = valor);
        encontre:= true;
        BuscarValor
  end;
var ok: boolean;
Begin
  //Modificacion
  ok:= false;
  If (dimL = 1) then BuscarValor:= (v[dimL] = valor)
  Else
    BuscarValor:= (v[dimL] = valor) OR BuscarValor(v, dimL-1, valor);
  //Fin Modificacion
End;}

Function  BuscarValor (v: vector; dimL, valor: integer): boolean;
begin
  If (dimL = 1) Then BuscarValor := (v[dimL] = valor)
  Else
    BuscarValor := (v[dimL] = valor) Or BuscarValor(v, dimL-1, valor);
end;

Procedure ImprimirDigitos (v: vector; dimL: integer);
//Modificacion  
Procedure DescomponerRecursivo(n: integer);
Begin
  If (n <> 0) Then
  Begin
    DescomponerRecursivo(n Div 10);
    Write((n Mod 10), ' ');
  End;
End;
Begin
  If (dimL > 1) Then
    ImprimirDigitos(v, (dimL - 1));
  DescomponerRecursivo(v[dimL]);
  writeln;
End;




var
  i, dimL: integer;
  v: vector;
begin
  CargarVector(v, dimL);
  writeln('vector original');
  for i:= 1 to dimL do
    writeln(v[i]);

  //writeln(ObtenerMaximo(v, dimL));
  //writeln(BuscarValor(v, dimL, 15))
  WriteLn('- descomposicion -');
  ImprimirDigitos(v, dimL);
end.
