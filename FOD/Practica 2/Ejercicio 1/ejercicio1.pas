program ejercicio1;
const valoralto = '9999';
type
    ingreso = record
        cod: Integer;
        nom: String;
        monto: Real;
    end;
    archivo = File of ingreso;
    
procedure leer( var arc: archivo; var dato: ingreso);
begin
    if (not(eof(archivo))) then
        read (archivo, dato)
    else
        dato.cod := valoralto;
end;

procedure compactar_datos(var mae, det: archivo);
var
    reg, act: ingreso;
begin
    reset(det);
    rewrite(mae);
    leer(dat, reg);

    while (reg.cod <> valoralto) do begin
        act.cod:= reg.cod;
        act.monto:= 0;

        while (act.cod = reg.cod) do begin
            act.monto:= act.monto + reg.monto;
            leer(det, reg);
        end;
        writeLn(mae, act);
    end;
    
    close(mae);
    close(det);
end;
var
    det, mae: archivo;
begin
    assign(det, );
    assign(mae, );

    compactar_datos(mae, det);
end.

    