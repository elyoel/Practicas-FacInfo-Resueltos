/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage;

/*
 * @author Yoel
 */
public class Empresa {
    private String nombre;
    private String direccion;
    private DirectorEjecutivo director;
    private Encargado sucursales[];
    private int dimF;

    public Empresa(String nombre, String direccion, DirectorEjecutivo director, int N) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.director = director;
        this.dimF = N;
        this.sucursales = new Sucursal[dimF];
        for (int i = 0; i < dimF; i++){
            this.sucursales[i] = null;
        }
    }
    
    public void asignarEncargado(Encargado unEncargado, int X){
        this.sucursales[X-1] = unEncargado;
    }
    
    public String toString(){
        String aux = this.nombre + ", " + this.direccion + '\n';
        aux += this.director.toString() + '\n';
        for (int i = 0; i < this.dimF; i++){
            aux += "Numero de sucursal: " + (i+1) + ", ";
            if (this.sucursales[i] != null)
                aux += this.sucursales[i].toString() + '\n';
            else
                aux += "Sin encargados" + '\n';
        }
        return aux;
    }
}
