/*
2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
 - Informe la cantidad de personas mayores de 65 años.
 - Muestre la representación de la persona con menor DNI.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Yoel
 */
public class Actividad_2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int DF = 15;
        int DL = 0;
        Persona personas[] = new Persona[DF];
		
        int edad = GeneradorAleatorio.generarInt(99);
        while (edad != 0 && DL < DF){
            personas[DL] = new Persona();
            personas[DL].setNombre(GeneradorAleatorio.generarString(10));
            personas[DL].setDNI(GeneradorAleatorio.generarInt(99999999)+ 10000000);
            personas[DL].setEdad(edad);
            edad = GeneradorAleatorio.generarInt(99);
            DL++;
        }
		
	int cant = 0;
	for (int i = 0; i < DL; i++){
            if (personas[i].getEdad() > 65) cant++;
	}
	System.out.println("La cantidad de personas que superan los 65 años es: " + cant);

        int pos = 0;
        int min = 9999;
        for (int i = 0; i < DL; i++){
            if (personas[i].getDNI() < min){
                pos = i;
                min = personas[i].getDNI();
            }
        }
        System.out.println(personas[pos].toString());
    }
    
}
