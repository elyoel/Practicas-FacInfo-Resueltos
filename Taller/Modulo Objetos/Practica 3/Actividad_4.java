/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema3;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;
/*
 * @author Yoel
 */
public class Actividad_4 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        final int N = 10;
        Hotel h1 = new Hotel(N);
        
        Persona cliente;
        
        while (!h1.estaLleno()){
            cliente = new Persona(
                    Lector.leerString(),
                    Lector.leerInt(),
                    Lector.leerInt());
            h1.agregarCliente(cliente, GeneradorAleatorio.generarInt(N));
        }
        h1.toHotel();
        
        h1.aumentarCosto(GeneradorAleatorio.generarDouble(2000));
        
        h1.toHotel();
    }

}
