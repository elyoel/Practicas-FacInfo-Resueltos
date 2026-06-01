package tp5.ejercicio5;
import tp5.*;
import java.util.*;
import tp1.ejercicio8.Queue;

public class MirrorBank {
	public static List<Persona> obtenerJubilados(Graph<Persona> grafo, Persona empleado, int distancia) {
		List<Persona> jubilados = new ArrayList<>();
		if (grafo != null && !grafo.isEmpty()) {
			Vertex<Persona> emple = buscarEmpleado(empleado, grafo);
			boolean[] marca = new boolean[grafo.getSize()];
			marca[emple.getPosition()] = true;
			obtenerJubilados(grafo, emple.getPosition(), jubilados, distancia, marca);
		}
		
		return jubilados;
	}
	
	private static Vertex<Persona> buscarEmpleado(Persona data, Graph<Persona> grafo) {
		for (Vertex<Persona> vertex : grafo.getVertices()) {
			if (vertex.getData().getNombre().equals(data.getNombre())) {
				return vertex;
			}
		}
		return null;
	}
	
	private static void obtenerJubilados(Graph<Persona> grafo, int empleado, List<Persona> jubilados, int distanciaMax, boolean[] marca) {
		Queue<Vertex<Persona>> cola = new Queue<>();
		cola.enqueue(grafo.getVertex(empleado));
		cola.enqueue(null);
		int distancia = 0;
		while (!cola.isEmpty() && distancia <= distanciaMax) {
			Vertex<Persona> aux = cola.dequeue();
			if (aux != null) {
				if (aux.getData().getEstado().equals("jubilado") && jubilados.size() <= 40) {
					jubilados.add(aux.getData());
				}
				for (Edge<Persona> adj : grafo.getEdges(aux)) {
					Vertex<Persona> vertice = adj.getTarget();
					marca[aux.getPosition()] = true;
					if (vertice.getData().getEstado().equals("jubilado") && !marca[vertice.getPosition()])
						cola.enqueue(adj.getTarget());
				}
			} else {
				distancia++;
				cola.enqueue(null);
			}
		}
	}
}
