/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage;

/*
 * @author Yoel
 */
public class Encargado extends Empleado{
    public int cantEmpleados;

    public Encargado(int cantEmpleados, String nombre, int dni, double sueldoBasico) {
        super(nombre, dni, sueldoBasico);
        this.cantEmpleados = cantEmpleados;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }
    
    public double sueldoCobrar(){
        return super.getSueldo() + (1000 * this.cantEmpleados);
    }

}
