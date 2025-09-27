/*
 5- El dueño de un restaurante entrevista a cinco clientes y les pide que califiquen
(con puntaje de 1 a 10) los siguientes aspectos: (0) Atención al cliente (1) Calidad
de la comida (2) Precio (3) Ambiente.
Escriba un programa que lea desde teclado las calificaciones de los cinco clientes
para cada uno de los aspectos y almacene la información en una estructura. Luego
imprima la calificación promedio obtenida por cada aspecto.
 */
package tema1;

import PaqueteLectura.Lector;

/**
 *
 * @author Yoel
 */
public class Actividad_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] aspectos = new String[] {"Atención al cliente", "Calidad de la comida", "Precio", "Ambiente"};
        
        int DF = 5;
        int DC =  4;
        int i, j;
        int tabla[][] = new int[DF][DC];
        
        for (i = 0; i < DF; i++){
            System.out.println("Participante: " + (i+1));
            for (j = 0; j < DC; j++){
                System.out.println("Califica " + aspectos[j]);
                tabla[i][j] = Lector.leerInt();
            }
        }
        for (j = 0; j < DC; j++){
            int prom = 0;
            for (i = 0; i < DF; prom += tabla[i++][j]);
            System.out.println("Aspecto " +  aspectos[j] + " tiene promedio: " + (prom/DF));
        }
    
    }
    
}
