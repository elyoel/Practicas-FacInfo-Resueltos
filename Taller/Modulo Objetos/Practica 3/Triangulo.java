/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema3;

/*
 * @author Yoel
 */
public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;
    private String colorRelleno;
    private String colorLinea;

    public Triangulo(double ladoA, double ladoB, double ladoC, String colorRelleno, String colorLinea) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }
    public Triangulo(){
    }
    
    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double unLado) {
        ladoA = unLado;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double unLado) {
        ladoB = unLado;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double unLado) {
        ladoC = unLado;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String unColor) {
        colorRelleno = unColor;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String unColor) {
        colorLinea = unColor;
    }
    
    public double calcularPerimetro(){
        return ladoA + ladoB + ladoC;
    }
    
    public double calcularArea(){
        double s = calcularPerimetro()/2.0;
        return Math.sqrt(s*(s-ladoA)*(s-ladoB)*(s-ladoC));
    }
}
