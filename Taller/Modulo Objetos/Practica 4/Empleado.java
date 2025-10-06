/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema4;

/*
 * @author Yoel
 */
public abstract class Empleado {
    private String nombre;
    private double sueldo;
    private int antiguedad;
    
    public Empleado(String nombre, int antiguedad, double sueldo){
        setNombre(nombre);
        setAntiguedad(antiguedad);
        setSueldo(sueldo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public double calcularSueldo(){
        return (double) this.sueldo + (this.sueldo * (0.10 * this.antiguedad));
    }

    @Override
    public String toString() {
        return this.getClass() + "{" + "nombre=" + this.getNombre() + 
                ", sueldo: " + this.calcularSueldoACobrar() + 
                ", antiguedad: " + this.getAntiguedad() + 
                ", efectividad: " + this.calcularEfectividad() + '}';
    }
    
    public abstract double calcularEfectividad();
    public abstract double calcularSueldoACobrar();
    
}
