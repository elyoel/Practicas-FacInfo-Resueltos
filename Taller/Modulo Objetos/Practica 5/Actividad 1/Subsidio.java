/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class Subsidio {
    private String motivo;
    private double monto;
    private boolean otorgado;

    public Subsidio(String motivo, double monto) {
        setMonto(monto);
        setMotivo(motivo);
        setOtorgado(false);
    }

    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isOtorgado() {
        return otorgado;
    }
    
    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }
    
    
   
   
}
