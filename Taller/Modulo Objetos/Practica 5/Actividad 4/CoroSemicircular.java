/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class CoroSemicircular extends Coro{
    private Corista coristas[];
    private int dimL;
    private  final int dimF;
    public CoroSemicircular(String nombre, Director director,int cantCoristas) {
        super(nombre, director);
        this.dimF =  cantCoristas;
        this.dimL = 0;
        this.coristas = new Corista[cantCoristas];

    }
    
    public void agregarCorista(Corista unCorista){
        if  (!estaLleno()){
            this.coristas[dimL] = unCorista;
            this.dimL++;   
        }
    }
    
    public boolean estaLleno(){
        return this.dimL == dimF;
    }

    public boolean estaBienFormado(){
        int ant, i = 1;
        boolean cumple = false;
        if (this.estaLleno()){ 
            cumple = true;
            while (i < this.dimF && cumple){
                ant = this.coristas[i-1].getTono();
                cumple = (ant < this.coristas[i].getTono());
                i++;
            }
        }
        return cumple;
    }
    
    public String toString(){
        String aux = super.toString();
        for (int i = 0; i < this.dimL; i++){
            aux += this.coristas[i].toString() + '\n';
        }
        return aux;
    }
    
}
