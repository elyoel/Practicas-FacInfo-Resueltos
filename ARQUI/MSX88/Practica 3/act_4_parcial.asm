pa equ 30h
pb equ 31h
ca equ 32h
cb equ 33h
int0 equ 24h
imr equ 21h
eoi equ 20h
id_f10 equ 15
cant equ 10
org 60
  dw rut_f10
org  1000h
  inicio db "PRESIONE F10 PARA COMENZAR"
  flag db 0
  msj db ?
org 3000h
rut_f10:
  mov cl, 0
  mov bx, offset msj
loop: int 6
  inc bx
  inc cl
  cmp cl, cant
  jnz loop

  mov bx, offset msj
  push bx
  call imprimir
  pop bx
  mov flag, 1
  mov al, 0FFh
  out imr, al
  mov al, eoi
  out eoi, al
iret

org 3500h
imprimir:
  mov bx, sp
  mov bx, [bx + 2]
  mov cl, 0
  
busy: in al, pa
  test al, 1
  jnz busy

  mov al, [bx]
  out pb, al

  in al, pa
  and al, 11111101b
  out pa, al
  in al, pa
  or al, 2
  out pa, al

  inc bx
  inc cl
  cmp cl, cant
  jnz busy
  
ret

config_pio:
  mov al, 01b
  out ca, al
  mov al, 0
  out cb, al
ret

org 2000h
  cli
    mov al, 11111110b
    out imr, al
    mov al, id_f10
    out int0,al
    call config_pio
  sti
  mov bx, offset inicio
  mov al, offset  flag -  offset inicio
  int 7
espera: cmp flag, 1
  jnz espera
  
INT 0
END
    

  
  
