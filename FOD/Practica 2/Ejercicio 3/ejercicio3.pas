program ejercicio3;
const valorAlto = 'ZZZ';
type
    censo = record
        nom: String;
        cant: Integer;
        total: Integer;
    end;
    encuesta = record
        cod: Integer;
        nom: String;
        cant: Integer;
        total: Integer;
    end;
    detalle = File of encuesta;
    maestro = File of censo;

procedure leer(var det: detalle; var regd: detalle);
begin 
    if not(eof(det)) then
        readLn(det, regd)
    else
        regd.nom:= valorAlto;
end;

procedure min(var det1, det2: detalle; regd1, regd2, min: encuesta);
begin
    if (det1.nom < det2.nom) begin
        min:= det1;
        leer(det1, regd1);
    end else begin
        min:= det2;
        leer(det2, regd2);
    end;
end;

procedure aactualizar_maestro(var mae: maestro; var det1, det2: detalle);
var
    regm: censo;
    min, act, reg1, reg2: encuesta;
begin
    reset(mae);
    reset(det1);
    reset(det2);
    leer(det1); leer(det2);
    writeLn(mae, regm);
    min(det1, det2, reg1, reg2, min);
    
    while (min.nom <> valorAlto) do begin
        act.nom:= min.nom;
        act.cant:= 0;
        act.total:= 0;
        while (min.nom = act.nom) do begin
            act.cant:= act.cant + min.cant;
            act.total:= act.total + min.total;
            min(det1, det2, reg1, reg2, min);
        end;

        while (regm.nom <> act.nom) do
            readLn(mae, regm);
        
        seek(mae, filePos(mae) - 1);
        regm.cant:= regm.cant + act.cant;
        regm.total:= regm..total + act.total;
        writeLn(mae, regm);


end;
var
    mae: mestro;
    det1, det2: detalle;
begin
    assing(mae, 'maestro');
    assign(det1, 'detalle1');
    assing(det2, 'detalle2');

    aactualizar_maestro(mae, det1, det2);
end.
