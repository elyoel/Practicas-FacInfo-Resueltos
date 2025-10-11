/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class EventoOcasional extends Recital{
    private String motivo;
    private String nombreContratante;
    private Fecha dia;
    
    public EventoOcasional(String nombreRecital, int cantTemas, String motivo, String nombreContrante, Fecha fecha){
        super(nombreRecital, cantTemas);
        this.motivo = motivo;
        this.nombreContratante = nombreContrante;
        this.dia = fecha;
    }
    
    public void actuar(){
        
        switch (this.motivo){
            case "Beneficiencia":
                System.out.println("Recuerden colaborar con " + this.nombreContratante);
                break;
            case "TV":
                System.out.println("Saludos amigos televidentes");
                break;
            case "Privado":
                System.out.println("Un feliz cumpleaños para " + this.nombreContratante);
                break;
        }
        super.actuar();
    }
    
    public double calcularCosto(){
        double costo = 0;
        switch (this.motivo){
            case "TV":
                costo += 50000;
                break;
            case "Privado":
                costo += 150000;
        }
        return costo;
    }
}
