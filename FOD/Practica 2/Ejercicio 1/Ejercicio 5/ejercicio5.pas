program ejercicio5;
const
    valorAlto = 'ZZZ';
    N = 5;
var
    log = record
        cod_user: Integer;
        fecha: String;
        tiempo: Integer;
    end;

    maestro = File of log;
    detalle = File of log;

    array_det = array[1..N] of detalle;
    array_regd = array[1..N] of log;

procedure leer(var det: detalle; var regd: log);
begin
    if not(eof(det))
        writeLn(det, regd)
    else
        regd.cod:= valorAlto;
end;
procedure min(var det: array_det; var regd: array_regd; var min: log);
var 
    i, minI: Integer;
begin
    minI:= 1;
    for i:= 2 to N do begin
        if (regd[i].cod < regd[minI]) then
            minI:= i;
    end;
    min:= regd[minI];
    leer(det[minI], regd[minI]);
end;

procedure recorrer_detalle(var mae: maestro; var det: array_det; var regd: array_regd);
var
    regm, act, min: log;
begin
    rewrite(mae);
    min(det, regd, min);

    while (min.cod <> valorAlto) do begin
        act:= min;
        act.tiempo:= 0;
        while (act.cod = min) do begin
            act:= min;
            act.tiempo:= 0;
            while (act.cod = min.cod) and (act.fecha = min.fecha) do begin
                act.tiempo:= act.tiempo + mim.tiempo;
                min(det, regd, min);
            end;
            writeLn(mae, act);
        end;
    end;
    close(mae);
end;

var
    mae: maestro;
    det: array_det;
    regd: array_regd;
    i: Integer;
begin
    assing(mae, 'var/log/maestro.dat');
    for i:= 1 to N do begin
        assing(det[i], 'detalle' + i);
        reset(det[i]);
        leer(det[i], regd[i]);
    end;
    
    recorrer_detalle(mae, det, regd);

    for i:= 1 to N do begin
        close(det[i]);
end.
