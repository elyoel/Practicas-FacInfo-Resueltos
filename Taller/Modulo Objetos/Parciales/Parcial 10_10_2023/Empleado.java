/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage;

/*
 * @author Yoel
 */
public abstract class Empleado {
    private String nombre;
    private int dni;
    private int anioIngreso;
    private double sueldoBasico;

    public Empleado(String nombre, int dni, double sueldoBasico) {
        this.nombre = nombre;
        this.dni = dni;
        this.sueldoBasico = sueldoBasico;
    }
    
    public double getSueldo(){
        double sueldo = this.sueldoBasico;
        if (2025 - this.anioIngreso > 20){
            sueldo *= 1.10;
        }
        return sueldo;
    }
    
    public String toString(){
        return this.nombre + ", " + this.dni + ", " + this.sueldoCobrar();
    }
    
    public abstract double sueldoCobrar();
    
}
