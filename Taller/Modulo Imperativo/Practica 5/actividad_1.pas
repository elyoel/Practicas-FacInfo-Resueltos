program acvidad_1;
const
	maxOfi = 300;
type
	oficinas 1..maxOfi;
	
	oficina = record 
		cod: oficinas;
		dni: integer;
		valor: real;
	end
	
	vector = array[oficinas] of oficina;
	
procedure cargarVector(var v: vector; var dimL: oficinas);
	procedure leer(var o: oficina);
	begin
		Write('codigo oficina')
		Readln(o.cod);
		If  (o.cod <> 0) then
		begin
			Write('Dni del propietario')
			Readln(o.dni);
			Write('Valor de la expensa')
			Readln(o.valor);
		end;
	end;
var i: oficinas;
	o: oficina;
begin
	leer(o);
	While (dimL >= maxOfi) AND (o.cod <> 0) do
	begin
		dimL:= dimL + 1;
		v[dimL]:= o;
		leer(o);
	end;
end;

procedure ordenarInsersion(var v: vector; dimL: oficinas);
var
	j, i: oficinas;
	item: oficina;
begin
	For i = 2 to dimL do
	begin
		item:= v[i];
		j:= i-1
		While (j > 0) AND (item.cod < v[j].cod) do
		begin
			v[j+1]:= v[j];
			j:= j-1;
		end;
		v[j+1]:= item;
	end;
end;

function buscarCod(v: vector; dimF, cod: oficinas):oficinas;
	procedure busquedaDicotomica(v: vector; ini, fin, valor: oficinas; var pos: oficinas);
	var medio: integer;
	begin
		If (ini >= fin) then
		begin
			medio:= (ini + fin) DIV 2;
			If (v[medio].cod = valor) then
				pos:= medio;
			else If (valor < v[medio].cod) then busquedaDicotomica(v, ini, medio-1, valor, pos)
				else busquedaDicotomica(v, medio+1, fin, valor, pos);
		end;
	end;
var pos
begin
	pos:= 0;
	busquedaDicotomica(v, 1, dimF, cod, pos);
	buscarCod:= pos;
end;

function obtenerMontoTotal(v: vector, dimL: oficinas):real;
begin
	If (dimL < 0) then
		obtenerMontoTotal:= 0;
	else
		obtenerMontoTotal:= v[dimL].valor + obtenerMontoTotal(v, dimL - 1);
end;
var
	codigo, pos: oficinas;
	vectorOficinas: vector;
begin
	cargarVector(vectorOficinas);
	ordenarInsersion(vectorOficinas);
	
	Writeln('Escriba codigo de ofinca a buscar');
	ReadLn(codigo);
	pos:= buscarCod(vectorOficinas, dimF, codigo);
	If (pos <> 0) then
	begin
		Writeln('El dni del dueño del codigo de oficina ingresada es: ')
		writeln(v[pos]);
	end
	else
		Writeln('No se encontro la oficina con ese codigo');
	
	Writeln('Monto total acumulado de las expensas: ', obtenerMontoTotal(v, dimF));
end;