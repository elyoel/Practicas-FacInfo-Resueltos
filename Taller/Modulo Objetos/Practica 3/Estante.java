/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema3;

/*
 * @author Yoel
 */
public class Estante {
    private final int dimF = 20;
    private int dimL = 0;
    private Libro[] libros;

    public Estante() {
        libros =  new Libro[dimF];
    }
    public int getAlmacenados(){
        return dimL;
    }
    public boolean estaLleno(){
        return dimL == dimF;
    }
    public void agregarLibro(Libro l){
        if (dimL < dimF){
            libros[dimL++] = l;
        }
    }
    
    public Libro getLibro(String unTitulo){
        if (getAlmacenados() >= 1){
            for (int i = 0; i <  dimL; i++){
                if (libros[i].getTitulo().equals(unTitulo)){
                        return libros[i];
                }
            }
        }
        return null;
    }
    
    
    
}
