Program practica_3_4;
type
  Linea = record
    telefono: string;
    minutos: integer;
    mb: real;
  end;
  Cliente = record
    codigo: integer;
    cantidadLineas: integer;
  end;
  Factura = record
    totalMinutos: integer;
    totalMB: real;
  end;
procedure leerLinea(var l: Linea; var f: Factura; c: Cliente);
var
  i: integer;
begin
  For i := 1 To c.cantidadLineas Do
  Begin
    writeln('Ingrese los datos de la linea ', i);
    writeln('Ingrese el numero de telefono: ');
    readln(l.telefono);
    writeln('Ingrese la cantidad de minutos consumidos: ');
    readln(l.minutos);
    writeln('Ingrese la cantidad de MB consumidos: ');
    readln(l.mb);
    sumarFactura(f, l);
  end;
end;
procedure sumarFactura(var f: Factura; l: Linea);
begin
  f.totalMinutos := f.totalMinutos + l.minutos;
  f.totalMB := f.totalMB + l.mb;
end;
procedure leercliente(var c: Cliente);
begin
  writeln('Ingrese el codigo del cliente: ');
  readln(c.codigo);
  writeln('Ingrese la cantidad de lineas a su nombre: ');
  readln(c.cantidadLineas);
end;
function calcularFactura(f: Factura): real;
begin 
  calcularFactura := (f.totalMinutos * 3.4) + (f.totalMB * 1.35);
end;
{Codigo principal}
var
  c: Cliente;
  l: Linea;
  f: Factura;
  i: integer;
begin
  for i := 1 to 9300 do
  begin 
    writeln('Sistema de facturacion de telefonia celular');
    leercliente(c);
    leerLinea(l, f, c);
    calcularFactura(f);
    writeln('Su factura es: ', '$', calcularFactura(f):0:2);
  end;
end.
