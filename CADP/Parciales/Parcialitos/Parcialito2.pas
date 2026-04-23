program Parcialito2;
type 
    categorias = 1..5;
    inscripcion = record
        dni: integer;
        nombre: string[30];
        cat: categorias;
        fecha: string[10];
    end;

    inscriptos = array[1.5000] of inscriptos;
    cont_cat = array[categorias] of integer;

var

begin
    
end.