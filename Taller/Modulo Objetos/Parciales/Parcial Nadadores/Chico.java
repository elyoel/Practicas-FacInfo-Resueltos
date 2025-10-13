/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage1;

/*
 * @author Yoel
 */
public class Chico {
    private String nombre;
    private int nroResponsable;
    private boolean sabeNadar;

    public Chico(String nombre, int nroResponsable, boolean sabeNadar) {
        this.nombre = nombre;
        this.nroResponsable = nroResponsable;
        this.sabeNadar = sabeNadar;
    }
    
    public boolean getSabeNadar(){
        return this.sabeNadar;
    }
    
    public String toString(){
        String aux = this.nombre + ", " + this.nroResponsable + ", ";
        if (this.sabeNadar) aux += "Sabe Nadar";
        else aux+=  "No sabe nadar";
        return aux;
    }
}
