package tp5.ejercicio8;

import tp5.*;
import tp1.ejercicio8.Queue;

public class RedNeuronas {
	public int neuronasActivadas(Graph<String> grafo, String inicio, int impulso){
		int cont = 0;
		if (grafo != null && !grafo.isEmpty()) {
			Vertex<String> ini = grafo.search(inicio);
			if (ini != null) {
				cont = neuronasActivas(grafo, ini.getPosition(), impulso);
			}
		}
		return cont;
	}
	private int neuronasActivas(Graph<String> grafo, int pos, int impulso) {
		Vertex<String> aux;
		Queue<Vertex<String>> cola = new Queue<>();
		cola.enqueue(grafo.getVertex(pos));
		cola.enqueue(null);
		int cont = 0;
		impulso *= 0.9;
		while (!cola.isEmpty()) {
			
			aux = cola.dequeue();
			if (aux != null) {
				cont++;
				for (Edge<String> adj : grafo.getEdges(aux)) {
					Vertex<String> vertice = adj.getTarget();
					if ( adj.getWeight() > impulso) {
						cola.enqueue(vertice);
					}
				}
			} else if (!cola.isEmpty()){
				impulso *= 0.9;
				cola.enqueue(null);
			}
		}
		return cont;
	}
}
