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
public class Actividad_4 {

    public static void main(String[] args) {
        /* Proceda a codear */
        Director d1 = new Director(10, "Armando", 30, 12234);
        Corista c1 = new  Corista(10, "Corista 1", 10, 1201);
        Corista c2 = new  Corista(20, "Corista 2", 20, 1201);
        Corista c3 = new  Corista(40, "Corista 3", 30, 1201);
        
        CoroSemicircular coro1 = new CoroSemicircular("Number 1", d1, 3);
        CoroPorHileras coro2 = new CoroPorHileras("Number 2", d1, 1, 3);
        
        coro1.agregarCorista(c1);
        coro1.agregarCorista(c2);
        coro1.agregarCorista(c3);
        
        coro2.agregarCorista(c1);
        coro2.agregarCorista(c2);
        coro2.agregarCorista(c3);
        
        
        System.out.println(coro1.toString());
        
        System.out.println(coro2.toString());
        
    }

}
