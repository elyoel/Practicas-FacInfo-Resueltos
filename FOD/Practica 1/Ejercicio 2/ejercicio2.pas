program ejercicio2;
var
    arc: file of Integer;
    nomArc: String;
    cant, num, total: Integer;
    prom: Real;
begin
    prom:= 0;
    cant:= 0;
    total:= 0;
    writeLn('Ingrese nombre de archivo a procesar');
    readLn(nomArc);
    assign(arc, '..\Ejercicio 1\' + nomArc);

    reset(arc);
    while not(EOF(arc)) do begin
        read(arc, num);
        if (num < 1500) then
            cant:= cant + 1;
        total:= total + num;
        prom:= prom + 1;
    end;
    close(arc);
    prom:= total / prom;
    writeLn('Cantidad que supera el 1500: ',  cant);
    writeLn('Promedio de numeros: ', prom:0:2);
end.