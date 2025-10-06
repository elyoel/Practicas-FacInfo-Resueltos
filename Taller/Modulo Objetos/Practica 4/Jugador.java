/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema4;

/*
 * @author Yoel
 */
public class Jugador extends Empleado {
    private int golesAnotados;
    private int partidosJugados;
    
    public Jugador(int goles, int cantPartidos, String nombre, double sueldo, int antiguedad){
        super(nombre, antiguedad, sueldo);
        setGolesAnotados(goles);
        setPartidosJugados(cantPartidos);
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
    
    public double calcularEfectividad(){
        return (double) getGolesAnotados()/getPartidosJugados();
    }
    public double calcularSueldoACobrar(){
        double sueldo = super.calcularSueldo();
        if (calcularEfectividad() > 0.5) sueldo += getSueldo();
        return sueldo;
    }
}
