/*
4- Sobre un nuevo programa, modifique el ejercicio anterior para considerar que:
a) Durante el proceso de inscripción se pida a cada persona sus datos (nombre, DNI, edad)
y el día en que se quiere presentar al casting. La persona debe ser inscripta en ese día, en el
siguiente turno disponible. En caso de no existir un turno en ese día, informe la situación.
La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los 40 cupos
de casting.
Una vez finalizada la inscripción:
b) Informar para cada día: la cantidad de inscriptos al casting ese día y el nombre de la
persona a entrevistar en cada turno asignado
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Usuario
 */
public class Actividad_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Reemplazar el aleatorio por lectura  por teclado
        GeneradorAleatorio.iniciar();
        
        int DF = 5, DC = 8;
        int DimF = (DF * DC);
        int DimL = 0;
        int edad, dni;
        Persona casting[][] = new Persona[DF][DC];
        
        System.out.println("Ingrese  nombre: ");
        String nom = GeneradorAleatorio.generarString(3).toUpperCase();
        int i = 0, j, dia;
        while (!nom.equals("ZZZ") && DimL < DimF){
            System.out.println("Ingrese  edad: ");
            edad = GeneradorAleatorio.generarInt(99);
            System.out.println("Ingrese  dni: ");
            dni = GeneradorAleatorio.generarInt(99999999)+10000000;
            j=0;
            System.out.println("Ingrese  dia: ");
            dia = GeneradorAleatorio.generarInt(DF);
            while(j < DC && casting[dia][j] != null){
                j++;
            }
            if (j >= DC){
                System.out.println("Turnos llenos en el dia " + (dia+1) + " solicitidado, ingrese otro dia: ");
            }else{
                casting[dia][j] = new Persona(nom, dni, edad);
                DimL++;
            }
            System.out.println("Ingrese  nombre: ");
            nom = GeneradorAleatorio.generarString(3).toUpperCase();
        }
        System.out.println();
        
        int cant;
        for (i = 0; i < DF; i++){
            cant = 0;
            j = 0;
            System.out.println("Para el dia " + (i+1));
            while (j < DC && casting[i][j] != null){
                System.out.println(casting[i][j].getNombre() + " esta asignado al turno " + (++j));
                cant++;
            }
            System.out.println("Cantidad de inscriptos: " + cant);
            System.out.println();
        }
    }
}
