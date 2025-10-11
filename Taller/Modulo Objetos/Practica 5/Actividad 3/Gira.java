/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class Gira extends Recital{
    private String nombreGira;
    private Fecha fechas[];
    private int fechaActual;
    private int dimL;
    
    public Gira(String nombre, int cantTemas, String nombreGira, int cantfechas) {
        super(nombre, cantTemas);
        this.nombreGira = nombreGira;
        this.fechas = new Fecha[cantfechas];
        this.fechaActual = 0;
        this.dimL = 0;
    }
    
    public void agregarFecha(Fecha unaFecha){
        if  (dimL < this.fechas.length){
            this.fechas[dimL] = unaFecha;
            this.dimL++;
        }
    }
    
    public void actuar(){
        System.out.println("Buenas Noches " + this.fechas[this.fechaActual].getCiudad());
        super.actuar();
        fechaActual++;
        if  (this.fechaActual >= this.dimL) fechaActual = 0;
    }
    
    public double calcularCosto(){
        return 30000 * this.fechas.length;
    }
    
    
}
