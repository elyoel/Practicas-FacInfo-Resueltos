.data
    a: .word 10
    b: .word 20
    s: .word 0
    p: .word 0
    d: .word 0
.code
    ld $t0, a($0)
    ld $t1, b($0)
    dadd $t2, $t0, $t1
    sd $t2, s($0)

    dmul $t2, $t0, $t1
    daddi $t2,  $t2, 2 
    sd $t2, p($0)

    dmul $t2, $t0, $t0
    ddiv $t2, $t2, $t1
    sd $t2, d($0)
    halt