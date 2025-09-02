program actividad_2;
const
  max = 1550; min = 300;
  dimF = 20;
  
type
  vector = array[1..dimF] Of Integer;


function numRandom():integer;
begin
    numRandom:= min + Random(((max - min) + 1));
end;
procedure cargarRecursivo(var v: vector; var dimL: integer);
begin
  If (dimL < dimF) then
  begin
      dimL:= dimL + 1;
      v[dimL]:= numRandom();
      cargarRecursivo(v, dimL);
  end;
end;

procedure ordenar(var v: vector; dimL: integer);
var
  i, j, valor: integer;
begin
  For i:= 2 to dimL do
  begin
    valor:= v[i];
    j:= i-1;
    While (j > 0) AND (v[j] > valor) do
    begin
      v[j+1]:= v[j];
      j:= j - 1;
    end;
    v[j+1]:= valor;
  end; 
end;
Procedure busquedaDicotomica (v: vector; ini,fin: integer; dato:integer; var pos: integer);
var aux: integer;
begin
  pos:= -1;
  If (ini <= fin) then
  begin
    aux:= (fin + ini) DIV 2;
    If (v[aux] = dato) then
      pos:= aux
    else
    begin
      If (dato < v[aux]) then
        busquedaDicotomica(v, ini, aux-1, dato, pos)
      else
        busquedaDicotomica(v, aux+1, fin, dato, pos);
    end;
  end;
end;
var 
  v: vector;
  dimL, i, pos, elem: integer;
begin
  Randomize;
  dimL:= 0;
  cargarRecursivo(v, dimL);
  ordenar(v, dimL);
  
  WriteLn('Ingrese elemento a buscar entre 300 y 1550 : '); Read(elem);
  busquedaDicotomica(v, 1, dimL, 1300, pos);
  If (pos = -1)then
    WriteLn('Elemento no encontrado')
  Else  WriteLn('Se encontro el elemento:', elem, ' en la posicion: ', pos);
end.