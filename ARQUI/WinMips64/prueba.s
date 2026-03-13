.data
  Datos1: .word 1,2,3
  Datos2: .word 0
.code 
  Daddi $t1,$0,3
  Daddi $t0,$0,0
loop: ld $t2,Datos1($t0)
   Daddi $t1,$t1,-1
   Daddi $t0,$t0,8
   Sd $t2,Datos2($t0)
   bnez $t1,loop
Halt