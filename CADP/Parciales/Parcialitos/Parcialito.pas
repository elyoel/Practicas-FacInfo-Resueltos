program Parcialito;
type
    empleado = record 
        apellido: string;
        dni: integer;
        sueldo: real;
    end;

    empleados = array[1.1000] of empleado;

procedure actuMin(unDni: integer; var min: integer);
begin
    if (unDni < min) then min:= unDni;
end;

procedure recorrerArray(v: empleados;var dimL: integer);
var
    i, unDni, minDni: integer;
begin
    minDni:= 9999;
    read(unDni)
    while (unDni <> 0) and (dimL > 0) do
    begin
        i:= 1;
        if (unDni < minDni) do
        begin
            while (i <= dimL) and (v[i].dni < unDni) do i:= i + 1;
            if (i <= dimL) then dimL:= i - 1;
            actuMin(unDni, minDni)
            read(unDni);
        end;
    end;
end;

var
    info_empleados: empleados;
    dimL: integer;
begin
    cargarEmpleados(info_empleados, dimL); //se dispone
    recorrerArray(info_empleados, dimL);
end.
