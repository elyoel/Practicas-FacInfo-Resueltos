anio = int(input("Ingrese un año: "))
print(f'Año que cumples 18: {anio + 18}')
print(f'Año que cumples 21: {anio + 21}')
print(f'Año que cumples 100: {anio + 100}')

min = int(input("Ingrese minutos: "))
horas = min // 3600
minutos = (min % 3600) // 60
segundos = min % 60
print(f'horas: {horas} minutos: {minutos} segundos: {segundos}')

num = int(input('Ingrese un numero N:' ))
print(f'Tabla de multiplicacion de {num}')
for i in range(10):
    print(f'{num * (i+1)}')


num = int(input('Ingrese un numero N:' ))
for i in range(1, num):
    if ((i % 5) == 0):
        continue
    else:
        print(i)

total = 0
while (True):
    num = int(input('Ingrese precio:' ))
    if (num == 0):
        break
    total += num
print(total)

numeros = []
multiplos5 = []
num = int(input('Ingrese un numero N:' ))
for i in range(1, num+1):
    if ((i % 5) == 0):
        multiplos5.append(i)
    else:
        numeros.append(i)
for n in numeros: print(n)
for n in multiplos5: print(n)

