/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public abstract class Recital {
    private String nombreBanda;
    private String temas[];
    private int dimL;
    
    public Recital(String unNombreString, int cantTemas){
        this.nombreBanda = unNombreString;
        this.dimL = 0;
        this.temas = new String[cantTemas];
    }
    
    public void agregarTema(String tema){
        if (this.dimL < this.temas.length){
            this.temas[this.dimL] = tema;
            dimL++;
        }
    }
    
    public void actuar(){
        for (int i = 0; i < this.temas.length; i++){
            System.out.println("y ahora tocaremos " + this.temas[i]);
        }
    }
    
    public abstract double calcularCosto();
}
