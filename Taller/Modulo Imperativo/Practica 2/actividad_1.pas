
{1.- Implementar un programa que invoque a los siguientes m�dulos.
a. Un m�dulo recursivo que retorne un vector de a lo sumo 15 n�meros enteros �random� mayores a 10 y menores a 155 (incluidos ambos). La carga finaliza con 
el valor 20.
b. Un m�dulo no recursivo que reciba el vector generado en a) e imprima el contenido del vector.
c. Un m�dulo recursivo que reciba el vector generado en a) e imprima el contenido del vector.
d. Un m�dulo recursivo que reciba el vector generado en a) y devuelva la suma de los valores pares contenidos en el vector.
e. Un m�dulo recursivo que reciba el vector generado en a) y devuelva el m�ximo valor del vector.
f. Un m�dulo recursivo que reciba el vector generado en a)que reciba un valor y devuelva verdadero si dicho valor se encuentra en el vector o falso en caso contrario.
g. Un m�dulo que reciba el vector generado en a) e imprima, para cada n�mero contenido en el vector, sus d�gitos en el orden en que aparecen en el n�mero. 
Debe implementarse un m�dulo recursivo que reciba el n�mero e imprima lo pedido. Ejemplo si se lee el valor 142, se debe imprimir 1  4  2
}

Program Clase2MI;

Const dimF = 15;
  min = 10;
  max = 155;

Type vector = array [1..dimF] Of integer;


Procedure CargarVector (Var v: vector; Var dimL: integer);

Procedure CargarVectorRecursivo (Var v: vector; Var dimL: integer);
Var valor: integer;
Begin
  valor := min + random (max - min + 1);
  If ((valor <> 20 ) And (dimL < dimF))
    Then
    Begin
      dimL := dimL + 1;
      v[dimL] := valor;
      CargarVectorRecursivo (v, dimL);
    End;
End;

Begin
  dimL := 0;
  CargarVectorRecursivo (v, dimL);
End;

Procedure ImprimirVector (v: vector; dimL: integer);
Var 
  i: integer;
Begin
  For i:= 1 To dimL Do
    write ('----');
  writeln;
  write (' ');
  For i:= 1 To dimL Do
    Begin
      write(v[i], ' | ');
    End;
  writeln;
  For i:= 1 To dimL Do
    write ('----');
  writeln;
  writeln;
End;

Procedure ImprimirVectorRecursivo (v: vector; dimL: integer);
Begin
//Modificacion
    If (dimL > 1) Then
        ImprimirVectorRecursivo(v, (dimL - 1));
    write(v[dimL], ' | ');
//Fin Modificacion
End;


Function Sumar (v: vector; dimL: integer): integer;

Function SumarRecursivo (v: vector; pos, dimL: integer): integer;
Begin
  If (pos <= dimL) Then 
    SumarRecursivo := SumarRecursivo (v, pos + 1, dimL) + v[pos]
  Else 
    SumarRecursivo := 0;
End;

Var pos: integer;
Begin
  pos := 1;
  Sumar := SumarRecursivo (v, pos, dimL);
End;

Function  ObtenerMaximo (v: vector; dimL: integer): integer;
//Modificacion
    Procedure ObtenerMaximoRecursivo(v: vector; dimL: integer; var maximo: integer);
    begin
        If (dimL > 0) then
        Begin
            If (v[dimL] > maximo) Then maximo:= v[dimL];
            ObtenerMaximoRecursivo(v, (dimL - 1), maximo);    
        end;
    end;
Var maximo: integer;
Begin
    maximo:= -1;
    ObtenerMaximoRecursivo(v, dimL, maximo);
    ObtenerMaximo:= maximo;
//Fin Modificacion
End;


Function  BuscarValor (v: vector; dimL, valor: integer): boolean;
Begin
//Modificacion
  If (dimL = 1) Then BuscarValor := (v[dimL] = valor)
  Else
    BuscarValor := (v[dimL] = valor) OR BuscarValor(v, dimL-1, valor);         
//Fin Modificacion
End;

Procedure ImprimircDigitos (v: vector; dimL: integer);
//Modificacion  
  Procedure DescomponerRecursivo(n: integer);
  Begin
    If (n <> 0) then
    Begin  
      DescomponerRecursivo(n DIV 10);
      Write((n MOD 10), ' ');
    End;
  End;
Begin
  If (dimL > 1) Then
    ImprimircDigitos(v, (dimL - 1));
  DescomponerRecursivo(v[dimL]);
  writeln;
//Fin Modificacion
End;


Var dimL, suma, maximo, valor: integer;
  v: vector;
  encontre: boolean;
Begin
  CargarVector (v, dimL); //Inciso  A
  writeln;

  If (dimL = 0) Then writeln ('--- Vector sin elementos ---')
  Else
    Begin
    //Incisio B
      ImprimirVector (v, dimL);
    //Inciso C
      ImprimirVectorRecursivo (v, dimL);
    End;
  writeln;
  writeln;

  //Incisio D
  suma := Sumar(v, dimL);
  writeln('La suma de los valores del vector es ', suma);
  writeln;

  //Inciso E
  maximo := ObtenerMaximo(v, dimL);
  writeln('El maximo del vector es ', maximo);
  writeln;

  //Iniciso F
  write ('Ingrese un valor a buscar: ');
  read (valor);
  encontre := BuscarValor(v, dimL, valor);
  If (encontre) Then writeln('El ', valor, ' esta en el vector')
  Else writeln('El ', valor, ' no esta en el vector');
  writeln;

  //Indiso G
  ImprimircDigitos (v, dimL);
  writeln;
End.
