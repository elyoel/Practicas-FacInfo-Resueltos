/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class Investigador {
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio subOtorgado[];
    private int dimL, dimF;
    
    public Investigador(String nombre, int categoria, String especialidad) {
        setNombre(nombre);
        setCategoria(categoria);
        setEspecialidad(especialidad);
        this.dimL = 0;
        this.dimF = 5;
        subOtorgado = new Subsidio[dimF];
    }
    
    public void agregarSubsidio(Subsidio unSubsidio){
        subOtorgado[dimL] = unSubsidio;
        this.dimL++;
    }
    
    public double dineroOtorgado(){
        double total = 0;
        for (int i = 0; i < this.dimL; i++){
            if (subOtorgado[i].isOtorgado()){
                total += subOtorgado[i].getMonto();
            }
        }
        return total;
    }
   
    public void otorgarSubsidios(){
        for (int i = 0; i < this.dimL; i++){
            if (!this.subOtorgado[i].isOtorgado()){
                this.subOtorgado[i].setOtorgado(true);
            }
        }
    }

    public String toString() {
        return "Investigador{" + "nombre=" + nombre + ", categoria=" + categoria + ", especialidad=" + especialidad + ", dinero otorgado=" + this.dineroOtorgado() + '}';
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
