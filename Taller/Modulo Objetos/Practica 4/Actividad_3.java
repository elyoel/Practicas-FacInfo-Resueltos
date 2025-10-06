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
public class Actividad_3 {

    public static void main(String[] args) {
        /* Proceda a codear */
        Persona p1 = new Persona("Juan", 3023, 10);
        Trabajador t1 = new Trabajador("Chamba", 3310, 12, "Limpiador");
        
        System.out.println(t1.toString());
        System.out.println(p1.toString());
        
        Estacion e1 = new Estacion("La Plata", 10.2, 12.2, 2, 2025);
        
        System.out.println(e1.reportarTemperatura(3, 2025));
    }

}
