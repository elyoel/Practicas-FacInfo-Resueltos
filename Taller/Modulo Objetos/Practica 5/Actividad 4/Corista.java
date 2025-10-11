/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class Corista extends Persona{
    private int tonoFundamental;

    public Corista(int tonoFundamental, String nombre, int edad, int dni) {
        super(nombre, edad, dni);
        this.tonoFundamental = tonoFundamental;
    }
    
    public int getTono(){
        return this.tonoFundamental;
    }

    public String toString() {
        return "Corista{" + super.toString() + ", tonoFundamental: " + this.tonoFundamental + '}';
    }
    
    
}
