package tp5.ejercicio2;

import tp5.Graph;
import tp5.Vertex;
import tp5.listaAdy.AdjListGraph;
import java.util.*;

public class RecorridoTest {

	public static void main(String[] args) {
		Graph<String> grafo = new AdjListGraph<String>();
		
		Vertex<String> uno = grafo.createVertex("uno");
		Vertex<String> dos = grafo.createVertex("dos");
		Vertex<String> tres = grafo.createVertex("tres");
		Vertex<String> cuatro = grafo.createVertex("cuatro");
		Vertex<String> cinco = grafo.createVertex("cinco");
		Vertex<String> seis = grafo.createVertex("seis");
		
		grafo.connect(uno, dos);
		grafo.connect(uno, tres);
		grafo.connect(dos, tres);
		grafo.connect(tres, seis);
		grafo.connect(cuatro, uno);
		grafo.connect(cuatro, cinco);
		grafo.connect(cinco, dos);
		grafo.connect(cinco, seis);
		grafo.connect(seis, uno);
		grafo.connect(seis, dos);

		
		Recorridos<String> recorrido = new Recorridos<String>();
		
		System.out.println(recorrido.dfs(grafo));
		System.out.println(recorrido.bfs(grafo));
	}

}
