/*
1- Analice el programa Ej01Tabla2.java, que carga un vector que representa la
tabla del 2.
Genere enteros aleatorios hasta obtener el número 11. Para cada número muestre
el resultado de multiplicarlo por 2 (accediendo al vector).
 */
package tema1;
import PaqueteLectura.Lector;
/**
 *
 * @author Yoel
 */
public class Actividad_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int DF = 15;
        double jugadores[] = new double[DF];
        double prom = 0;
        int cant = 0;
        int i;
       
        for (i=0; i < DF; i++)
            jugadores[i] = Lector.leerDouble();
         
        for (i=0; i < DF; prom+= jugadores[i++]);
        
        prom /= DF;
        for (i = 0; i < DF; i++)
            if (jugadores[i] > prom) cant++;
         
        System.out.println("Cantidad de jugadores que superan el promedio " + cant);
    }
    
}
