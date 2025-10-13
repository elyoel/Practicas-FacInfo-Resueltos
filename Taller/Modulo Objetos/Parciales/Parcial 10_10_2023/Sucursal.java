/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parciales.newpackage;

/*
 * @author Yoel
 */
public class Sucursal {
    private Encargado encargado;
    
    public Sucursal(){
        this.encargado = null;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
        
    }

    public Encargado getEncargado() {
        return this.encargado;
    }
    
}
