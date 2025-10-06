/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

public class Persona {
    private String nombre;
    private int DNI;
    private int edad; 
    
    public Persona(String unNombre, int unDNI, int unaEdad){
        setNombre(unNombre);
        setDNI(unDNI);
        setEdad(unaEdad);
    }
    
    public Persona(){
     
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int unDNI) {
        this.DNI = unDNI;
    }

    public void setEdad(int unaEdad) {
        this.edad = unaEdad;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }
    
    public String toString(){
        String aux; 
        aux = "Mi nombre es " + this.nombre + ", mi DNI es " + this.DNI + " y tengo " + this.edad + " años.";
        return aux;
    }
    
    
    
    
}
