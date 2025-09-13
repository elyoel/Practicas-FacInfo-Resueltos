{4. La Feria del Libro necesita un sistema para obtener estadísticas sobre los libros
presentados.
a) Implementar un módulo que lea información de los libros. De cada libro se conoce:
ISBN, código del autor y código del género (1: literario, 2: filosofía, 3: biología, 4: arte,
5: computación, 6: medicina, 7: ingeniería) . La lectura finaliza con el valor 0 para el
ISBN. Se sugiere utilizar el módulo leerLibro(). El módulo deber retornar dos
estructuras:
i. Un árbol binario de búsqueda ordenado por código de autor. Para cada código de autor
debe almacenarse la cantidad de libros correspondientes al código.
ii. Un vector que almacene para cada género, el código del género y la cantidad de libros del
género.
b) Implementar un módulo que reciba el vector generado en a), lo ordene por cantidad
de libros de mayor a menor y retorne el nombre de género con mayor cantidad
cantidad de libros.
c) Implementar un módulo que reciba el árbol generado en a) y dos códigos. El módulo
debe retornar la cantidad total de libros correspondientes a los códigos de autores
entre los dos códigos ingresados (incluidos ambos).
NOTA: Implementar el programa principal, que invoque a los incisos a, b y c.}
program actividad_4;
const maxGen = 7;
type 
    subGenero = 1..maxGen;
    libro = record
        isbn : integer;
        codAutor : integer;
        genero : subGenero;
    end;
    //Nose usarlo: var v: array [subGenero] of string = ('literario', 'filosofía', 'arte', 'biología', 'computación', 'medicina', 'ingeniería');
    v_gen = array[subGenero] of string;
    autor = record
        cod_autor: integer;
        cant: integer;
    end;

    arbol = ^nodo;
    nodo = record
        dato: autor;
        HI: arbol;
        HD: arbol;
    end;
    genero = record
        cod_gen: subGenero;
        cant: integer;
    end;
    vector = array[subGenero] of genero;

procedure leerLibro (var l : libro);
begin
    l.isbn := Random(1000);
    if (l.isbn <> 0) then 
    begin
        l.codAutor := Random(300) + 100;
        l.genero := Random(7) + 1;
    end;
end;
procedure generarEstructuras(var a: arbol; var v: vector);
    procedure insertarArbol(var a: arbol; l: libro);
    begin
        If (a = Nil) then
        begin   
            new(a);
            a^.HD:= Nil; a^.HI:= Nil;
            a^.dato.cod_autor:= l.codAutor;
            a^.dato.cant:= 1;
        end
        else If (a^.dato.cod_autor = l.codAutor) then a^.dato.cant:= a^.dato.cant + 1
        else If (a^.dato.cod_autor > l.codAutor) then insertarArbol(a^.HI, l)
        else insertarArbol(a^.HD, l);
    end;
    procedure inicializarVector(var v: vector);
    var i: integer;
    begin
        For i := 1 to maxGen do
        begin
            v[i].cod_gen:= i;
            v[i].cant:= 0;
        end;
    end;
var l: libro;
begin
    inicializarVector(v);
    leerLibro(l);
    While (l.isbn <> 0) do
    begin
        insertarArbol(a, l);
        v[l.genero].cant := v[l.genero].cant + 1;
        leerLibro(l);
    end;
end;

procedure ordenarYretornar(var v: vector; v_nombres: v_gen);
    procedure ordenarInsercion(var v: vector);
    var 
        i, j: integer;
        item: genero;
    begin
        For i:= 2 to maxGen do
        begin
            item:= v[i];
            j:= i - 1;
            While (j > 0) AND (v[j].cod_gen < item.cod_gen) do
            begin
                v[j+1]:= v[j]; 
                j:= j-1;
            end;
            v[j+1]:= item;
        end;
    end;
begin
    ordenarInsercion(v);
    WriteLn('nombre de género con mayor cantidad cantidad de libros: ');
    WriteLn(v_nombres[v[maxGen].cod_gen]);
    
end;

function totalLibros(a: arbol; cod1, cod2: integer): integer;
    function cantLibros(a: arbol; cod: integer): integer;
    begin
        If (a = Nil) then 
            cantLibros:= 0
        else If (a^.dato.cod_autor = cod) then cantLibros:= a^.dato.cant
        else If (a^.dato.cod_autor > cod) then cantLibros:= cantLibros(a^.HI, cod)
        else cantLibros:= cantLibros(a^.HD, cod);
    end;
begin
    totalLibros:= cantLibros(a, cod1) + cantLibros(a, cod2);
end;
var
    vec_gen: v_gen = ('literario', 'filosofía', 'arte', 'biología', 'computación', 'medicina', 'ingeniería');
    arbolAutores: arbol;
    vectorGeneros: vector;
    int1, int2: integer;
begin
    Randomize;
    generarEstructuras(arbolAutores, vectorGeneros);
    ordenarYretornar(vectorGeneros, vec_gen);

    WriteLn('Ingrese 2 codigos de autor: ');
    ReadLn(int1);
    ReadLn(int2);
    WriteLn('la cantidad total de libros correspondientes a los códigos de autores entre los dos códigos ingresados (incluidos ambos)');
    WriteLn(totalLibros(arbolAutores, int1, int2));
end.