{2.- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina
se ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura
finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.
b. Ordene el vector, aplicando el método de inserción, por código de identificación de la
oficina.
c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina.}
program actividad_2;
const dimF = 300;
type
    oficina = Record
        cod: Integer;
        dni_dueño: Integer;
        valor_expenza: Real;
    end;

    v_oficinas = array[1..dimF] of oficina;

procedure generar_vector(var v: v_oficinas; dimL: Integer);
    procedure leer_oficina(var o: oficina);
    begin
        WriteLn('Ingrese Codigo Identificador:');
        ReadLn(o.cod);
        If (o.cod <> -1) then
        begin
            WriteLn('Ingrese DNI del Dueño:');
            ReadLn(o.dni_dueño);
            WriteLn('Ingrese Valor de la Expenza:');
            ReadLn(o.valor_expenza);
        end;
    end;
var o: oficina;
begin
    dimL:= 0;
    leer_oficina(o);
    While (o.cod <> -1) AND (dimL <= dimF) do
    begin
        dimL:= dimL + 1;
        v[dimL]:= o;
        leer_oficina(o);
    end;
end;

procedure ordenacion_seleccion(var v: v_oficinas; dimL: Integer);
var
    i, j, pos: Integer;
    dato: oficina;
begin
    For i:= 1 to (dimL - 1) do
    begin
        pos:= i;
        for j:= (i + 1) to dimL do
            If (v[j].cod < v[pos].cod) then pos:= j;
        
        dato:= v[pos];
        v[pos]:= v[i];
        V[i]:= dato;
    end;
end;
procedure ordenacion_insercion(var v: v_oficinas; dimL: Integer);
var
    i, j: Integer;
    dato: oficina;
begin
    for i:= 2 to dimL do
    begin
        dato:= v[i];
        j:= i - 1;
        while (j > 0) AND (v[j].cod > dato.cod) do
        begin
            v[j+1]:= v[j];
            j:= j - 1;
        end;
        v[j+1]:= dato;
    end;
end;
var 
    vector_oficinas, v2: v_oficinas;
    dimL: Integer;
begin
    generar_vector(vector_oficinas, dimL);
    v2:= vector_oficinas;
    ordenacion_seleccion(vector_oficinas, dimL);
    ordenacion_insercion(v2, dimL);
end.