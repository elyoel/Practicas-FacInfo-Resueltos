program parcialPlayStation_2022;
type
    sub_dia = 1..31;
    sub_mes = 1..12;
    compra = record
        videojuego : integer;
        cliente : integer;
        dia : sub_dia;
        mes : sub_mes;
    end;

    lista = ^nodoL;
    nodoL = record
        dato: compra;
        sig: lista;
    end;
    cliente = record
        cod_cliente: integer;
        ls: lista;
    end;
    arbol = ^nodo;
    nodo = record
        dato: cliente;
        HD: arbol;
        HI: arbol;
    end;
    mes = record
        cod_mes: integer;
        cant: integer;
    end;
    vector = array[sub_mes] of mes;
procedure leerCompra(var c : compra);
begin
    c.cliente := Random(100);
    if (c.cliente <> 0) then 
    begin
        c.dia := Random(31) + 1;
        c.mes := Random(12) + 1;
        c.videojuego := Random(20000) + 1;
    end;
end;
procedure generarEstructuras(var a: arbol; v: vector);
    procedure insertarAdelante(var ls: lista; dato: compra);
    var nuevo: lista;
    begin
        new(nuevo);
        nuevo^.dato:= dato;
        nuevo^.sig:= ls;
        ls:= nuevo;
    end;
    procedure insertarArbol(var a: arbol; dato: compra);
    begin
        If (a = Nil) then
        begin
            new(a);
            a^.dato.cod_cliente:= dato.cliente;
            insertarAdelante(a^.dato.ls, dato);
        end
        else If (a^.dato.cod_cliente = dato.cliente) then insertarAdelante(a^.dato.ls, dato)
        else If (dato.cliente > a^.dato.cod_cliente) then insertarArbol(a^.HD, dato)
        else insertarArbol(a^.HI, dato);
    end;
    procedure inicializarVector(var v: vector);
    var i: sub_mes;
    begin   
        For i:= 1 to 12 do 
        begin
            v[i].cod_mes:= i;
            v[i].cant:= 0;
        end;
    end;

var c: compra;
begin 
    inicializarVector(v);    
    leerCompra(c);
    While (c.cliente <> 0) do 
    begin
        insertarArbol(a, c);
        v[c.mes].cant:= v[c.mes].cant + 1;
        leerCompra(c); 
    end;
end;
procedure retornarComprasCliente(a: arbol; cod: integer);
    procedure imprimirCompra(ls: lista);
    begin
        While (ls <> Nil) do
        begin
            WriteLn(ls^.dato.videojuego);
            WriteLn(ls^.dato.dia);
            WriteLn(ls^.dato.mes);
            ls:= ls^.sig;
        end;
    end;
begin
    If (a = Nil) then WriteLn('El cliente no realizo ninguna compra')
    else If (a^.dato.cod_cliente = cod) then imprimirCompra(a^.dato.ls)
    else If (a^.dato.cod_cliente > cod) then retornarComprasCliente(a^.HI, cod)
    else retornarComprasCliente(a^.HD, cod);
end;
procedure ordenarInsercion(var v: vector);
var i, j: integer;
    item: mes;
begin
    For i:= 2 to 12 do
    begin   
        item:= v[i];
        j:= i - 1;
        While (j > 0) AND (v[j].cant > item.cant) do
        begin
            v[j+1]:= v[j];
            j:= j - 1;
        end;
        v[j+1]:= item;
    end;
end;
var
    arbolCompras: arbol;
    vectorMes: vector;
    cod: integer;
begin
    Randomize;
    arbolCompras:= Nil;
    generarEstructuras(arbolCompras, vectorMes);

    WriteLn('Ingrese codigo de cliente');
    ReadLn(cod);
    retornarComprasCliente(arbolCompras, cod);
    
    ordenarInsercion(vectorMes);
end.