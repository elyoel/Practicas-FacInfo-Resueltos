{a. Implemente un módulo que genere aleatoriamente información de ventas de un comercio. 
Para cada venta generar código de producto, fecha y cantidad de unidades vendidas. Finalizar 
con el código de producto 0. Un producto puede estar en más de una venta. Se pide: 
i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de 
producto. Los códigos repetidos van a la derecha. 
ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por 
código de producto. Cada nodo del árbol debe contener el código de producto y la 
cantidad total de unidades vendidas. 
iii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por 
código de producto. Cada nodo dell árbol debe contener el código de producto y la lista de 
las ventas realizadas del producto.}
program practica_1;
type
	venta = record 
		cod: Integer;
		fecha: Integer;
		cant: Integer;
	end;
	ventasTotales = record
		cod: Intger;
		total: Integer;
	end;
	
	listaVentas = record
		cod: Intger;
		lista; lista_v:
	end;
	
	lista_v = ^nodo
	nodo: record
		dato: venta;
		sig: lista_v;
	end;
	
	arbol = ^nodoA
	nodoA: 
		dato: venta;
		HI: arbol;
		HD: arbol;
	end;
	
	arbol2 = ^nodoA2;
	nodoA2 = record;
		dato: ventasTotales;
		HI: arbol2;
		HD: arbol2;
	end;
	
	arbol3 = ^nodoA3;
		dato: listaVentas;
		HI: arbol3;
		HD: arbol3;
	end;

procedure generarArboles(var a1: arbol; var a2: arbol2; var a3: arbol3);
	procedure generarVenta(var v: venta);
	begin
		v.cod:= random(1000);
		If (v.cod <> 0) then
		begin
		v.fecha:= 2000 + random(26);
		v.cant:= 1 + random(100);
		end;
	end;
	procedure insertarVenta1(var a1: arbol, v: venta);
	begin
		If (a1 = Nil) then
		begin
			new(a1);
			a1^.dato:= v;
			a1^.HI:= Nil; a1^.HD:= Nil;
		end 
		else If (v.cod < a1^dato.cod) then insertar(a1^.HI, v)
		else insertarVenta1(a1^.HD, v);
	end;
	procedure insertarVenta(a2: arbol2, v: venta);
	var vt: ventasTotales;
	begin
		If (a2 := Nil) then
		begin
			vt.cod:= v.cod;
			vt.total:= v.cant;
			new(a2);
			a2^.dato:= vt;
			a1^.HI:= Nil; a1^.HD:= Nil;
		end
		else If (a2^.dato.cod = v.cod) then
			a2^.dato.total:= a2^.dato.total + v.cant;
			else If (v.cod < a1^dato.cod) then insertar(a1^.HI, v)
			else insertarVenta1(a1^.HD, v);
	end;

var
	v: venta;
begin
	Randomize;
	generarVenta(v);
	While (v.cod <> 0) do
	begin
		insertarVenta1(a1, v);
		insertarVenta2(a2, v);
		insertarVenta3(a3, v);
	end;
end;













	
	