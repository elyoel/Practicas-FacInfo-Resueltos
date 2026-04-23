program ejercicio3;
const
    fin = 'fin';
type
    empleado = record
        cod: Integer;
        nombre: String[30];
        apellido: String[50];
        edad: Integer;
        dni: Integer;
    end;
    archivo = file of empleado;
procedure leer_empleado(var e: empleado);
begin
    writeLn('Ingrese apellido: ');
    readLn(e.apellido);
    if (e.apellido <> fin) then begin
        writeLn('Ingrese nombre:');
        readLn(e.nombre);
        writeLn('Ingrese edad: ');
        readLn(e.edad);
        writeLn('Ingrese numero de empleado: ');
        readLn(e.cod);
        writeLn('Ingrese dni: ');
        readLn(e.dni);
    end;
end;
procedure cargar_empleados(var arc: archivo);
var 
    e: empleado;
begin
    rewrite(arc);
    leer_empleado(e);
    while (e.apellido <> fin) do begin
        write(arc, e);
        leer_empleado(e);
    end;
    close(arc);
end;
procedure imprimir_empleados(var arc: archivo);
var e: empleado;
begin
    reset(arc);
    while not(EOF(arc)) do begin
        read(arc, e);
        writeLn(e.nombre, ' ', e.apellido, ' ', e.dni, ' ', e.edad, ' ', e.cod);
    end;
    close(arc);
end;
procedure agregar_empleados(var arc: archivo);
var
    nue, e: empleado;
begin
    leer_empleado(nue);
    reset(arc);
    while (nue.apellido <> fin) do begin
        read(arc, e);
        while not(EOF(arc)) and (e.cod <> nue.cod) do
            read(arc, e);
        if (e.cod = nue.cod) then
            writeLn('Numero de empleado ya existe.')
        else begin
            write(arc, nue);
            writeLn('Empleado agregado con exito.');
        end;
        leer_empleado(nue);
        reset(arc);
    end;
    close(arc);
end;
procedure modificar_empleado(var arc: archivo);
var
    edad, cod: Integer;
    e: empleado;
begin
    writeLn('Ingrese codigo de empleado para modificar: '); readLn(cod);
    writeLn('Ingrese nueva edad: '); readLn(edad);
    
    reset(arc);
    read(arc, e);
    while not(EOF(arc)) and (e.cod <> cod) do
        read(arc, e);
    if (e.cod = cod) then begin
        e.edad:= edad;
        seek(arc, filePos(arc) - 1);
        write(arc, e);
        writeLn('Empleado actualizado');
    end
    else
        writeLn('Codigo de empleado no encontrado.');
    close(arc);
end;
procedure exportar_empleados(var arc: archivo);
var
    arc_text: Text;
    e: empleado;
begin
    assign(arc_text, 'todos_empleados.txt');
    rewrite(arc_text);
    reset(arc);
    while not(EOF(arc)) do begin
        read(arc, e);
        writeLn(arc_text, e.nombre, ' ', e.apellido, ' ', e.dni, ' ', e.edad, ' ', e.cod);
    end;
    close(arc); close(arc_text);
end;
procedure exportar_sin_dni(var arc: archivo);
var
    arc_text: Text;
    e:   empleado;
begin
    assign(arc_text, 'faltaDNIEmpleado.txt');
    rewrite(arc_text);
    reset(arc);
    while not(EOF(arc)) do begin
        read(arc, e);
        if (e.dni = 0) then 
            writeLn(arc_text, e.nombre, ' ', e.apellido, ' ', e.dni, ' ', e.edad, ' ', e.cod);
    end;
    close(arc); close(arc_text);
end;
var
    arc: archivo;
    opc: Integer;
begin
    assign(arc, 'ListaEmpleados');
    
    writeLn('Ingrese opcion: (1) Registrar empleados - (2) Mostrar empleados - (3) Agregar empleado - (4) Modificar edad - (5) Exportar empleados - (6) Exportar empleado sin DNI');
    readln(opc);
    while (opc <> -1) do begin
        case opc of
            1:  cargar_empleados(arc);
            2:  imprimir_empleados(arc);
            3:  agregar_empleados(arc);
            4:  modificar_empleado(arc);
            5:  exportar_empleados(arc);
            6:  exportar_sin_dni(arc);
        end;
        writeLn('Ingrese opcion: (1) Registrar empleados - (2) Mostrar empleados - (3) Agregar empleado - (4) Modificar edad - (5) Exportar empleados - (6) Exportar empleado sin DNI');
        readln(opc);
    end;
end.