/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema4;

/*
 * @author Yoel
 */
public class Entrenador extends Empleado{
    private int campeonatosGanados;
    
    public Entrenador(int campeonatosGanados, String nombre, double sueldo, int antiguedad){
        super(nombre, antiguedad, sueldo);
        setCampeonatosGanados(campeonatosGanados);
    }
    
    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }
    
    public double calcularEfectividad(){
        return (double) getCampeonatosGanados()/getAntiguedad();
    }
    public double calcularSueldoACobrar(){
        int campeonatos = getCampeonatosGanados();
        double sueldo = super.calcularSueldo();
        if (campeonatos >= 1 && campeonatos <= 4) sueldo += 5000;
        else if (campeonatos >= 5 && campeonatos <= 10) sueldo += 30000;
        else sueldo += 50000;
        return sueldo;
    }
}
