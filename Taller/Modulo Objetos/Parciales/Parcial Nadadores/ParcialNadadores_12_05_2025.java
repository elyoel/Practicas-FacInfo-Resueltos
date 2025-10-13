/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage1;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/*
 * @author Yoel
 */
public class ParcialNadadores_12_05_2025 {

    public static void main(String[] args) {
        /* Proceda a codear */
        Nadadores n1 = new Nadadores("Axel", 100, 2000, 5);
        Exploradores e1 = new Exploradores("Maxi", 200, 3000, 5, 1000);
        
        Chico c1 = new Chico("Pepe", 1123022, true);
        Chico c2 = new Chico("Maria", 1123022, true);
        Chico c3 = new Chico("Axel 1", 1123022, true);
        Chico c4 = new Chico("Hernadez", 1123022, false);
        Chico c5 = new Chico("Juan", 1123022, true);
        Chico c6 = new Chico("Lolo", 1123022, false);
        
        n1.agregarAlGrupo(c6);
        n1.agregarAlGrupo(c1);
        n1.agregarAlGrupo(c3);
        n1.agregarAlGrupo(c4);
        n1.agregarAlGrupo(c2);
        n1.agregarAlGrupo(c5);
        
        e1.agregarAlGrupo(c1);
        e1.agregarAlGrupo(c2);
        e1.agregarAlGrupo(c3);
        e1.agregarAlGrupo(c4);
        e1.agregarAlGrupo(c5);
        e1.agregarAlGrupo(c6);
        
        System.out.println(e1.toString());
        System.out.println();
        System.out.println(n1.toString());
        
    }

}
