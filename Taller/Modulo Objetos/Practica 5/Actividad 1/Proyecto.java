/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class Proyecto {
    private String nombre;
    private int codigo;
    private String director;
    private Investigador investigadores[];
    private int dimL, dimF;
    public Proyecto(String nombre, int codigo, String director) {
        setNombre(nombre);
        setCodigo(codigo);
        setDirector(director);
        this.dimL = 0;
        this.dimF = 50;
        investigadores =  new Investigador[dimF];
    }

    public void agregarInvestigador(Investigador unInvestigador){
        investigadores[dimL] = unInvestigador;
        this.dimL++;
    }
    public double dineroTotalOtorgado(){
        double total = 0;
        for (int i = 0; i < this.dimL; i++){
            total += this.investigadores[i].dineroOtorgado();
        }
        return total;
    }
    public void otorgarTodos(String nombre_completo){
        int i = 0;
        while (i < this.dimL && !this.investigadores[i].getNombre().equals(nombre_completo)){
            i++;
        }
        if (i < this.dimL && this.investigadores[i].getNombre().equals(nombre_completo)){
            this.investigadores[i].otorgarSubsidios();
            System.out.println("Subsidios otorgados a " + nombre_completo);
        } else{
            System.out.println("No se encotro a " + nombre_completo);
        }
    }

    public String toString() {
        String aux = "Proyecto{" + "nombre=" + nombre + ", codigo=" + codigo + ", director=" + director + "dinero total otorgado=" + this.dineroTotalOtorgado() + '}' + '\n';
        for (int i = 0; i < this.dimL; i++){
            aux += investigadores[i].toString() + '\n';
        }
        return aux;
    }
    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    
}
