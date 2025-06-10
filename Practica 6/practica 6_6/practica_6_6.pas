Program practice_6_6;
Type 
  rango_espectro = 1..7;

  sondas = Record
    nombre: String;
    costo: Real;
    costo_mante: Real;
    duracion: Integer;
    rango: rango_espectro;
  End;

  espectros = array[rango_espectro] Of integer;

  ls_sondas = ^nodo_sondas;
  nodo_sondas = Record
    elem: sondas;
    sig: ls_sondas;
  End;

  max = Record
    nombre: string;
    precio: real;
  End;
Procedure leer_sonda(Var dato: sondas);
Begin
  readln(dato.nombre);
  readln(dato.costo);
  readln(dato.costo_mante);
  readln(dato.duracion);
  readln(dato.rango);
End;

Procedure cargar_adelante(Var ls: ls_sondas; d: sondas);
Var 
  nuevo: ls_sondas;
Begin
  new(nuevo);
  nuevo^.elem := d;
  nuevo^.sig := ls;
  ls := nuevo;
End;

Procedure cargar_ls(Var ls: ls_sondas);
Var 
  sonda: sondas;
Begin
  Repeat
    leer_sonda(sonda);
    cargar_adelante(ls, sonda);
  Until (sonda.nombre = 'GAIA')
End;

Procedure actu_maxi(s: sondas; m: max);
Var 
  valor: real;
Begin
  valor := (s.costo + s.costo_mensu);
  If (valor > max.precio) Then
    Begin
      max.nombre := s.nombre;
      max.precio := valor;
    End;
End;
Procedure contar(s: sondas; Var cont: espectros)
Begin
  cont[s.rango] := cont[s.rango] + 1;
End;
proceso imprimir_contador(cont: espectros);
Var 
  i: rango_espectro;
begin
    For i:= 1 To 7 Do
        Begin
        writeln('Rango ', i, ': ', cont[i]);
        End;
    End;
end;

Begin
    while ls <> nil Do
    begin
      contar(ls^.elem, cont);
      actu_maxi(ls^.elem, max);
      ls := ls^.sig;
    end;
    writeln('Sonda con mayor costo total: ', max.nombre, ' con un costo de ', max.precio:0:2);
End.
