program ejercicio6;
type
    novela = record
        cod: Integer;
        nom: String;
        genero: String;
        precio: Real;
    end;

    archivo = File of novela;
procedure cargar_binario(var arc: archivo; var txt: Text);    
var
    n: novela;
begin
    rewrite(arc);
    reset(txt);

    while not(EOF(txt)) do begin
        readLn(txt, n.cod, n.precio, n.genero);
        readLn(txt, n.nom);
        write(arc, n);
    end;
    writeLn('Carga exitosa');
    close(arc);
    close(txt);
end;
procedure leer_novela(var n: novela);
begin
    readLn(n.nom);
    readLn(n.cod);
    readLn(n.precio);
    readLn(n.genero);
end;
procedure modificar_novela(var arc: archivo);
var 
    aux, n: novela;
begin 
    reset(arc);
    writeLn('Ingrese novela a actualizar/añadir: ');
    leer_novela(n);

    while not(eof(arc)) and (aux.cod <> n.cod) do
        read(arc, aux);

    if NOT(eof(arc)) then
        seek(arc, filePos(arc) - 1);
    write(arc, n);

    close(arc);
end;

var
    arc: archivo;
    aux: String;
    txt: Text;
begin
    write('Ingrese nombre de archivo para crear: ');
    readLn(aux);
    assign(arc, aux);
    assign(txt, 'novelas.txt');

    cargar_binario(arc, txt);

    modificar_novela(arc);
end.