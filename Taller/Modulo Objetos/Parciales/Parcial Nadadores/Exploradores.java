/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage1;

/*
 * @author Yoel
 */
public class Exploradores  extends Grupo{
    private double costoCarpas;

    public Exploradores(String nombre, double sueldoInstructor, double costoInscripcion, int N, double costo) {
        super(nombre, sueldoInstructor, costoInscripcion, N);
        this.costoCarpas = costo;
    }
    
   
    
}
