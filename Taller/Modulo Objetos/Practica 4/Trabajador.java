/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema4;

/*
 * @author Yoel
 */
public class Trabajador extends Persona{
    private String tarea;
    
    public Trabajador(String nombre, int dni, int edad, String unTarea){
        super(nombre, dni, edad);
        setTarea(unTarea);
    }

    public String toString(){
        return super.toString() + " Soy " + this.getTarea();
    }
    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    
}
