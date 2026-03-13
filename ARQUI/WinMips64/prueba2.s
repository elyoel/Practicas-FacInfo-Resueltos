.data
  Datos1: .word 1,2,3
  Datos2: .word 0
.code 
  daddi $t1,$0,3
  daddi $t0,$0,0
loop:ld $t2,Datos1($t0)
   daddi $t1,$t1,-1
   daddi $t0,$t0,8
   sd $t2,Datos2($t0)
   bnez $t1,loop
halt