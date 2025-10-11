/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/*
 * @author Yoel
 */
public class Actividad_3 {

    public static void main(String[] args) {
        /* Proceda a codear */
        Fecha f1 = new Fecha("20/10", "BA AS");
        Fecha f2 = new Fecha("23/12", "LP");
        EventoOcasional e1 = new EventoOcasional("Evento 1", 2, "Privado", "Pepe", f1);
        Gira g1 = new  Gira("Gira Average", 2, "Gira AVG", 3);
        
        g1.agregarTema("Bachata");
        g1.agregarTema("Pop");
        g1.agregarFecha(f1);
        g1.agregarFecha(f2);
        
        e1.agregarTema("Pop");
        e1.agregarTema("Tiktok");
        
        System.out.println(e1.calcularCosto());
        System.out.println(g1.calcularCosto());
        e1.actuar();
        g1.actuar();
        g1.actuar();
    }

}
