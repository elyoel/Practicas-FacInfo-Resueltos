/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage1;

/*
 * @author Yoel
 */
public class Nadadores extends Grupo {
    private String nombreBaniero;
    private double sueldoBaniero;

    public Nadadores(String nombreBaniero, double sueldoInstructor, double costoInscripcion, int N) {
        super(nombreBaniero, sueldoInstructor, costoInscripcion, N);
    }
    
    public void agregarAlGrupo(Chico unChico){
        if (unChico.getSabeNadar())
            super.agregarAlGrupo(unChico);
    }
    
    public double ganaciaNeta(){
        return super.gananciaNeta() - this.sueldoBaniero;
    }    
}
