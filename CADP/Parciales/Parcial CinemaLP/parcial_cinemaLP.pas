
{Cinema La Plata desea gestionar la venta de entradas para sus funciones. Este cine cuenta con un sistema de
beneficios que varía según la categoría de los clientes. Para ello, se dispone de una lista que registra, para cada
venta: número de venta, código de función, código de cliente, categoría de cliente (1..10), cantidad de entradas
compradas y precio unitario. Esta información está ordenada por código de función, y para cada función puede
haber una o más ventas. Adicionalmente, el cine dispone de un vector con descuentos en pesos, que depende
de la categoría del cliente.
Se pide recorrer la lista una sola vez para:
a) Generar una nueva lista con el código de función, cantidad de entradas y el monto total recaudado por
las ventas para cada función. Considerar el descuento del cliente. Esta lista debe quedar ordenada por
cantidad de entradas.
b) Actualizar todas las ventas con cantidad de entradas mayor a 5. Modificar la categoría del cliente a 10.
c) Calcular e informar las dos categorías con menor cantidad de entradas vendidas.}
program parcial_cinemaLP;
const
  inf = 1;
  sup = 10;
type
  categorias = inf..sup;
  venta = Record
    num_venta: integer;
    cod_funcion: integer; 
    cat_cli: categorias;
    cant_entradas: integer; -
    precio: real; -
  end;
  listaVentas = ^nodoVentas;
  nodoVentas = Record
    elem: ventas;
    sig: listaVentas;
  end;
  descuentos = array [categorias] of real;
  //se dispone la lista de ventas y los descuentos

  totalVentas = Record
    cod_funcion: integer
    cant_entradas: integer;
    total: real;
  end;
  listaTotal= ^nodoTotal;
  nodoTotal = Record
    elem: totalVentas;
    sig: listaTotal;
  end;
  contador = array [categorias] of integer;

procedure insertar_ordenado(var ls: totalVentas; dato: totalVentas);
var
  nue: totalVentas;
  act, ant: listaTotal; 
begin
    new(nue);
    nue.elem:= dato;
    act:= ls;
    ant:= ls;
    while (act <> Nil) and (act^.elem.cant_entradas < dato.cant_entradas) do
    begin
      ant:= act;
      act:= act^.sig;
    end;
    if (act = ant) then
      ls:= nue;
    else
      ant^.sig:= nue;
    nue^.sig:= act;
end;
procedure inicializarVector(var v: contador);
var i: categorias;
begin
  for i:= inf to sup do
    v[i]:= 0;
end;
procedure calcularDosMin(v: contador);
var
  i: categorias;
  min1, min2, cod1, cod2: integer; 
begin
  min1:= 9999;
  for i:= inf to sup do
  begin
    if (v[i] < min1) then
    begin
      min2:= min1;
      cod2:= cod1;
      min1:= v[i];
      cod1:= i;
    end
    else if(v[i] < min2) then
    begin
      min2:= v[i];
      cod2:= i;
    end;
  end;

  writeln('los dos codigos con menor ventas son: ', cod1, cod2);
end;
procedure recorrer_lista(ls: listaVentas; var nue_ls: totalVentas; desc: descuentos);
var
  actual: integer:
  dato: totalVentas;
  cont: contador;
begin
  inicializarVector(cont);
  while (ls <> Nil) do
  begin
    actual:= ls^.elem.cod_funcion;
    dato.cod_funcion:= actual;
    dato.total:= 0;
    dato.cant_entradas:= 0;
    while (ls <> Nil) and (ls^.elem.cod_funcion = actual) do
    begin
      dato.cant_entradas:= dato.cant_entradas + ls^.elem.cant_entradas;
      dato.precio:= dato.precio + (ls^.elem.precio - desc[ls^.elem.cat_cli]) * ls^.elem.cant_entradas;
      //para el inciso A

      cont[ls^.elem.cat_cli]:= cont[ls^.elem.cat_cli] + ls^.elem.cant_entradas; //para el inciso C
      
      if (ls^.elem.cant_entradas > 5) then
        ls^.elem.cat_cli:= 10;  //inciso B

      ls:= ls^.sig;
    end;
    insertar_ordenado(nue_ls, dato); //para el inciso A
  end;
  calcularDosMin(cont); //inciso C, el proceso los informa
end;
var
  listaPri: listaVentas;
  nueLista: listaTotal;
  descue: descuentos;
begin
  listaPri:= Nil;
  cargarLista(listaPri); //se dispone
  cargarDescuentos(descue); //se dispone
  
  nueLista:= Nil;
  recorrer_lista(listaPri, nueLista, descue);
end.
