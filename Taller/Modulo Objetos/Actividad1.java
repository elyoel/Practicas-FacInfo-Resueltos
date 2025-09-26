/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
