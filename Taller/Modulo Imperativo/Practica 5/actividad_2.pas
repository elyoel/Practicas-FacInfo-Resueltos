program actividad_2;
const
	minAnio = 2015;
	maxAnio = 2024;
type
	anios = minAnio..maxAnio;
	
	auto = record
		patente: string;
		anio: anios;
		marca: string;
		color: string;
		modelo: string;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato: auto;
		HI: arbol;
		HD: arbol;
	end;

    marca = record
	    patente: string;
		color: string;
	end;
	listaMarca = ^nodoMarca;
	nodoMarca = record
	    dato: marca;
		sig: listaMarca;
	end;

    arbol2 = ^nodo2;
	nodo2 = record
	    marca: string;
		ls: listaMarca;
		HI: arbol2;
		HD: arbol2;
	end;
	
	listaAuto = ^nodoAuto;
	nodoAuto = record
		dato: auto;
		sig: listaAuto;
	end;
	vector = array[anios] of listaAuto;

procedure cargarAboles(var a1: arbol; var a2: arbol2);
	procedure leer(var a: auto);
	begin
		WriteLn('Ingrese marca');
		ReadLn(a.marca);
		If (a.marca <> 'MMM') then
		begin
			WriteLn('Ingrese patente');
			ReadLn(a.patente);
			WriteLn('Ingrese Año 2015 - 2025');
			ReadLn(a.anio);
			WriteLn('Ingrese color');
			ReadLn(a.color);
			WriteLn('Ingrese modelo');
			ReadLn(a.modelo);
		end;
	end;
	procedure insertarAdelante(var ls: listaMarca; dato: marca);
	var nuevo: listaMarca;
	begin
	    new(nuevo);
        nuevo^.dato:= dato;
		nuevo^.sig:= ls;
		ls:= nuevo;
	end;
	procedure insertarArbolPatente(var a: arbol; dato: auto);
	begin
		If (a = Nil) then
		begin
			New(a);
			a^.dato:= dato;
			a^.HI:= Nil; a^.HD:= Nil;
		end
		else If (dato.patente >= a^.dato.patente) then insertarArbolPatente(a^.HD, dato)
			else insertarArbolPatente(a^.HI, dato);
	end;
	procedure insertarArbolMarca(var a: arbol2; dato: auto);
	var m: marca;
	begin
        m.patente:= dato.patente;
		m.color:= dato.color;

		If (a = Nil) then
		begin
		    new(a);
			a^.HI:= Nil; a^.HD:= Nil;
			a^.marca:= dato.marca;
			insertarAdelante(a^.ls, m);
		end
		else If (a^.marca = dato.marca) then 
			insertarAdelante(a^.ls, m)
		else If (dato.marca > a^.marca) then 
			insertarArbolMarca(a^.HD, dato)
		else 
			insertarArbolMarca(a^.HI, dato);
	end;
var a: auto;
begin
    leer(a);
	While (a.marca <> 'MMM') do
	begin
	    insertarArbolPatente(a1, a);
		insertarArbolMarca(a2, a);
		leer(a);
	end;
end;

function contarAutosMarca(a: arbol;  marca: string):integer;
	procedure recorrerArbol(a: arbol; marca: string; var cant: integer);
	begin
		If (a <> Nil) then
		begin
			If (a^.dato.marca = marca) then
				cant:= cant + 1;
			recorrerArbol(a^.HI, marca, cant);
			recorrerArbol(a^.HD, marca, cant);
		end;
	end;
var cant: integer;
begin
	cant:= 0;
	recorrerArbol(a, marca, cant);
	contarAutosMarca:= cant;
end;

function contarAutosMarca2(a: arbol2; marca: string):integer;
	function contarCant(ls: listaMarca):integer;
	var  cant: integer;
	begin
		cant:= 0;
		While (ls <> Nil) do
		begin
			cant:= cant + 1;
			ls:=  ls^.sig;
		end;
		contarCant:= cant;
	end;
begin
	If (a = Nil) then
		contarAutosMarca2:= 0
	else If (a^.marca = marca) then contarAutosMarca2:= contarCant(a^.ls)
		else If (a^.marca  > marca) then contarAutosMarca2(a^.HI, marca)
		else contarAutosMarca2(a^.HD, marca);
end;
procedure generarVector(var v: vector; a: arbol);
	procedure inicializarVector(var v: vector);
	var i: anios;
	begin
		For i:= minAnio to maxAnio do
			v[i]:= Nil;
	end;
	procedure insertarAdelante(var ls: listaAuto; a: auto);
	var nuevo: listaAuto;
	begin
		new(nuevo);
		nuevo^.dato:= a;
		nuevo^.sig:= ls;
		ls:= nuevo;
	end;
	procedure recorrerArbol(a: arbol; var v: vector);
	begin
		If (a <> Nil) then
		begin
			insertarAdelante(v[a^.dato.anio], a^.dato);
			recorrerArbol(a^.HD, v);
			recorrerArbol(a^.HI, v);
		end;
	end;
begin
	inicializarVector(v);
	recorrerArbol(a, v);
end;

procedure buscarPatente(a: arbol; p: string);
	procedure recorrer(a: arbol; p: string; var modelo: string);
	begin
		If (a <> Nil) then
			If (a^.dato.patente = p) then modelo:= a^.dato.modelo
			else  If (a^.dato.patente > p) then recorrer(a^.HI, p, modelo)
			else recorrer(a^.HD, p, modelo);
	end;
var modelo: string;
begin
	recorrer(a, p, modelo);
	WriteLn('Modelo del auto con dicha patente: ', modelo);
end;

procedure buscarPatente2(a: arbol2; p: string);
begin
{f) Invoque a un módulo que reciba el árbol generado en a) ii y una patente y devuelva el
color del auto con dicha patente. INEFICIENTE}
end;
var
	arbolPatente: arbol;
	arbolMarca: arbol2;
	str: string;
	vectorAuto: vector;
begin
	//Inciso A
	cargarAboles(arbolPatente,  arbolMarca);

	//Inciso B
	WriteLn('Ingrese marca: ');
	ReadLn(str);
	WriteLn('Cantidad de autos de dicha marca que posee la agencia: ', contarAutosMarca(arbolPatente, str));

	//Inciso C
	WriteLn('Ingrese marca: ');
	ReadLn(str);
	WriteLn('Cantidad de autos de dicha marca que posee la agencia: ', contarAutosMarca2(arbolMarca, str));

	//Inciso D
	generarVector(vectorAuto, arbolPatente);

	//Inciso E
	WriteLn('Ingrese patente: ');
	ReadLn(str);
	buscarPatente(arbolPatente, str);

	//Inciso F
	WriteLn('Ingrese patente: ');
	ReadLn(str);
	buscarPatente2(arbolMarca, str);
end.