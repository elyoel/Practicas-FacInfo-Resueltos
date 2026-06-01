package tp5.ejercicio2;

import java.util.ArrayList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;

public class Recorridos<T> {
	public Recorridos() {
	}
	
	public List<T> dfs(Graph<T> grafo){
		List<T> camino = new ArrayList<>();
		if (grafo != null) {
			boolean[] marca = new boolean[grafo.getSize()];
			for (Vertex<T> vertice: grafo.getVertices()) {
				if (!marca[vertice.getPosition()]) {
					dfs(grafo, vertice, marca, camino);
				}
			}
		}
		return camino;
	}
	private void dfs(Graph<T> grafo, Vertex<T> v, boolean[] marca, List<T> camino) {
		Vertex<T> aux;
		marca[v.getPosition()] = true;
		camino.add(v.getData());
		for (Edge<T> adyacente: grafo.getEdges(v)) {
			aux = adyacente.getTarget();
			if (!marca[aux.getPosition()])
				dfs(grafo, aux, marca, camino);
		}
	}
	
	
	
	
	public List<T> bfs(Graph<T> grafo){
		List<T> camino = new ArrayList<>();
		if (grafo != null) {
			boolean[] marca = new boolean[grafo.getSize()];
			for (Vertex<T> vertice: grafo.getVertices()) {
				if (!marca[vertice.getPosition()]) {
					bfs(grafo, vertice, marca, camino);
				}
			}
		}
		return camino;
	}
	private void bfs(Graph<T> grafo, Vertex<T> vertice, boolean[] marca, List<T> camino){
		Vertex<T> aux;
		Queue<Vertex<T>> cola = new Queue<>();
		marca[vertice.getPosition()] = true;
		cola.enqueue(vertice);
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			camino.add(aux.getData());
		
			for (Edge<T> adj: grafo.getEdges(aux)) {
				Vertex<T> target = adj.getTarget();
				if (!marca[target.getPosition()]) {
					marca[target.getPosition()] = true;
					cola.enqueue(target);
				}
			}
		}
	}
}
