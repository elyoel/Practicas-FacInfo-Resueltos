pogram actividad_2;
const
type
	años = 2015..2025;
	
	auto = record
		patente: string;
		año: años;
		marca: string;
		color: string;
		modelo: string;
	end;
	
	arbol = ^nodo
	nodo = record
		dato: auto;
		HI: arbol;
		HD: arbol;
	end

    marca = record
	    patente: string;
		color: string;
	end;

	lista = ^nodoL
	nodoL = record
	    dato: marca;
		sig: lista;
	end;

    arbol2 = ^nodo2;
	nodo2 = record
	    marca: string;
		ls: lista;
		HI: arbol2;
		HD: arbol2;

procedure cargarAboles(var a1, a2: arbol);
	procedure leer(var a: auto);
	begin
		WriteLn('Ingrese patente');
		ReadLn(o.patente);
		WriteLn('Ingrese año 2015 - 2025');
		ReadLn(o.año);
		WriteLn('Ingrese marca');
		ReadLn(o.marca);
		WriteLn('Ingrese color');
		ReadLn(o.color);
		WriteLn('Ingrese modelo');
		ReadLn(o.modelo);
	end;
	procedur insertarAdelante(var ls: lista; dato: marca);
	var nuevo: lista;
	begin
	    new(nuevo);
        nuevo^.dato:= dato;
		nuevo^.sig:= ls;
		ls:= nuevo;
	end;
	procedure insertarArbolPatente(var a: arbol, dato: auto);
	begin
		If (a = Nil) then
		begin
			New(a);
			a^.dato:= dato;
			a^.HI:= Nil; a^.HD:= Nil;
		end
		else If (dato.patente >= a^.dato.patente) then insertarAbrol(a^.HD, dato)
			else insertarAbrol(a^.HI, dato);
	end;
	procedure insertarArbolMarca(var a: arbol2, dato: auto);
	var m: marca;
	begin
        m.patente:= dato.patente;
		m.color:= dato.color;

		If (a = Nil) then
		begin
		    new(a);
			a^.HI:= Nil; a^.HD:= Nil;
			a^.marcs:= dato.marca;
			insertarAdelante(a^.ls, m);
		end
		else If (a^.marca = m.marca) then insertarAdelante(a^.lista, m)
		else If (dato.patente > a^.dato.patente) then insertarAbrol(a^.HD, dato)
			else insertarAbrol(a^.HI, dato);
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

//corregir si se procesa o no actividad 1 y 2
var
begin
end.