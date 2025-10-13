/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage1;

/*
 * @author Yoel
 */
public abstract class Grupo {
    private String nombreInstructor;
    private double sueldoInstructor,
                   costoInscripcion;
    private Chico inscriptos[];
    private int dimF, dimL;

    public Grupo(String nombre, double sueldoInstructor, double costoInscripcion, int N) {
        this.nombreInstructor = nombre;
        this.sueldoInstructor = sueldoInstructor;
        this.costoInscripcion = costoInscripcion;
        this.dimF = N;
        this.dimL = 0;
        this.inscriptos = new Chico[this.dimF];
    }
    
    public void agregarAlGrupo(Chico unChico){
        if (this.dimL < this.dimF){
            this.inscriptos[dimL] = unChico;
            this.dimL++;
            System.out.println("Tuvo Existo la operacion");
        }
    }
    
    public double gananciaNeta(){
        return this.dimL * this.costoInscripcion - this.sueldoInstructor;
    }
    
    public boolean esRentable(){
        System.out.println(gananciaNeta());
        return this.gananciaNeta() > 5000000;
    }
    
    public String toString(){
        String aux = this.nombreInstructor + ", " + this.dimL + '\n';
        for (int i = 0; i < this.dimL; i++){
            aux += inscriptos[i].toString() + " ;; ";
        }
        aux += '\n' + "Ganacia neta del grupo: " + this.gananciaNeta() + '\n';
        
        if (this.esRentable()) aux += "Es rentable";
        else aux += "No es rentable";
        return aux;
    }
    
    
}
