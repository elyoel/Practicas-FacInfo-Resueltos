PA equ 30h
PB equ 31h
CA equ 32h
CB equ 33h
ID_F10 equ 15
INT0 equ 24h
IMR equ 21h
EOI equ 20h

org 60
  dw RUT_F10

org 1000h
  MSJ db ?

org 3000h
RUT_F10:
  IN AL, PA
  TEST AL, 1
  JNZ RUT_F10

  MOV AL, [BX]
  OUT PB, AL
  INC BX
  
  IN AL, PA
  AND AL, 11111101b
  OUT PA, AL
  IN AL, PA
  OR AL, 2
  OUT PA, AL

  DEC CL
  JNZ RUT_F10
  MOV AL, EOI
  OUT EOI, AL
  IRET

org 2000h
  CLI
  MOV AL, ID_F10
  OUT INT0, AL
  MOV AL, 0FEh
  OUT IMR, AL

  mov al , 01h 
  out ca,al
  mov al , 0 
  out cb, al 
  STI
  MOV CL, 0
  MOV BX, OFFSET MSJ
  PUSH BX
LOOP: INT 6
  INC BX
  INC CL
  CMP CL, 10
  JNZ LOOP
  POP BX
LOOP2: JMP LOOP2
  INT 0
  END