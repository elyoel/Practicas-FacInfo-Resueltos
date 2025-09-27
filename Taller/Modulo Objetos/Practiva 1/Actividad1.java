/*
 1- Analice el programa Ej01Tabla2.java, que carga un vector que representa la
tabla del 2.
Genere enteros aleatorios hasta obtener el número 11. Para cada número muestre
el resultado de multiplicarlo por 2 (accediendo al vector).
 */
package tema1;
import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Yoel
 */
public class Actividad_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int DF = 11;  
        int [] tabla2 = new int[DF]; // indices de 0 a 10
        for (int i=0;i<DF;i++) 
            tabla2[i]=2*i;
        int n = GeneradorAleatorio.generarInt(DF + 1);
        while (n != 11){
            System.out.println("El numero " + n + " por 2 es: " + tabla2[n]);
            n = GeneradorAleatorio.generarInt(DF + 1);
        }
    }
    
}
