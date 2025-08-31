{4.- Una librería requiere el procesamiento de la información de sus productos. De cada
producto se conoce el código del producto, código de rubro (del 1 al 6) y precio.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de los productos y los almacene ordenados por código de producto y
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza
cuando se lee el precio -1.
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
c. Genere un vector (de a lo sumo 20 elementos) con los productos del rubro 3. Considerar que
puede haber más o menos de 20 productos del rubro 3. Si la cantidad de productos del rubro 3
es mayor a 20, almacenar los primeros 30 que están en la lista e ignore el resto.
d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos
métodos vistos en la teoría.
e. Muestre los precios del vector resultante del punto d).
f. Calcule el promedio de los precios del vector resultante del punto d).}

program actividad4;
const
    maxRubro = 6;
    dimF = 30;
type
    rubros: 1..maxRubro;
    producto = Record
        codigo: Integer;
        cod_rubro: rubros
        precio: Real;
    end;

    lista: ^nodo;
    nodo  = Record
        elem:  producto;
        sig: lista;
    end;

    v_lista  = array[rubros] of lista;
    v_producto  = array[1..dimF] of producto;

procedure insertar_ordenado(var ls: lista; elem: producto);
var
    ant, act, nuevo: lista;
begin
    new(nuevo);
    nuevo^:= elem
    act:= ls, ant;= ls;
    While (act <> Nil) AND (elem.codigo > act^.elem.codigo) do
    begin
        ant:= act;
        act:= act^.sig;
    end;
    If (act = ant) then
        ls:= nuevo;
    Else
        ant^.sig := nuevo;
    nuevo^.sig:= act;
end;

procedure cargar_lista(v: v_lista);
    procedure inicializar_vector(var v: v_lista);
    var i: rubros;
    begin
        for i:= 1 to maxRubro do
            v[i]:= Nil;
    end;
    procedure leer_producto(var p: producto);
    begin
        WriteLn('Ingrese precio:');
        ReadLn(p.precio);
        If (p.precio <> -1); then
        begin
        WriteLn('Ingrese Codigo:');
        ReadLn(p.codigo);
        WriteLn('Ingrese Codigo de rubro:');
        ReadLn(p.cod_rubro);
        end;
    end;
var
    i: rubros;
    p: producto;
begin
    inicializar_vector(v);
    leer_producto(p);
    While (p.precio <> -1) do
    begin
        insertar_ordenado(v[p.rubro], p);
        leer_producto(p);
    end;
end;

procedure imprimir_codigo_por_rubro(v: v_lista);
    procedure imprimir_codigos(ls: lista);
    begin
        While (ls <> Nil) do
        begin
            WriteLn('Producto con Codigo: ', ls^.elem.codigo);
            ls:= ls^.sig
        end;
    end;
var i: rubros;
begin
    for i:= 1  to maxRubro do
    begin
        WriteLn('Los codigos del Rubro: ', i);
        WriteLn('Son: ')
        imprimir_codigos(v[i]);
    end;
end;

procedure generar_vector(var v: v_producto; var dimL: Integer; ls: lista);
var 
begin
    dimL:= 0;
    While (ls <> Nil) AND (dimL <= dimF) do
    begin
        dimL:= dimL + 1;
        v[dimL]:= ls^.elem;
        ls:= ls^.sig;
    end
end;

procedure ordenar_vector(var v: v_producto; dimL: Integer);
var
    i, j: integer
    actual: producto;
begin
    For i:= 2 to dimL do
    begin
        actual:= v[i];
        j:= i-1;
        While (j > 0) AND (v[j] > actual.precio) do
        begin
            v[j+1]:= v[j];
            j:= j - 1;
        end;
        v[j+1]:= actual;
    end;
end;

procedure mostrar_vector(v: v_producto; dimL);
var i: Integer;
begin
    WriteLn('Los precios del vector resultante: ')
    For i:= 1 to dimL do
        WhileLn(v[i].precio);
end;

function promediar(v: v_producto, dimL: Integer):Real;
var 
    i:= Integer
    total:= Real;
begin
    total:= 0;
    For i:= 1 to dimL do
        total:= total + v[i].precio;
    promediar:= (total/dimL)*100;
end;

var
    vector_listas: v_lista;
    vector_productos: v_producto;
    dimL: Integer;
begin
    cargar_lista(vector_listas);
    imprimir_codigo_por_rubro(vector_listas[3]);
    generar_vector(vector_productos, dimL, vector_listas);
    ordenar_vector(vector_productos, dimL);
    mostrar_vector(vector_productos, dimL);
    WriteLn('El promedio de los precios del vector resultante', promediar(vector_productos, dimL));
end.