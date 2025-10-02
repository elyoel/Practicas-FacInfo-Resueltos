/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema3;

/*
 * @author Yoel
 */
public class Autor {
    private String nombre,
                   biografia,
                   origen;
    
    public Autor(String nombre, String Biografia, String origen) {
        this.nombre = nombre;
        this.biografia = Biografia;
        this.origen = origen;
    }
    public Autor(){
        nombre =  "-";
        biografia = "-";
        origen = "-";
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String Biografia) {
        this.biografia = Biografia;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString(){
        return "Mi nombre es " + nombre + ", soy de " + origen + ". biografia: " + biografia;
    }
    
    

}
