/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public abstract class Coro {
    private String nombre;
    private Director director;

    public Coro(String nombre, Director director) {
        this.nombre = nombre;
        this.director = director;
    }

    public String toString() {
        String aux = "Coro{" + "nombre: " + this.nombre;
        if (this.estaBienFormado())
            aux += ", Bien formado. ";
        else aux += ", Mal Formado. "; 
        aux += this.director.toString() + '}' + '\n';
        return aux;
        
    }
    
    
    public abstract void agregarCorista(Corista unCorista);
    public abstract boolean estaLleno();
    public abstract boolean estaBienFormado();
    
}
