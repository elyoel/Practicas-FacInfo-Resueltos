package tp5.ejercicio6;

import java.util.List;

import tp5.*;
import tp5.listaAdy.*;

public class BuscadorDeCaminosTest {

	public static void main(String[] args) {
		Graph<String> bosque = new AdjListGraph<>();
		// Creación de vértices
		Vertex<String> casaCaperucita = bosque.createVertex("Casa Caperucita");
		Vertex<String> claro1 = bosque.createVertex("Claro 1");
		Vertex<String> claro2 = bosque.createVertex("Claro 2");
		Vertex<String> claro3 = bosque.createVertex("Claro 3");
		Vertex<String> claro4 = bosque.createVertex("Claro 4");
		Vertex<String> claro5 = bosque.createVertex("Claro 5");
		Vertex<String> casaAbuelita = bosque.createVertex("Casa Abuelita");

		// Conexiones bidireccionales (Grafo no dirigido) con sus pesos
		bosque.connect(casaCaperucita, claro3, 4); bosque.connect(claro3, casaCaperucita, 4);
		bosque.connect(casaCaperucita, claro1, 3); bosque.connect(claro1, casaCaperucita, 3);
		bosque.connect(casaCaperucita, claro2, 4); bosque.connect(claro2, casaCaperucita, 4);

		bosque.connect(claro3, claro5, 15); bosque.connect(claro5, claro3, 15);

		bosque.connect(claro1, claro2, 4); bosque.connect(claro2, claro1, 4);
		bosque.connect(claro1, claro5, 3); bosque.connect(claro5, claro1, 3);

		bosque.connect(claro2, claro5, 11); bosque.connect(claro5, claro2, 11);
		bosque.connect(claro2, claro4, 10); bosque.connect(claro4, claro2, 10);

		bosque.connect(claro5, casaAbuelita, 4); bosque.connect(casaAbuelita, claro5, 4);

		bosque.connect(claro4, casaAbuelita, 9); bosque.connect(casaAbuelita, claro4, 9);
		
		BuscadorDeCaminos caminos = new BuscadorDeCaminos(bosque);
		for (List<String> camino : caminos.recorridosMasSeguro()) {
			System.out.println(camino);
		}
	}

}
