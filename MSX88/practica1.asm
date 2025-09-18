;parte 1
ORG 1000h
MENSAJE db "hola como estasaa"
FIN db ?
CANT db ?
ORG 2000h
  MOV cl, 0
  MOV bx, offset MENSAJE
  MOV ch, offset FIN - offset  MENSAJE
bucle:
  CMP byte ptr [bx], 'a'
  JNZ siguiente
  INC cl
siguiente:
  INC bx
  DEC ch
  JNZ bucle
  MOV CANT, cl
  hlt
END
;parte 5
ORG 1000h
inicio db 40h

ORG 2000h
  MOV bx, offset inicio
  MOV al, 1
bucle:
  INC inicio
  INT 7
  CMP byte ptr [bx], 5Ah
  JNZ bucle
hlt

END
;parte 5 b)
ORG 1000h
num db '/'
linea db 0Ah
ORG 2000h
  MOV al, 2
bucle:
  INC num
  MOV bx, offset num
  INT 7
  CMP num, '9'
  JNZ bucle

  hlt
END
;parte 6-a
ORG 1000h
CANT db 0
CHAR db ?
ORG 2000h
  MOV bx, offset CHAR
bucle:
  INT 6
  CMP byte ptr [bx], '.'
  JZ siguiente
  INC CANT
siguiente:
  JZ FIN
  JMP bucle
  
FIN:
HLT
END
;parte 6-b
ORG 1000h
CANT db 0
CHAR db ?
ORG 2000h
  MOV bx, offset CHAR
bucle:
  INT 6
  CMP byte ptr [bx], '.'
  JZ siguiente
  CMP byte ptr [bx], 'a'
  JNZ bucle
  INC CANT
siguiente:
  JZ FIN
  JMP bucle
  
FIN:
HLT
END
;parte 6-d
ORG 1000h
CANT_A db 0
CHAR db ?
ORG 2000h
  MOV bx, offset CHAR
  MOV al, 0
bucle: 
  INC bx
  INT 6
  CMP byte ptr [bx], '.'
  JZ siguiente
  INC al
  CMP byte ptr [bx], 'a'
  JNZ bucle
  INC CANT_A
siguiente:
  JZ FIN
  JMP bucle

FIN:
  MOV bx, offset CHAR
  INT 7
HLT
END

;parte 2 act 3 a)
org 1000h
A db 8
B db 5
C db 4
D db ?
org 3000h
CALC: MOV DL, AL;
add DL, AH
sub DL, CL
RET;
org 2000h
MOV AL, A;
MOV AH, B;
mov CL, C
CALL CALC;
mov D, DL
int 0
end
;parte 2 act 3 b)
org 1000h
A db 8
B db 5
C db 4
D db ?
org 3000h
CALC: push bx
mov bx,sp
ADD bx, 8;----
mov dl, [bx]
sub bx, 2
ADD dl, [bx];----
sub bx, 2
SUB dl, [bx];----
pop bx
RET;----
org 2000h
mov AL, A
push AX
mov AL, B;----
push AX
mov AL, C;----
push AX
call CALC
mov D, DL
pop AX;----
pop AX;----
pop AX;----
int 0
end

;parte 3 actividad 3
org 1000h
  CANT db ?
  MSJ db ?
org 3000h
ES_MAYUS: ;Inciso 1
  TEST AL, 00100000b
  JZ MAYUS
  MOV AH, 0
  ret
  MAYUS: MOV AH, 0FFh
  ret
  
org 3100h
A_MINUS: ;Inciso 2
  ADD AL, 20h
  ret

org 3200h
STRING_A_MINUS: ;Inciso 3
  PUSH BX
  PUSH AX
  MOV CL, AL
BUCLE:
  MOV AL, [BX]
  CALL ES_MAYUS
  JNZ SIG
  CALL A_MINUS
  MOV [bx], AL
  SIG: INC BX
  DEC CL
  JNZ BUCLE
  POP AX
  POP BX
  ret
;FIN DE SUBRUTINAS
org 2000h
;leer una cadena de de STRING hasta ingresar '.'
  MOV bx, offset MSJ
  MOV CANT, 0
LEER: 
  INT 6
  CMP byte ptr [bx], '.'
  JZ FIN
  INC CANT
  INC bx
  JMP LEER
FIN:
  MOV AL, CANT ;parametro AL
  MOV BX, offset MSJ ;parametro BX
  INT 7 ;imprimo STRING sin modificar "prueba"
  CALL STRING_A_MINUS

  INT 7 ;imprimo  el STRING modificado
HLT
END
