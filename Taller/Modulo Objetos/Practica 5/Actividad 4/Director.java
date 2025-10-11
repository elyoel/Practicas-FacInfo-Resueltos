/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class Director extends Persona{
    private int antiguedad;

    public Director(int antiguedad, String nombre, int edad, int dni) {
        super(nombre, edad, dni);
        this.antiguedad = antiguedad;
    }

    public String toString() {
        return "Director{" + super.toString() + ", antiguedad: " + this.antiguedad + '}';
    }
    
    
}
