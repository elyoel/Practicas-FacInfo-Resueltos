package tp5.ejercicio3;

import tp5.Edge;
import tp5.Graph;
import tp5.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> grafo) {
		this.mapaCiudades = grafo;
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2) {
		List<String> camino = new ArrayList<>();
		if (this.mapaCiudades != null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> c1 = this.mapaCiudades.search(ciudad1);
			Vertex<String> c2 = this.mapaCiudades.search(ciudad2);
			if (c1 != null && c2 != null) {
				boolean[] marca = new boolean[this.mapaCiudades.getSize()];
				devolverCamino(this.mapaCiudades, c1.getPosition(), c2.getPosition(), new ArrayList<String>(), camino, marca);
			}
		}
		return camino;
	}	
	private void devolverCamino(Graph<String> ciudad, int c1, int c2, List<String> actual, List<String> camino, boolean[] marca) {
		marca[c1] = true;
		actual.add(ciudad.getVertex(c1).getData());
		if (c1 == c2) {
			camino.addAll(actual);
		} else {
			for (Edge<String> adj : ciudad.getEdges(ciudad.getVertex(c1))) {
				Vertex<String> vertice = adj.getTarget();
				if (!marca[vertice.getPosition()]) {
					devolverCamino(ciudad, vertice.getPosition(), c2, actual, camino, marca);
					
				}
			}
		}
		actual.removeLast();
	}
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new ArrayList<>();
		if (this.mapaCiudades != null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> c1 = this.mapaCiudades.search(ciudad1);
			Vertex<String> c2 = this.mapaCiudades.search(ciudad2);
			if (c1 != null && c2 != null) {
				boolean[] marca = new boolean[this.mapaCiudades.getSize()];
				devolverCaminoExeptuando(this.mapaCiudades, c1, c2, new ArrayList<String>(), camino, marca, ciudades);
			}
		}
		return camino;
	}
	private void devolverCaminoExeptuando(Graph<String> ciudad, Vertex<String> c1, Vertex<String> c2, List<String> actual, List<String> camino, boolean[] marca, List<String> ciudades) {
		marca[c1.getPosition()] = true;
		actual.add(c1.getData());
		if (c1.getData().equals(c2.getData())) {
			camino.addAll(actual);
		} else {
			for (Edge<String> adj : ciudad.getEdges(c1)) {
				Vertex<String> vertice = adj.getTarget();
				if (!marca[vertice.getPosition()] && !ciudades.contains(vertice.getData())) {
					devolverCaminoExeptuando(ciudad, vertice, c2, actual, camino, marca, ciudades);
				}
			}
		}
		actual.removeLast();
	}
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> camino = new ArrayList<>();
		if (this.mapaCiudades != null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> c1 = this.mapaCiudades.search(ciudad1);
			Vertex<String> c2 = this.mapaCiudades.search(ciudad2);
			if (c1 != null && c2 != null) {
				boolean[] marca = new boolean[this.mapaCiudades.getSize()];
				caminoMasCorto(this.mapaCiudades, c1, c2, new ArrayList<String>(), camino, marca, 0, Integer.MAX_VALUE);
				
			}
		}
		
		return camino;
	}
	private int caminoMasCorto(Graph<String> grafo, Vertex<String> c1, Vertex<String> c2, List<String> actual, List<String> camino, boolean[] marca, int distancia, int min) {
		marca[c1.getPosition()] = true;
		actual.add(c1.getData());
		if (c1.getData().equals(c2.getData())){
			if (distancia < min) {
				min = distancia;
				camino.clear();
				camino.addAll(actual);
			}
		} else {
			for (Edge<String> adj : grafo.getEdges(c1)) {
				Vertex<String> vertice = adj.getTarget();
				if (!marca[vertice.getPosition()])
					min = caminoMasCorto(grafo, vertice, c2, actual, camino, marca, distancia + adj.getWeight(), min);
			}
		}
		marca[c1.getPosition()] = false;
		actual.removeLast();
		return min;
	}
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> camino = new ArrayList<>();
		if (this.mapaCiudades != null && !this.mapaCiudades.isEmpty()) {
			Vertex<String> c1 = this.mapaCiudades.search(ciudad1);
			if (c1 != null && this.mapaCiudades.search(ciudad2) != null) {
				boolean[] marca = new boolean[this.mapaCiudades.getSize()];
				caminoSinCargarCombustible(this.mapaCiudades, c1, ciudad2, new ArrayList<>(), camino, marca, tanqueAuto);
			}
		}
		return camino;
	}
	private void caminoSinCargarCombustible(Graph<String> grafo, Vertex<String> c1, String c2, List<String> actual, List<String> camino, boolean[] marca, int tanqueAuto) {
		marca[c1.getPosition()] = true;
		actual.add(c1.getData());
		if (c1.getData().equals(c2)) {
			camino.addAll(actual);
		} else {
			for (Edge<String> adj : grafo.getEdges(c1)) {
				Vertex<String> vertice = adj.getTarget();
				if (!marca[vertice.getPosition()] && tanqueAuto > adj.getWeight())
					caminoSinCargarCombustible(grafo, vertice, c2, actual, camino, marca, tanqueAuto - adj.getWeight());
			}
		}
		actual.removeLast();
	}
	
}
