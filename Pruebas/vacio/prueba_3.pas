program prueba_3;

Var 
    letra:   Char;

Begin
    For letra := 'A' To 'Y' Do
        Begin
            Write(letra, ' ');
        End;

    Writeln;
    letra:= succ(letra);
    WriteLn(letra);
    // Salto de línea al final
End.
