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
	procedure insertarArbolPatente(var a: arbol, dato: auto);
	var
	begin
		If (a = Nil) then
		begin
			New(a);
			a^.dato:= dato
			a^.HI:= Nil; a^.HD:= Nil;
		end
		else If (dato.patente >= a^.dato.patente) then insertarAbrol(a^.HD, dato)
			else insertarAbrol(a^.HI, dato);
	end;
	procedure insertarArbolMarca(var a: arbol, dato: auto);
	var
	begin
		If (a = Nil) then
		begin
			New(a);
			a^.dato:= dato
			a^.HI:= Nil; a^.HD:= Nil;
		end
		else If (dato.patente > a^.dato.patente) then insertarAbrol(a^.HD, dato)
			else insertarAbrol(a^.HI, dato);
	end;
var
begin
end.