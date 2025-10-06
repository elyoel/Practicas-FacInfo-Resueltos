/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema4;

/*
 * @author Yoel
 */
public class Triangulo extends Figura {
    private Double lado1,
                   lado2,
                   lado3;
    
    public Triangulo(double a, double b,  double c, String unRelleno, String unLinea){
        super(unRelleno, unLinea);
        setLado1(a);
        setLado2(b);
        setLado3(c);
    }
    
    public double calcularArea(){
        double s = (calcularPerimetro())/2;
        return Math.sqrt(s*(s-getLado1())*(s-getLado2())*(s-getLado3()));
    }
    
    public double calcularPerimetro(){
        return getLado1() + getLado2() + getLado3();
    }
    
    public Double getLado1() {
        return lado1;
    }

    public void setLado1(Double lado1) {
        this.lado1 = lado1;
    }

    public Double getLado2() {
        return lado2;
    }

    public void setLado2(Double lado2) {
        this.lado2 = lado2;
    }

    public Double getLado3() {
        return lado3;
    }

    public void setLado3(Double lado3) {
        this.lado3 = lado3;
    }

    public String toString(){
        return super.toString() +  " Lado 1: " + getLado1() +
                                   " Lado 2: " + getLado2() +
                                   " Lado 3: " + getLado3();
    }
    
    
}
