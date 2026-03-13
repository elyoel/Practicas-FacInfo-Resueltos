.data
cadena: .asciiz "ABCdef1"
cadena2: .ascii "ABCdef11"
cadena3: .asciiz "ABCdef1111111"
num: .word 5

datos: .byte -2, 2, 2, 2, 2, 2
.code
ld $t1, datos($zero)
lb $t2, datos($zero)
lbu $t3, datos($zero)
halt
