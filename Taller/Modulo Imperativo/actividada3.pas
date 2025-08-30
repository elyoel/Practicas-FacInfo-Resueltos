program actividad3;
const
	dimF = 8;
type
	generos = 1..dimF;
	
	pelicula = record
		cod: Integer;
		cod_gen: generos;
		puntaje: Real;
	end;
	
	lista = ^nodo;
	nodo = Record
		elem: pelicula;
		sig: lista;
	end;
	v_peliculas = array[generos] of lista;
	v_maximos = array[generos] of pelicula;

procedure insertar_atras(var pri, ult: lista; elem: pelicula);
var nue : lista;
begin
new (nue);
	nue^.elem:= elem;
	nue^.sig := Nil;
	if (pri <> Nil) then
		ult^.sig := nue
	else
		pri := nue;
	ult := nue;

end;
procedure cargar_lista(var v: v_peliculas);
	procedure inicializar_vector(var v: v_peliculas);
	var i: generos;
	begin
		for i:= 1 to dimF do
			v[i] := Nil;
	end;
	procedure leer_peli(var p: pelicula);
	begin
    WriteLn('Ingrese Codigo');
		readln(p.cod);
		If (p.cod <> -1) then begin
      WriteLn('Ingrese Genero');
			read(p.cod_gen);
      WriteLn('Ingrese Puntaje');
			read(p.puntaje);
      
		end;
	end;

var 
	p: pelicula;
	v_ult: v_peliculas;
begin
	inicializar_vector(v_ult);
  inicializar_vector(v);
	leer_peli(p);
	while (p.cod <> -1) do begin
		insertar_atras(v[p.cod], v_ult[p.cod], p);
		leer_peli(p);
	end;
end;

procedure generar_vector(var v_max: v_maximos; v_peli: v_peliculas);
	procedure buscarCodMax(ls: lista; var max: pelicula);
	begin
		max.puntaje:= -1;
		while (ls <> Nil) do begin
			if  (ls^.elem.puntaje > max.puntaje) then begin
				max:= ls^.elem;
			end;
			ls:= ls^.sig;
		end;
	end;
var
	i:  integer;
	max: pelicula;
begin
	for  i:=  1 to dimF do begin
		buscarCodMax(v_peli[i], max);
		v_max[i]:= max;
	end;
end;

procedure ordenar_vector(var v: v_maximos);
var
	i, j, pos: generos;
	item: pelicula;
begin
	for i:= 1 to (dimF - 1) do begin
		pos:= i;
		for j:= (i+1) to dimF do
			if (v[j].puntaje < v[pos].puntaje) then pos:= j; 
		
		item := v[pos];
        v[pos] := v[i];   
        v[ i ] := item;
	end;
end;
procedure imprmir(v_maximos);
begin
	WriteLn('código de película con mayor puntaje y el código de película con menor puntaje')
	WriteLn(vector_max[1].cod, ' ', vector_max[8].cod);

end;
var
	vector_peliculas: v_peliculas;
	vector_max: v_maximos;
begin
	cargar_lista(vector_peliculas);
	generar_vector(vector_max, vector_peliculas);
	ordenar_vector(vector_max);

end.