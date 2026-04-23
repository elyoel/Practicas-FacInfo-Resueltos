program ejercicio2;
const valorAlto = '9999'
var
    producto = record
        nombre: String;
        precio: Real;
        cod: Integer;
        stock_min: Integer;
        stock_act: Integer;
    end;
    venta = record
        cod: Integer;
        cant: Integer;
    end;

    maestro = File of producto;
    detalle = File of venta;

procedure leer(var det: detalle; var v: venta);
begin
    if not(eof(det)) then
        readLn(det, v)
    else
        v.cod:= valorAlto;
end;

procedure cargar_maestro(var mae: maestro; var det: detalle);
var
    regm: producto;
    act, regd: venta;
begin
    reset(mae);
    reset(det);
    read(mae, regm);
    leer(det, regd);
    while (regd.cod <> valorAlto) do begin
        act.cant:= 0
        act.cod:= regd.cod;

        while (act.cod = regd.cod) do begin
            act.cant:= act.cant + regd.cant;
            leer(det, regd);
        end;

        while (regm.cod <> regd.cod) do
            readLn(mae, regm);
        
        seek(mae, filePos(mae) - 1);
        
        regm.stock_act:= regm.stock_acg - act.cant;

        writeLn(mad, regm);
    end;
end;
