/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
