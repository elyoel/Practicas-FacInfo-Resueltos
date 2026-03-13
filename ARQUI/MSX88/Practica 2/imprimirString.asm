pa equ 30h 
pb equ 31h
ca equ 32h 
cb equ 33h 

org 1000h 
mensaje db "ORGANIZACIÓN Y ARQUITECTURA DE COMPUTADORAS"
fin db ? 

org 2000h

call confPio
mov cl, offset fin-offset mensaje
mov bx,offset mensaje

loop: call busy
mov al,[bx]
out pb,al

call strob 
inc bx
dec cl
jnz loop

termina: int 0

org 3000h 
confPio:
mov al , 01h 
out ca,al
mov al , 0 
out cb, al 
ret

org 3100h
busy: 
in al,pa
test al, 01h 
jnz busy
ret

org 3200h 
strob: 
in al ,pa
and al,11111101b
out pa,al
in al,pa
or al, 02h
out pa,al
ret 

end