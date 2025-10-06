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
public class Actividad_1 {

    public static void main(String[] args) {
        /* Proceda a codear */
        Circulo c1 = new Circulo(10.5, "Verde", "Amarrillo");
        Triangulo t1 = new Triangulo(30.1, 30.4, 10, "Rojo", "Azul");
        
        System.out.println(c1.toString());
        c1.despintar();
        System.out.println(t1.toString());
        
    }

}
