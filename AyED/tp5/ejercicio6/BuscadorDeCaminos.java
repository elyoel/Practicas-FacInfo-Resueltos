package tp5.ejercicio6;

import tp5.*;
import java.util.*;

public class BuscadorDeCaminos {
	private Graph<String> bosque;
	
	public BuscadorDeCaminos(Graph<String> grafo) {
		this.bosque = grafo;
	}
	
	public List<List<String>> recorridosMasSeguro(){
		List<List<String>> caminos = new ArrayList<>();
		if (this.bosque != null && !this.bosque.isEmpty()) {
			Vertex<String> caperucita = this.bosque.search("Casa Caperucita");
			if (caperucita != null) {
				boolean[] marca = new boolean[this.bosque.getSize()];
				recorridoMasSeguro(this.bosque, caperucita.getPosition(), marca, new ArrayList<String>(), caminos);
			}
		}
		return caminos;
	}
	private void recorridoMasSeguro(Graph<String> grafo, int pos, boolean[] marca, List<String> actual, List<List<String>> caminos) {
		marca[pos] = true;
		Vertex<String> v = grafo.getVertex(pos);
		actual.add(v.getData());
		if (v.getData().equals("Casa Abuelita")) {
			caminos.add(new ArrayList<>(actual));
		} else {
			for (Edge<String> adj : grafo.getEdges(v)){
				Vertex<String> vertice = adj.getTarget();
				if (adj.getWeight() <= 5 && !marca[vertice.getPosition()])
					recorridoMasSeguro(grafo, vertice.getPosition(), marca, actual, caminos);
			}
		}
 		marca[pos] = false;
		actual.removeLast();
	}
}
