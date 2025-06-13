{Una remisería dispone de información acerca de los viajes realizados durante el mes de mayo de 2020. De
cada viaje se conoce: número de viaje, código de auto, dirección de origen, dirección de destino y
kilómetros recorridos durante el viaje. Esta información se encuentra ordenada por código de auto y para
un mismo código de auto pueden existir 1 o más viajes. Se pide:
a. Informar los dos códigos de auto que más kilómetros recorrieron.
b. Generar una lista nueva con los viajes de más de 5 kilómetros recorridos, ordenada por número de
viaje}
program practica_7_3;
const
  condicion = 5;
type
  viajes = record
    num_viaje: integer;
    cod_auto: integer;
    origen: string;
    destino: string;
    kilo: real;
  end;

  lista_v = ^nodo_v;
  nodo_v = record
    elem: viajes;
    sig: lista_v;
  end;
procedure calcular_max(var max1, max2: viajes; v: viajes);
begin
  if (v.kilo > max1.kilo) then
  begin
    max2:= max1;
    max1:= v;
  end
  else
    if (v.kilo > max2.kilo) then max2:= v;
end;
procedure insertar_ordenado(var ls: lista_v; v: viajes);
var
  nue, act, ant: lista_v;
begin
  new(nue);
  nue^.elem:= v;

  act:= ls;
  act:= ls;

  while (ls <> Nil) and (v.num_viaje < ls^.elem.num_viaje) do
  begin
    ant:= act;
    act:= act^.sig;
  end;
  if (act = ant) then
  begin
    ls:= nue;
  end
  else
    ant^.sig:= nue;
  nue^.sig:= act
end;
procedure recorrer_lista(ls: lista_v; var nue_ls: lista_v);
var
  actual, max1, max2: viajes;
begin
  max1.kilo:= -1;
  while (ls <> Nil) do
  begin
    actual.cod_auto:= ls^.elem.cod_auto;
    actual.kilo:= 0;
    while (ls <> Nil) and (actual.cod_auto = ls^.elem.cod_auto) do
    begin
      actual.kilo:= actual.kilo + ls^.elem.kilo;
      if (ls^.elem.kilo > condicion) then
        insertar_ordenado(nue_ls, ls^.elem);
      ls:= ls^.sig;
    end;
    calcular_max(max1, max2, actual);
  end;
  writeln('Los dos codigos de autos que mas kilometros recorrieron: ', max1.cod_auto, ' ', max2.cod_auto);
end;
var
  lista_viajes, nueva_lista: lista_v;
begin
  crear_lista(lista_viajes)//se dispone.
  nueva_lista:= Nil;
  recorrer_lista(lista_viajes, nueva_lista);
end.