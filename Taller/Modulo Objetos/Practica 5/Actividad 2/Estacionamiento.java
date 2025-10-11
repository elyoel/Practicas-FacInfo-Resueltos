/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema5;

/*
 * @author Yoel
 */
public class Estacionamiento {
    private String nombre,
                   direccion,
                   horaApertura,
                   horaCierre;
    private Auto secciones[][];
    private int N, M;
    
    public Estacionamiento(String unNombre, String unaDirrecion, String unaHora1, String unaHora2, int N, int M){
        setNombre(unNombre);
        setDireccion(unaDirrecion);
        setHoraApertura(unaHora1);
        setHoraCierre(unaHora2);
        
        this.N = N;
        this.M = M;
        this.secciones = new Auto[this.N][this.M];
    }
    public Estacionamiento(String unNombre, String unaDir){
        setNombre(unNombre);
        setDireccion(unaDir);
        setHoraApertura("08:00");
        setHoraCierre("21:00");
        
        this.M = 10;
        this.N = 5;
        secciones = new Auto[this.N][this.M];
    }
    
    public void registrarAuto(Auto A, int N, int M){
        this.secciones[N][M] = A;
    }
    
    public String buscarAuto(String unaPatente){
        for (int i = 0; i < this.N; i++){
            for (int j = 0; j < this.M; j++){
                if (!(this.secciones[i][j] == null) && this.secciones[i][j].getPatente().equals(unaPatente)){
                    return "Auto con patente: " + unaPatente + " esta en Piso: " + (i+1) +  " Plaza: " + (j+1);
                }
            }
        }
        return "Auto inexistente";
    }
    public String toString(){
        String aux = "";
        for (int i = 0; i < this.N; i++){
            for (int j = 0; j < this.M; j++){
                aux += "Piso: " + (i+1) +  " Plaza: " + (j+1) + "; ";
                if (!(this.secciones[i][j] == null)){
                    aux += this.secciones[i][j].toString();
                } else{
                    aux += "Libre";
                }
                aux += '\n';
            }
        }
        return aux;
    }
    public int cantAutosPlaza(int unaPlaza){
        int cant = 0;
        for (int i = 0; i< this.N; i++){
            if (this.secciones[i][unaPlaza-1] != null){
                cant++;
            }
        }
        return cant;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }
    
}
