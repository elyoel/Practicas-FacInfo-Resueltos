program prueba_2;
const
dimF = 10;
type 
  vector = array[1..dimF] of integer;

Function BuscarPosicion (v: vector; dimL: integer; elemABuscar: integer): integer;

Var pos: integer;
Begin
  pos := 1;
  While (pos <= dimL) And (elemABuscar > v[pos]) Do
    pos := pos + 1;
  If (pos > dimL) Then BuscarPosicion := 0
  Else BuscarPosicion := pos;
End;
Function BuscarPosicionDesde (v: vector; dimL, pos : integer; elemABuscar:
                              integer): integer;
Begin
  While (pos <= dimL) And (elemABuscar >= v[pos]) Do
    pos := pos + 1;
  If (pos > dimL) Then BuscarPosicionDesde := dimL
  Else BuscarPosicionDesde := pos - 1 ;
End;

Var posInferior, posSuperior, salto, i: integer;
vec: vector;
dimL: integer;

Begin
  For i := 1 To dimF Do
  vec[i] := 20 + i;
  dimL:= 10;

  posInferior := BuscarPosicion (vec, dimL, 24);
  writeln(posInferior);
  If (posInferior <> 0) Then
    Begin
      posSuperior := BuscarPosicionDesde (vec, dimL, posInferior, 27) + 1;
      writeln(posSuperior);
      While (posSuperior <= dimL) Do
        Begin
          vec[posInferior] := vec[posSuperior];
          posInferior := posInferior + 1;
          posSuperior := posSuperior + 1;
        End;
      dimL := dimL - (posSuperior - posInferior);
    End;
    writeln(dimL);
    for i := 1 to dimL do
      writeln(vec[i]);
End.