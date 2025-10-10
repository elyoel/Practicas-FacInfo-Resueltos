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
public class Actividad_2 {

    public static void main(String[] args) {
        /* Proceda a codear */
        GeneradorAleatorio.iniciar();
        Estacionamiento e1 = new Estacionamiento("LP Autos", "Av 1", "00:00", "18:00", 3, 3);
        
        Auto a1 = new  Auto("Pepe", "AAA111");
        Auto a2 = new  Auto("NuLL", GeneradorAleatorio.generarString(6));
        Auto a3 = new  Auto("Alex", GeneradorAleatorio.generarString(6));
        Auto a4 = new  Auto("Alberto", GeneradorAleatorio.generarString(6));
        Auto a5 = new  Auto("Juan", GeneradorAleatorio.generarString(6));
        Auto a6 = new  Auto("Max", GeneradorAleatorio.generarString(6));
        
        e1.registrarAuto(a1, GeneradorAleatorio.generarInt(3), GeneradorAleatorio.generarInt(3));
        e1.registrarAuto(a2, GeneradorAleatorio.generarInt(3), GeneradorAleatorio.generarInt(3));
        e1.registrarAuto(a3, GeneradorAleatorio.generarInt(3), GeneradorAleatorio.generarInt(3));
        e1.registrarAuto(a4, GeneradorAleatorio.generarInt(3), GeneradorAleatorio.generarInt(3));
        e1.registrarAuto(a5, GeneradorAleatorio.generarInt(3), GeneradorAleatorio.generarInt(3));
        e1.registrarAuto(a6, GeneradorAleatorio.generarInt(3), GeneradorAleatorio.generarInt(3));
        
        System.out.println(e1.toString());
        System.out.println(e1.cantAutosPlaza(1));
        
        System.out.println("Ingrese una patente");
        String patente = Lector.leerString();
        System.out.println(e1.buscarAuto(patente));
    }

}
