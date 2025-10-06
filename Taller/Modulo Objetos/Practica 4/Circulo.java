/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema4;

/*
 * @author Yoel
 */
public class Circulo extends Figura {
    private double radio;
    
    public Circulo(double unRadio, String unColorLinea, String unColorRelleno){
        super(unColorRelleno, unColorLinea);
        setRadio(unRadio);
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double getRadio() {
        return radio;
    }
    
    public double calcularPerimetro(){
        return 2 * Math.PI * this.radio;
    }
    public double calcularArea(){
        return Math.PI * (this.radio * this.radio);
    }
    
    public String toString(){
        return super.toString() + " Radio: " + getRadio();
    }
}
   
