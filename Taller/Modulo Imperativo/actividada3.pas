program actividad3;
const
	dimF = 8
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
	v_generos = array[generos] of Integer;


procedore insetar(var ls: lista; p: pelicula);
var
	ant, act, nuevo: lista;
begin
	new(nuevo)
	nuevo^.elem:= p;
	ant:= ls; act:= ls;
	
	while (act <> ls) AND (p.cod > act^.elem.cod) do  begin
		ant:= act;
		act:= act^.sig;
	end;
	If (act = ant) then
		ls:= nue;
	else 
		ant^.sig = nuevo;
	nue^.sig:= act
end;
procedure cargar_lista(var ls: lista)
	procedure leer_peli(var p: pelicula);
	begin
		readln(p.cod);
		while (p.cod <> -1) do begin
			read(p.cod_gen);
			read(p.puntaje);
		end;
	end;
var p: pelicula;
begin
	leer_peli(p);
	while (p.cod <> -1) do begin
		insertar(ls, p);
		leer_peli(p);
	end;
end;

procedure generar_vector(var v: v_generos; ls: lista);
var
	actual: pelicula;
	max: Real;
begin
	while (ls <> Nil) do begin
		actual:= ls^.elem;
		max:= ls^.elem.puntaje;
		while (ls <> Nil) AND (actual.cod = ls^.elem.cod) do begin
			If (ls^.elem.puntaje > max) then
				max:= ls^.elem.puntaje;
			ls:= ls^.sig;
		end;
		v[actual.cod]:= max;
	end;
end;

procedure ordenar_vector(var v: v_generos);
var
	i, j, pos: generos;
begin
	for i:= 1 to (dimF - 1) do begin
		pos:= i
		for j:= (i+1) to dimF do begin
		
		end;
	end;
end;

var
begin
end.

