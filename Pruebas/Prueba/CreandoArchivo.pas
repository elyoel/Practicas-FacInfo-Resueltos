program CreandoArchivo;
type
    archivo = file of Integer;
var
    arc: archivo;
    i: Integer;
begin
    assign(arc, 'ArchivoPascal');
    rewrite(arc);
    for i:= 1 to 100 do begin
        if (i MOD 2) = 0 then
            write(arc, i);
    end;

    reset(arc);
    while not (EOF(arc)) do begin
        read(arc, i);
        WriteLn(i);
    end;
    close(arc);
end.