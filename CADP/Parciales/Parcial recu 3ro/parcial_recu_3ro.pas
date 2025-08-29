program parcial_recu_3ro;
dimF = 5;
type
    obra = record
        titulo: string;
        precio: real;
    end;
    obras: array[1..dimF] of obra;
    expositores = record
        nombre: string;
        apellido: string;
        dni: integer;
        año_presentacion: integer[4]
        obra: obras;
    end;

    nodo_e: lista_e;
    lista_e = record
        elem: expositores;
        sig; nodo_e;
    end;
procedure leer_expositor(var e:expositor);
var i: integer;
begin
    read(e.nombre);
    read(e.apellido);
    read(e.dni);
    read(e.año_presentacion);
    for i:= 1 to dimF do begin
        read(e.obra[i].titulo);
        read(e.obra[i].precio);
    end;
end;
procedure agregar_adelante(var ls: lista_e; e:expositor);
var
    nue: lista_e;
begin
    new(nue);
    nue^.elem:= e;
    nue^.sig:= ls;
    ls:= nue;
end;
procedure agregar_expositor(var ls: lista_e);
var e: expositor;
begin
    write('expositor a agregar');
    leer_expositor(e);
    agregar_adelante(ls, e);
end;
function cumple(n: integer):boolean;
begin
    while (n <> 0) do begin
        if (((n MOD 10) MOD 2) = 0) then
            cumple:= false;
        n:= n DIV 10;
    end;
    cumple:= true;
end;
procedure recorrer_lista(ls: lista_e);
var 
    i, cant: integer;
    min: obra;
begin
    cant:= 0;
    while (ls <> Nil) do begin
        min.precio:= 9999;
        for i:= 1 to dimF do
            if (ls^.elem.obra[i].precio < minP.precio) then
                min:= ls^.elem.obra[i];
        if (cumple(ls^.elem.año_presentacion) and cumple(ls^.elem.dni)) then
            cant:= cant + 1;
        write('titulo de la exposicion con menor valor del expositor ', ls^.elem.nombre, ' es ', min.titulo);
        ls:= ls^.sig;
    end;
    write('cantidad de expositores que tanto su dni como año de exposicion estan conformador por solo digiros impares es ', cant);
end;
var
    lista_expositores: lista_e;
begin
    lista_expositores:= Nil;
    cargarLista(lista_expositores); //se dispone
    agregar_expositor(lista_expositores);
    recorrer_lista(lista_expositores);
end.