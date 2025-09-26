/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Yoel
 */
public class Actividad_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int matriz[][] =  new int[5][5];
        int i, j;
        
        //Inicialice la matriz con números aleatorios entre 0 y 30. 
        for (i = 0; i < 5; i++){
            for (j = 0; j < 5; matriz[i][j++] = GeneradorAleatorio.generarInt(31));
        }
        System.out.println();
        
        //Mostrar el contenido de la matriz en consola. 
        for (i = 0; i < 5; i++){
            for (j = 0; j < 5; System.out.print(matriz[i][j++] + " |"));
            System.out.println();
        }
        System.out.println();
        
        //Calcular e informar la suma de los elementos de la fila 1
        int fila1 = 0;
        for (i = 0;  i < 5; fila1 += matriz[0][i++]);
        System.out.println("La suma de los elementos de la fila 1: " + fila1);
        System.out.println();
        
        /*Generar un vector de 5 posiciones donde cada posición j contiene la suma 
        de los elementos de la columna j de la matriz. Luego, imprima el vector */
        int sumaColum[] = new int[5];
        for (i = 0; i < 5; sumaColum[i++] = 0);
        
        for (i = 0; i < 5; i++){
            for (j = 0; j < 5; sumaColum[j] += matriz[i][j++]);
        }
        for  (i = 0; i < 5; System.out.println("La suma de la columna " + (i + 1) + " es: " + sumaColum[i++]));
        System.out.println();
          
        /*Leer un valor entero e indicar si se encuentra o no en la matriz. En caso de
        encontrarse indique su ubicación (fila y columna) en caso contrario
        imprima “No se encontró el elemento” */
        System.out.println("Ingrese numero a buscar: ");
        int num = Lector.leerInt();
        boolean ok = false;
        i = 0;
        while (!ok && i < 5){
            j = 0;
            while (!ok && j < 5){
                if (matriz[i][j] == num){
                    System.out.println(num + " esta en fila: " + (i+1) + " columna: " + (j+1));
                    ok = true;
                }
                j++;
            }
            i++;
        }
        if (!ok) System.out.println("No se encontró el elemento");
        System.out.println();
    }
}
