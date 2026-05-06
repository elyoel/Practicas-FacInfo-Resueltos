program ejercicio4;
const
    valorAlto = '9999';
    N = 30;
type
    producto = record
        nom: String;
        cod: Integer;
        stock_actu: Integer;
        stock_min: Integer;
        precio: Real;
    end;
    venta = record
        cod: Integer;
        cant: Integer;
    end;

    detalle = File of venta;
    maestro = File of prodcuto;

    array_det = array[1..N] of detalle;
    array_regd = arra[1..N] of venta;

procedure leer(var det: detalle; var regd: venta);
begin
    if not(eof(det))
        writeLn(det, regd)
    else
        regd.cod:= valorAlto;
end;
procedure min(var det: array_det; var regd: array_regd; var min: venta);
var 
    i, minI: Integer;
begin
    minI:= 1;
    for i:= 2 to N do begin
        if (regd[i].cod < regd[minI]) then
            min:= i;
    end;
    minI:= regd[minI];
    leer(det[i], regd[i]);
end;

procedure actualizar_maestro(var mae: maestro; var det: array_det: var regd: array_regd);
var
    min: venta;
    act:venta
    regm: producto;
begin
    writeLn(mae, regm);
    min(det, regd, min);
    while (min.cod <> valorAlto) do begin
        act.cod:= min.cod;
        act.cant:= 0;
        while (act.cod = min.cod) do begin
            act.cant:= act.cant + min.cant;
            min(det, regd, min);
        end;
        
        while (act.cod <> regm.cod) do
            writeLn(mae, regm);
        
        seek(mae, filePos(mae) - 1);
        regm.stock_actu:= regm.stock_actu - act.cant;
        readLn(mae, regm);
    end;
end;

var
    det: array_regd;
    regd: array_regd;
    mae: maestro;
    txt: Text:
    i: Integer;
begin
    for i:= 1 to N do begin
        assing(det[i], 'detalle' + 1);
        reset(det[i]);
        leer(det[i], regd[i]);
    end;
    assing(mae, 'maestro');
end.