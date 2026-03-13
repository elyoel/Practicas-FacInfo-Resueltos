.data
a: .word 1
.code
ld $t0, a($0)
daddi $t1, $t0, 1
dmul $t0, $t1, $t1
halt