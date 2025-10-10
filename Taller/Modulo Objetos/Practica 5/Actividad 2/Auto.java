/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class Auto {
    private String nombreDueño,
                   patente;
    
    public Auto(String unNombre, String unaPatente){
        setNombreDueño(unNombre);
        setPatente(unaPatente);
    }

    public String toString() {
        return "Auto{" + "Nombre Dueño: " + this.getNombreDueño() + ", Patente: " + this.getPatente();
    }

    
    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
}
