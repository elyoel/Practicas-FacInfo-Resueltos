/*
 5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:
getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” X
setVisitante(X) modifica el nombre del equipo visitante al “String” X
setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna
un String vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
- Para cada partido, armar e informar una representación String del estilo:
{EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
- Calcular e informar la cantidad de partidos que ganó River.
- Calcular e informar el total de goles que realizó Boca jugando de local.
 */
package tema2;
import PaqueteLectura.Lector;
/**
 *
 * @author Yoel
 */
public class Actividad_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int DimF =  20, DimL = 0;
        Partido campeonato[] = new Partido[DimF];
        String equipo;
        System.out.println("Ingrese Equipo Visitante: ");
        equipo = Lector.leerString();
        while (!equipo.equals("ZZZ") && DimL < DimF){
            campeonato[DimL] = new Partido();
            campeonato[DimL].setVisitante(equipo);
            System.out.println("Ingrese Goles Visitante: ");
            campeonato[DimL].setGolesVisitante(Lector.leerInt());    
            System.out.println("Ingrese Equipo Local: ");
            campeonato[DimL].setLocal(Lector.leerString());
            System.out.println("Ingrese Goles Local: ");
            campeonato[DimL].setGolesLocal(Lector.leerInt());
            System.out.println("Patido Cargado...");
            DimL++;
            System.out.println("Ingrese Equipo Visitante: ");
            equipo = Lector.leerString();
        }
        /*
        Para cada partido, armar e informar una representación String del estilo:
            {EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
        */
        int i;
        for (i = 0; i < DimL; 
                System.out.println("{" + campeonato[i].getLocal().toUpperCase() + "-" + campeonato[i].getGolesLocal()+ " VS " + campeonato[i].getVisitante().toUpperCase() + "-" + campeonato[i++].getGolesVisitante() + "}"));
        
        /*
        Calcular e informar la cantidad de partidos que ganó River
        */
        int cant = 0;
        for (i = 0; i < DimL; i++){
            if (campeonato[i].getGanador().equals("river")) cant++;
        }
        System.out.println("Cantidad de partidos que gano river: " + cant);
        
        /*
        Calcular e informar el total de goles que realizó Boca jugando de local.
        */
        cant = 0;
        for (i = 0; i < DimL; i++){
            if (campeonato[i].getLocal().equals("boca")) cant += campeonato[i].getGolesLocal();
        }
        System.out.println("Total de goles que realizó Boca jugando de local: " + cant);
    }
    
}
