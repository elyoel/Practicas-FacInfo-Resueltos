/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/*
 * @author Yoel
 */
public class Parcial_10_10_2023 {

    public static void main(String[] args) {
        /* Proceda a codear */
        Encargado e1 = new Encargado(2, "Pepe", 2211, 100);
        
        DirectorEjecutivo d1 = new DirectorEjecutivo(100, "Juan Carls", 445, 200);
        
        Empresa em1 = new Empresa("LogicPro", "Avenida Siempre Viva 123", d1, 5);
        
        em1.asignarEncargado(e1, 4);
        System.out.println(em1.toString());
    }

}
