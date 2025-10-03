/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema3;
import PaqueteLectura.GeneradorAleatorio;
/*
 * @author Yoel
 */

public class Habitacion {
    
    private double costo;
    private boolean ocupada;
    private Persona cliente;

    public Habitacion(){
        GeneradorAleatorio.iniciar();
        ocupada = false;
        costo = GeneradorAleatorio.generarDouble(8000-2000) + 2000;
        cliente = null;
    }
    
    public void setCliente(Persona cliente){
        this.cliente = cliente;
    }
    public Persona getCliente(){
        return  cliente;
    }
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    
}

