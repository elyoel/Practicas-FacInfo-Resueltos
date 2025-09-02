program actividad_2;
const
  max = 1550; min = 300;
  dimF = 20;
  
type
  vector = array[1..dimF];
procedure cargarRecursivo(var v: vector; var dimL: integer);
  function numRandom():integer;
  begin
    Randomize;
    numRandom:= min + ((max - min) + 1);
  end;

var
begin
  If (dimL > dimF) then
  begin
      dimL:= dimL + 1;
      v[dimL]:= numRandom();
  end;
end;

procedure ordenar(var v: vector; dimL: integer);
var
  i, j, valor: integer;}
begin
  for i:= 2 to dimL do
  begin
    a
  end; 
end;
begin

end.