package tp5.ejercicio3;

import java.util.ArrayList;
import java.util.List;

import tp5.*;
import tp5.listaAdy.*;
public class RecorridoTest {

	public static void main(String[] args) {
		Graph<String> grafo = new AdjListGraph<String>();
		
		Vertex<String> uno = grafo.createVertex("uno");
		Vertex<String> dos = grafo.createVertex("dos");
		Vertex<String> tres = grafo.createVertex("tres");
		Vertex<String> cuatro = grafo.createVertex("cuatro");
		Vertex<String> cinco = grafo.createVertex("cinco");
		Vertex<String> seis = grafo.createVertex("seis");
		Vertex<String> siete = grafo.createVertex("siete");
		Vertex<String> ocho = grafo.createVertex("ocho");
		
		// Conexiones distribuidas entre 8 vértices
		grafo.connect(uno, dos, 45);
		grafo.connect(uno, cuatro, 10);
		grafo.connect(dos, tres, 15);
		grafo.connect(dos, cinco, 98);
		grafo.connect(tres, seis, 33);
		grafo.connect(tres, ocho, 71);
		grafo.connect(cuatro, siete, 30);
		grafo.connect(cinco, uno, 24);
		//grafo.connect(cinco, ocho, 89);
		grafo.connect(seis, dos, 67);
		grafo.connect(seis, siete, 12);
		grafo.connect(siete, ocho, 41);
		grafo.connect(ocho, cuatro, 95);
		
		Mapa mapa = new Mapa(grafo);
		System.out.println(mapa.devolverCamino("uno", "ocho"));
		List<String> ciudades = new ArrayList<>();
		ciudades.add("tres");
		ciudades.add("uno");
		System.out.println(mapa.devolverCaminoExceptuando("dos", "siete", ciudades));
		
		System.out.println(mapa.caminoMasCorto("siete", "uno"));
		
		System.out.println(mapa.caminoSinCargarCombustible("uno", "siete", 200));
	}

}
