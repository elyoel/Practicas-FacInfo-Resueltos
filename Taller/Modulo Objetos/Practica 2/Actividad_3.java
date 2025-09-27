/*
3- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno asignado, el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona. Pensar en la estructura de datos a utilizar. Para comparar
Strings use el método equals
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Usuario
 */
public class Actividad_3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        int DF = 5, DC = 8;
        int DimF = (DF * DC);
        int DimL = 0;
        Persona casting[][] = new Persona[DF][DC];
        
        String nom = GeneradorAleatorio.generarString(3).toUpperCase();
        int i = 0, j;
        while (!nom.equals("ZZZ") && i < DF){
            j = 0;
            while (!nom.equals("Z") && j < DC){
                casting[i][j++] = new Persona(nom,
                                        GeneradorAleatorio.generarInt(99999999)+10000000,
                                        GeneradorAleatorio.generarInt(99));
                nom = GeneradorAleatorio.generarString(3).toUpperCase();
                DimL++;
            }
            i++;
        }
        
        for (i = 0; i < (DimL/DC); i++){
            for (j = 0; j < DC; System.out.println("El dia " + (i+1) + " con turno " + (j+1) + " esta " + casting[i][j++].getNombre()));
            System.out.println("--------");
        }
        for (j = 0; j < (DimL%DC); System.out.println("El dia " + (i+1) + " con turno " + (j+1) + " esta " + casting[i][j++].getNombre()));
        
        /*
        int cant = 0;
        i = 0;
        while (i < DF && cant < DimL){
            j = 0;
            while (j < DC && cant < DimL){
                System.out.println("El dia " + (i+1) + " con turno " + (j+1) + " esta " + casting[i][j++].getNombre());
                cant++;
            }
            System.out.println("--------");
            i++;
        }
        */
    }
}
