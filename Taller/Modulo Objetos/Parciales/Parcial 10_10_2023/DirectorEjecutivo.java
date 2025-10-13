/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage;

/*
 * @author Yoel
 */
public class DirectorEjecutivo extends Empleado {
    private double montoViaticos;

    public DirectorEjecutivo(double montoViaticos, String nombre, int dni, double sueldoBasico) {
        super(nombre, dni, sueldoBasico);
        this.montoViaticos = montoViaticos;
    }

    public double sueldoCobrar() {
        return super.getSueldo() + this.montoViaticos;
    }
    
    
}
