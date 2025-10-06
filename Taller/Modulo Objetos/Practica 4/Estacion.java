/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema4;

/*
 * @author Yoel
 */
public class Estacion {
    private String nombre;
    private double latidud,
                   longitud;
    private int anioInicio;
    private double tempMensual[][];
    private int tiempo;

    public Estacion (String unNombre, double unaLatitud, double unaLongitud, int N, int A){
        setAnioInicio(A);
        setLatidud(unaLatitud);
        setLongitud(unaLongitud);
        setNombre(unNombre);
        setTiempo(N);
        
        tempMensual = new double[N][12];
        for (int i = 0; i < getTiempo(); i++){
            for (int j = 0; j < 12; j++) tempMensual[i][j] = 99;
        }
    }

    public void registrarTemperatura(int mes, int anio, double temperatura){
        anio -= getAnioInicio();
        tempMensual[anio][mes-1] = temperatura;
    }

    public double reportarTemperatura(int mes, int anio){
        anio -= getAnioInicio();
        return tempMensual[anio][mes-1];
    }
    
    public String reportarMaximo(){
        double maxTemp = -1;
        String maxIndice = "";
        for (int i = 0; i < getTiempo(); i++){
            for (int j = 0; j < 12; j++){
                if (tempMensual[i][j] > maxTemp){
                    maxIndice = "Año: " + (getAnioInicio()+i) + " Mes: " + (j+1) + " temperatura:" + tempMensual[i][j];
                }
            }
        }
        return maxIndice;
    }
    public String reporteAnual(){
        String aux = getNombre() + "(" + getLatidud() + "-" + getLongitud() + ")" + '\n';
        double prom;
        for (int i = 0; i < getTiempo(); i++){
            prom = 0;
            for (int j = 0; j < 12; j++){
                prom += tempMensual[i][j];
            }
            aux += "-Año " + (i+getAnioInicio()) + ": " + prom + "ºC;" + '\n';
        }
        return aux;
    }
    
    public String reporteMensual(){
        String aux = getNombre() + "(" + getLatidud() + "-" + getLongitud() + ")" + '\n';
        double prom;
        String meses[] = {"- Enero", "- Febrero", "- Marzo", "- Abril", "- Mayo", "- Junio", "- Julio", "- Agosto", "- Septimbre", "- Octubre", "- Noviembre", "- Diciembre"};
        
        for (int j = 0; j < 12; j++){
            prom = 0;
            for (int i = 0; i < getTiempo(); i++){
                prom += tempMensual[i][j];
            }
            aux += meses[j] + ": " + prom + "ºC;" + '\n';
        }
        return aux;
    }
    
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatidud() {
        return latidud;
    }

    public void setLatidud(double latidud) {
        this.latidud = latidud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(int anioInicio) {
        this.anioInicio = anioInicio;
    }
    
    
}
