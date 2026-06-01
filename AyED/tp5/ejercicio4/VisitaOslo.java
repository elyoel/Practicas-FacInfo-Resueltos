package tp5.ejercicio4;
import java.util.*;
import tp5.*;

public class VisitaOslo {
	
	public static List<String> paseoEnBici (Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos){
		List<String> camino = new ArrayList<>();
		if (lugares != null && !lugares.isEmpty()) {
			Vertex<String> ay = lugares.search("Ayuntamiento");
			if (ay != null) {				
				boolean[] marcas = new boolean[lugares.getSize()];
				paseoEnBici(lugares, ay, destino, new ArrayList<String>(), camino, maxTiempo, lugaresRestringidos, marcas);
			}
		}
		return camino;
	}
	private static boolean paseoEnBici(Graph<String> grafo, Vertex<String> ini, String fin, List<String> actual, List<String> camino, int maxTiempo, List<String> lugaresRestringidos, boolean[] marcas) {
		marcas[ini.getPosition()] = true;
		actual.add(ini.getData());
		boolean encontre = false;
		if (ini.getData().equals(fin)) {
			camino.addAll(actual);
			encontre = true;
		} else {
			Iterator<Edge<String>> it = grafo.getEdges(ini).iterator();
			while (it.hasNext() && !encontre){
				Edge<String> adj = it.next();
				Vertex<String> vertice = adj.getTarget();
				if (!marcas[vertice.getPosition()])
					if (!lugaresRestringidos.contains(vertice.getData()) && maxTiempo > adj.getWeight()) {
					encontre = paseoEnBici(grafo, vertice, fin, actual, camino, maxTiempo - adj.getWeight(), lugaresRestringidos, marcas);
				}
			}
		}
		actual.removeLast();
		return encontre;
	}
}

