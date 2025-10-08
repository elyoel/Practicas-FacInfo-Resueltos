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
public class Actividad_1 {

    public static void main(String[] args) {
        /* Proceda a codear */
        Investigador i1, i2, i3;
        i1 = new Investigador("Pepe", 1, "S/E");
        i2 = new Investigador("Max", 3, "S/E");
        i3 = new Investigador("Alex", 5, "S/E");
        Proyecto p1 = new Proyecto("Proyecto Uno", 1, "Juan Mamani");
        
        Subsidio s1 = new Subsidio("Ayuda", 200);
        Subsidio s2 = new Subsidio("Pago", 150);
        Subsidio s3 = new Subsidio("Soborno", 100);
        Subsidio s4 = new Subsidio("Estudios", 300);
        
        i1.agregarSubsidio(s1);
        i1.agregarSubsidio(s2);
        i2.agregarSubsidio(s3);
        i2.agregarSubsidio(s3);
        i3.agregarSubsidio(s4);
        i3.agregarSubsidio(s4);
            
        p1.agregarInvestigador(i1);
        p1.agregarInvestigador(i2);
        p1.agregarInvestigador(i3);
        
        p1.otorgarTodos("Alex");
        p1.otorgarTodos("Pepe");
        
        System.out.println(p1.toString());
        
    }

}
