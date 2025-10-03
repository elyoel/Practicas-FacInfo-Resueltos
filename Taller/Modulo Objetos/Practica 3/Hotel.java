/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema3;

/*
 * @author Yoel
 */
public class Hotel {
    private Habitacion[] habitaciones;
    private int dimL;
    private int dimF;

    public Hotel(int Nhabitaciones){
        dimF = Nhabitaciones;
        habitaciones = new Habitacion[dimF];
        dimL = 0;
        for (int i = 0; i < dimF; i++){
            habitaciones[i] = new Habitacion();
        }
        
    }

    public void agregarCliente(Persona cliente, int habitacionX){
        habitaciones[habitacionX-1].setCliente(cliente);
        habitaciones[habitacionX-1].setOcupada(true);
        dimL++;
    }

    public void aumentarCosto(double costroExtra){
        for (Habitacion h: habitaciones){
            h.setCosto(h.getCosto() + costroExtra);
        }
    }
    
    public int habitacionesOcupadas() {
        return dimL;
    }
    public boolean estaLleno(){
        return dimL == dimF;
    }
    
    public void toHotel(){
        String aux;
        int i = 1;
        for (Habitacion h: habitaciones) {
            aux = "{Habitación "+ i++ + ", costo: "+ h.getCosto()+ ", esta ocupada: "+  h.estaOcupada();
            if (h.estaOcupada()) aux += ", "+ h.getCliente().getNombre();
            aux += "}";
            System.out.println(aux);
        }
    }
}
