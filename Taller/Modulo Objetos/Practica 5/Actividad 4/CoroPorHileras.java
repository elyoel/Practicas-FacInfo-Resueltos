/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class CoroPorHileras extends Coro{
    private Corista coristas[][];
    private int dimL;
    private final int DF,  DC;


    public CoroPorHileras(String nombre, Director director, int hileras, int cantIntegrantes){
        super(nombre, director);
        this.DF = hileras;
        this.DC = cantIntegrantes;
        this.coristas = new Corista[DF][DC];
        this.dimL = 0;
    }
    
    public void agregarCorista(Corista unCorista){
        if (!this.estaLleno()){
            this.coristas[this.dimL/this.DC][this.dimL%this.DC] = unCorista;
            this.dimL++;
        }
    }
    
    public boolean estaLleno(){
        return this.dimL == this.DF * this.DC;
    }

    public boolean estaBienFormado() {
        int i = 0, j = 0;
        boolean cumple = false;
        if (this.estaLleno()){
            int ant = this.coristas[i][0].getTono();
            cumple = true;
            while (i < this.DF  && cumple){
                j = 0;
                int act = this.coristas[i][0].getTono();
                cumple = (ant <= act);
                ant = act;
                while (j < this.DC && cumple){
                    cumple = (this.coristas[i][j].getTono() == act);
                    j++;
                }
                i++;
            }
        }
        return cumple;
    }
    
    public String toString(){
        String aux = super.toString();
        for (int i = 0; i < this.dimL; i++){
            aux += coristas[i/this.DC][i%this.DC].toString() + '\n';
        }
        return aux;
    }   
}
