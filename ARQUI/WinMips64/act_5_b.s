.data
    a: .word 0
    b: .word 10
    c: .word 0
.code   
    ld $t0, a($0)
    ld $t1, b($0)
    beqz $t0, fin

    slt $t2, $t1, $t0
    bnez $t2, mul
    sd $t1, c($0)
mul: 
    dadd $t2, $t0, $t0
    sd $t2, c($0)
fin:
    halt