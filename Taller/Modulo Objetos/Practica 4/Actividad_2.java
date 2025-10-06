/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema4;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/*
 * @author Yoel
 */
public class Actividad_2 {

    public static void main(String[] args) {
        /* Proceda a codear */
        Jugador j1 = new Jugador(1, 3, "Pepe", 100, 1);
        Entrenador e1 = new Entrenador(3, "Enrique", 200, 4);
        
        System.out.println(j1.toString());
        System.out.println(e1.toString());
    }

}
