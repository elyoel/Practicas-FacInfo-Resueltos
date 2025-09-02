program actividad_4;
procedure ImprimirRecursivo(n: integer);
begin
  If (n <> 0) then
  begin
    ImprimirRecursivo(n DIV 2);
    Write(n MOD 2);
  end;
end;
procedure leerValor();
var
  num: integer;
begin
  WriteLn('Ingrese valor: ');
  Read(num);
  While (num <> 0) do
  begin
    WriteLn('El numero ', num, ' en binario es: ');
    ImprimirRecursivo(num);
    WriteLn;
    WriteLn('Ingrese valor: ');
    Read(num);
  end;
end;
begin
  leerValor();
end.
