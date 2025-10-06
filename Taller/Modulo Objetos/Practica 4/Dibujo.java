/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema4;

/*
 * @author Yoel
 */
public class Dibujo {
    private String titulo;
    private Figura [] vector;
    private int guardadas;
    private int capacidadMaxima=10;
    
    //inicia el dibujo, sin figuras
    public Dibujo (String titulo){
        vector = new Figura[capacidadMaxima];
        this.titulo = titulo;
        this.guardadas = 0;
    }

    //agrega la figura al dibujo
    public void agregar(Figura f){
        this.vector[guardadas] = f;
        this.guardadas++;
        System.out.println("la figura " + f.toString() + " se ha guardado");
    }

    //calcula el área del dibujo:
    //suma de las áreas de sus figuras
    public double calcularArea(){
        double aux = 0;
        for (int i = 0; i < guardadas; i++){
            aux += this.vector[i].calcularArea();
        }
        return aux;
    }
    
    //imprime el título, representación
    //de cada figura, y área del dibujo
    public void mostrar(){
        for (int i = 0; i < guardadas; i++){
            System.out.println(this.vector[i].toString());
        }
    }
    
    //retorna está lleno el dibujo
    public boolean estaLleno() {
    return (guardadas == capacidadMaxima);
    }
}