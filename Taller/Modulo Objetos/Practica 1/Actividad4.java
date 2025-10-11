/*
 4- Un edificio de oficinas está conformado por 8 pisos (1..8) y 4 oficinas por piso
(1..4). Realice un programa que permita informar la cantidad de personas que
concurrieron a cada oficina de cada piso. Para esto, simule la llegada de personas al
edificio de la siguiente manera: a cada persona se le pide el nro. de piso y nro. de
oficina a la cual quiere concurrir. La llegada de personas finaliza al indicar un nro.
de piso 9. Al finalizar la llegada de personas, informe lo pedido. 
 */
package tema1;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Yoel
 */
public class Actividad_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        int DF = 8;
        int DC = 4;
        int edificio[][] = new int[DF][DC];
        int i, j;
        
        for (i = 0; i < DF; i++)
            for (j = 0;  j < DC; edificio[i][j++] = 0);
        
        System.out.println("Simulacion de  ingreso de personas con random");
        i = GeneradorAleatorio.generarInt(DF+1);
        j = GeneradorAleatorio.generarInt(DC);
        //Si se ingresa por teclado, la  primera instrauccion del while se le restaria -1 a i && j;
        //8 simula el 9 en el random, sino 9 con lectura por teclado;
        while (i != 8){
            /* i--; j--;
            Si ingreso piso 3 corresponde al indice 2, uno menos del ingresado
            aproposito la primera instruccion del while*/
            edificio[i][j]++;
            i = GeneradorAleatorio.generarInt(DF+1);
            j = GeneradorAleatorio.generarInt(DC);
            
        }
        System.out.println();
        
        for (i = 0; i < DF; i++){
            System.out.println("Piso " + (i+1));
            for (j = 0;  j < DC; System.out.print("F:" + (i+1) + " C:" + (j+1) + " cant: " + edificio[i][j++] + "  |  "));
            System.out.println();
        }
    }
    
}
