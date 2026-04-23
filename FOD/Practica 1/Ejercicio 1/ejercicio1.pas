program nombrePrograma;
type
  archivo = File of Integer;
var
  arc: archivo;
  nombre: String;
  num: Integer;
begin
  WriteLn('Ingrese nombre de archivo');
  ReadLn(nombre);
  Assign(arc, nombre);
  Rewrite(arc);
  repeat
    WriteLn('Ingrese numero');
    ReadLn(num);
    Write(arc, num)  
  until (num = 3000);
  close(arc);
end.
