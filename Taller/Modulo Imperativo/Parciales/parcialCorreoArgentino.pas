program parcialCorreoArgentino;
type
    paquete = record
        codEnvio: integer;
        DNImisor: integer;
        DNIreceptor: integer;
        cantObjetos: integer;
        pesoGr: integer;
    end;

    arbol  = ^nodo;
    nodo = record
        dato: paquete;
        HI: arbol;
        HD: arbol;
    end;

    lista = ^nodoL;
    nodoL = record
        dato: paquete;
        sig: lista;
    end;
    procedure leerPaquete(var p: paquete);
    begin
        p.codEnvio := random(101);
        if (p.codEnvio <> 0) then 
        begin
            p.DNImisor := 9 + random(50);
            p.DNIreceptor := 6 + random(50);
            p.cantObjetos := 1 + random(50);
            p.pesoGr := 100 + random(1000);
        end;
    end;
procedure generarArbol(var a: arbol);
    procedure agregarArbol(var a: arbol; p: paquete);
    begin
        If (a = Nil) then
        begin
            new(a);
            a^.HD:=  NiL; a^.HI:=  NiL;
            a^.dato:= p;
        end
        else If (p.pesoGr > a^.dato.pesoGr)  then  agregarArbol(a^.HD, p)
        else agregarArbol(a^.HI, p);
    end;
var
    p: paquete;
begin
    leerPaquete(p);
    While (p.codEnvio <> 0) do
    begin
        agregarArbol(a, p);
        leerPaquete(p);
    end;
end;

    procedure generarLista(a: arbol; var ls: lista; g1, g2: integer);
        procedure agregarAdelante(var ls: lista; p: paquete);
        var nuevo: lista;
        begin
            new(nuevo);
            nuevo^.dato:= p;
            nuevo^.sig:= ls;
            ls:= nuevo;
        end;
    begin
        If (a <> Nil) then
           if (a^.dato.pesoGr > g1) and (a^.dato.pesoGr < g2) then
                agregarAdelante(ls, a^.dato);
            if (a^.dato.pesoGr > g1) then
                generarLista(a^.HI, ls, g1, g2);
            if (a^.dato.pesoGr < g2) then
                generarLista(a^.HD, ls, g1, g2);
    end;

procedure retornarMayor(a: arbol);
    procedure obtenerMaximo(a: arbol; var max: paquete);
    begin
        If (a <> Nil) then
        begin
            If (a^.dato.cantObjetos > max.cantObjetos) then
                max:= a^.dato;
            obtenerMaximo(a^.HD, max);
            obtenerMaximo(a^.HI, max);
        end;
    end;
var max: paquete;
begin
    max.cantObjetos:= -1;
    obtenerMaximo(a, max);
    WriteLn('Paquete con mayor cantidad de objetos');
    WriteLn(max.codEnvio);
    WriteLn(max.DNImisor);
    WriteLn(max.DNIreceptor);
    WriteLn(max.cantObjetos);
    WriteLn(max.pesoGr);
end;
var
    arbolPaquetes: arbol;
    listaRango: lista;
    gr1,  gr2: integer;
begin
    Randomize;
    arbolPaquetes:= Nil;
    listaRango:= Nil;
    generarArbol(arbolPaquetes);

    WriteLn('Ingrese 2 pesos en gramos');
    ReadLn(gr1); ReadLn(gr1);
    generarLista(arbolPaquetes, listaRango, gr1, gr2);

    retornarMayor(arbolPaquetes);
end.