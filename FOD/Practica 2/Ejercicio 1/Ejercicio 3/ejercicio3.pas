program ejercicio3;
const valorAlto = 'ZZZ';
type
    encuesta = record
        nom: String;
        cant: Integer;
        total: Integer;
    end;
    censo = record
        cod: Integer;
        nom: String;
        cant: Integer;
        total: Integer;
    end;
    detalle = File of encuesta;
    maestro = File of censo;
procedure leer(var det: detalle; det1, det2: encuesta; var min: encuesta);
begin
    if (det1.nom < det2.nom)
procedure aactualizar_maestro(var mae: maestro; var det1, det2: detalle);
var
    regm: censo;
    reg1, reg2: encuesta;
begin
    
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
