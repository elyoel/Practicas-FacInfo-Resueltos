program parcial_tienda_electronica;
const
    maxProd = 2000;
    maxCat = 7;
    condicion = 50000;
type
    categorias = 1..maxCat;
    productos = 1..maxProd;
    producto = Record
        cod_prod: productos
        cod_cat: categorias;
        nombre: string;
        año: integer;
        precio: real;
        marca: string;
    end;
    catalogo = array[productos] of producto;

    venta = Record
        cod_prod: prod
        dni_cli: integer;
        mes: integer;
        año_venta: integer;
    end;

    ls_ventas = ^nodo;
    nodo = Record
        elem: venta;
        sig: ls_ventas;
    end;
    ls_productos = ^nodo1;
    nodo1 = Record
        elem: producto;
        sig: ls_productos;
    end;

    cont = array[productos] of integer;

procedure leer_producto(var p: producto);
begin
    readln(p.cod_cat);
    readln(p.nombre);
    readln(p.año);
    readln(p.precio);
    readln(p.marca);
end;
procedure cargar_catalogo(var cat: catalogo);
var
    p: producto
    i: productos;
begin
    for i = 1 to sup do begin
        leer_producto(p);
        p.cod_prod := i
        cat[i] = p;
    end;
end;
procedure inicializar_vector(var v: cont);
var i: categorias
begin
    for i = 1 to maxCat to
        v[i] = 0;
end;
procedure calcularMin(var cod1, cod2: categorias, v: cont);
var
    i, min1, min2: integer;
begin
    min1 := 9999
    for i = 1 to maxCat do begin
        if (v[i] < min1) then begin
            min2 := min1
            cod2 := cod1;
            min1 := v[i];
            cod := i;
        end;
        else if (v[i] < min2) then begin
                min2 := v[i];
                cod2 := i;
        end;
    end;
end;
function verificar_dni(dni: integer): boolean;
begin
    while (dni <> 0) do begin
        if ((dni MOD 10) MOD 2 <> 0) then
            verficar_dni:= false
        else
            dni:= dni DIV 10;
    end;
    verficar_dni:= true;
end;
procedure insertar_ordenado(var ls: ls_productos, p: producto);
var
    ant, act, nue; ls_productos;
begin
    new(nue);
    nue^.elem := p;
    ant := ls:
    act := ls;

    while (ls <> Nil) and (p.año < ls^.elem.año) do begin
        ant := act;
        act:= ls^.sig;
    end;

    if (act = ant) then
        ls:= nue;
    else
        ant^.sig := nue;
    nue^.sig := act; 
end;

procedure recorrer_lista(ls: ls_ventas; var nue_ls: ls_productos; cata: catalogo);
var
    cont_cat: cont;
    cumple, total, cod1, cod2: integer;
begin
    inicializar_vector(cont_cat);
    cumple := 0;
    total := 0;
    while (ls <> Nil) do begin
        cont_cat[cata[ls^.elem.cod_prod].cod_cat] := cont_cat[cata[ls^.elem.cod_prod].cod_cat] + 1;
       
        if (verificar_dni(ls^.elem.dni) and (cata[ls^.elem.cod_prod].año <= 2023 and cata[ls^.elem.cod_prod].año >= 2018)) then begin
            writeln(cata[ls^.elem.cod_prod].año);
            writeln(cata[ls^.elem.cod_prod].nombre);
        end;

        if (cata[ls^.elem.cod_prod].precio > condicion) then cumple:= cumple + 1;
        total := total + 1;
        
        insertar_ordenado(nue_ls, cata[ls^.elem.cod_prod]);
        
        ls:= ls^.sig;
    end;
    calcularMin(cod1, cod2, cont_cat);
    writeln(cod1, cod2);
    writeln('porcentaje de ventas que supero los ', condicion, ' es: ', (cumple/total)*100);
end;
procedure eliminar(var ls: lista_productos);
var 
    codigo: productos;
    ant, act: ls_productos;
begin
    writeln('codigo a eliminar de la lista');
    readln(codigo);
    ant := ls;
    act := ls;

    while (act^.elem.cod_prod <> codigo) do begin
        ant := act;
        act := act^.sig;
    end;
    
    if (act = ant) then
        ls:= ls^.sig
    else
        ant^.sig := act^.sig;
    dispose(act);
end;
procedure modificar(ls: ls_productos);
var 
    codigo: productos;
    p: producto;
begin
    readln(codigo);
    while (ls^.elem.cod_prod <> codigo) do
        ls := ls^.sig;
    leer_producto(ls^.elem);
end;
procedure insertar_atras(var ls, ult: lista_productos; p: producto,);
var
    nue: lista_productos;
begin
    new(nue);
    nue^.elem := p;
    nue^.sig:= Nil;
    if (ls = Nil) then
        ls:= nue
    else
        ult^.sig := nue;
    ult := nue;
end;
function verificar_codigo(cod):boolean;
var
    par, impar: integer;
begin
    par := 0;
    impar := 0;
    while (cod <> 0) then begin
        if ((cod MOD 10) MOD 2 = 0) then
            par := par + 1;
        else
            impar := impar + 1; 
        cod := cod DIV 10;
    end;
    verificar_codigo := (par = impar);
end;
procedure recorrer_lista_2(ls: ls_productos, var nue_ls: lista_productos);
var
    ult: ls_productos;
begin
    while (ls <> Nil) do begin
        if (verificar_codigo(ls^.elem.cod_prod)) then
            insertar_atras(nue_ls, ult, ls^.elem);
        ls := ls^.sig;
    end;
end;
var
    lista_ventas: ls_ventas;
    catalogo_productos: catalogo;
    lista_productos: ls_productos;
    lista_productos2: ls_productos;
begin
    ls_productos := Nil;
    ls_ventas := Nil;
    cargar_catalogo(catalogo_productos);
    cargar_lista_ventas(lista_ventas); //se dispone;
    recorrer_lista(lista_ventas,  lista_productos, catalogo_productos);
    eliminar(ls_productos);
    modificar(ls_productos);
    recorrer_lista_2(lista_productos, lista_productos2);
end.