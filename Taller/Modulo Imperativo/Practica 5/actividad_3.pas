{3. PlayStation Store requiere procesar las compras realizadas por sus clientes durante el año 2023.
a) Implementar un módulo que lea compras de videojuegos. De cada compra se lee
código del videojuego, código de cliente y mes. La lectura finaliza con el código de
cliente 0. Se sugiere utilizar el módulo leerCompra(). El módulo debe retornar un árbol
binario de búsqueda ordenado por código de videojuego. En el árbol, para cada código
de videojuego debe almacenarse una lista con código de cliente y mes perteneciente a
cada compra.
b) Implementar un módulo que reciba el árbol generado en a) y un código de videojuego.
El módulo debe retornar la lista de las compras de ese videojuego.
c) Implementar un módulo recursivo que reciba la lista generada en b) y un mes. El
módulo debe retorne la cantidad de clientes que compraron en el mes ingresado.
NOTA: Implementar el programa principal, que invoque a los incisos a, b y c}

program actividad_3;
type
    compra = record
        cod_videojuego : integer;
        cod_cliente : integer;
        mes : integer;
    end;
    cliente = record
        cod_cliente: integer;
        mes:  integer;
    end;

    lista = ^nodoL;
    nodoL = record
        dato: cliente;
        sig: lista;
    end;

    videojuego = record
        cod_videojuego: integer;
        ls: lista;
    end;

    arbol = ^nodo;
    nodo = record
        dato: videojuego;
        HD: arbol;
        HI: arbol;
    end;

procedure leerCompra (var c : compra);
begin
    c.cod_cliente := Random(200);
    if (c.cod_cliente <> 0) then
    begin
        c.mes := Random(12) + 1;
        c.cod_videojuego := Random(200) + 1000;
    end;
end;
procedure generarArbol(var a: arbol);
    procedure insertarAdelante(var ls: lista; c: cliente);
    var nuevo: lista;
    begin
        new(nuevo);
        nuevo^.dato:= c;
        nuevo^.sig:= ls;
        ls:= nuevo;
    end;
    procedure insertarArbol(var a: arbol; c: compra);
    var cli: cliente;
    begin
        cli.cod_cliente:= c.cod_cliente;
        cli.mes:= c.mes;
        If (a = Nil) then
        begin
            new(a);
            a^.HI:= Nil; a^.HD := Nil;
            a^.dato.cod_videojuego:= c.cod_videojuego;
            insertarAdelante(a^.dato.ls, cli);
        end
        else If (a^.dato.cod_videojuego = c.cod_videojuego) then insertarAdelante(a^.dato.ls, cli)
        else If (a^.dato.cod_videojuego > c.cod_videojuego) then insertarArbol(a^.HI, c)
        else insertarArbol(a^.HD, c);
    end;
var c: compra;
begin
    leerCompra(c);
    While (c.cod_cliente <> 0) do
    begin
        insertarArbol(a, c);
        leerCompra(c);
    end;
end;
function obtenerLista(a: arbol; cod: integer):lista;
begin
    If (a = Nil) then
        obtenerLista:= Nil
    else If (a^.dato.cod_videojuego = cod) then obtenerLista:= a^.dato.ls
    else If (cod > a^.dato.cod_videojuego) then obtenerLista:= obtenerLista(a^.HD, cod)
    else  obtenerLista:= obtenerLista(a^.HI, cod);
end;

function contarClientes(ls: lista; mes: integer): integer;
begin
    If (ls = Nil) then
        contarClientes:= 0
    else If (ls^.dato.mes = mes) then contarClientes:= 1 + contarClientes(ls^.sig, mes)
    else contarClientes:= contarClientes(ls^.sig, mes);
end;
var
    arbolVideojuegos: arbol;
    nueLista: lista;
    int: integer;
begin
    Randomize;
    arbolVideojuegos:= Nil;
    generarArbol(arbolVideojuegos);

    WriteLn('Escriba codigo de videojuego: ');
    ReadLn(int);
    nueLista:= obtenerLista(arbolVideojuegos, int);
    If (nueLista = Nil) then WriteLn('Codigo de videojuego no existe')
    else begin
        WriteLn('Ingrese numero de mes: ');
        ReadLn(int);
        WriteLn('Cantidad de clientes que compraron en el mes ingresado: ');
        WriteLn(contarClientes(nueLista, int));
    end;     
end.