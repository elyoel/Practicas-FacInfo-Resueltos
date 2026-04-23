program ejercicio5;
type
    celular = record
        cod: Integer;
        nombre: String;
        descripcion: String;
        marca: String;
        precio: Real;
        stock_min: Integer;
        stock_actual: Integer;
    end;

    archivo = File of celular;
procedure cargar_binario(var arc: archivo; var txt: Text);
var
    c: celular;
begin
    rewrite(arc);
    reset(txt);

    while not(EOF(txt)) do begin
        readLn(txt, c.cod, c.precio, c.marca);
        readLn(txt, c.stock_actual, c.stock_min, c.descripcion);
        readLn(txt, c.nombre);

        write(arc, c);
    end;

    close(txt);
    close(arc);
end;


var 
    arc: archivo;
    texto: Text;
    aux: String;
begin
    read(aux);
    assign(arc, aux);
    assign(texto, 'celulares.txt');
    
    cargar_binario(arc, texto);

    
end.
