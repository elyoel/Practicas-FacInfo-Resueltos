import csv
from pathlib import Path

arc = Path("Python") / "Occurrence.txt"

with open(arc, encoding='utf-8') as archivo:
    # Creamos el lector de diccionarios
    lector_dict = csv.DictReader(archivo)
    
    cabezera = lector_dict.fieldnames
    print(type(cabezera))   
    for a, b in enumerate(cabezera):
        print(f'{a} : {b}')

    