program prueba1;
var
    x:integer;
begin
    Randomize;
    while true do begin
        x:= random(2);
        write(x);
    end;
end.