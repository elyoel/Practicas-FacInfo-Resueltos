package tp5.ejercicio8;

import tp5.*;
import tp5.listaAdy.*;

public class RedNeronasTets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedNeuronas red = new RedNeuronas();
		Graph<String> redNeuronas = new AdjListGraph<>();
		// Creación de vértices
		Vertex<String> n1 = redNeuronas.createVertex("N1");
		Vertex<String> n2 = redNeuronas.createVertex("N2");
		Vertex<String> n3 = redNeuronas.createVertex("N3");
		Vertex<String> n4 = redNeuronas.createVertex("N4");
		Vertex<String> n5 = redNeuronas.createVertex("N5");
		Vertex<String> n6 = redNeuronas.createVertex("N6");
		Vertex<String> n7 = redNeuronas.createVertex("N7");
		Vertex<String> n8 = redNeuronas.createVertex("N8");
		Vertex<String> n9 = redNeuronas.createVertex("N9");

		// Conexiones dirigidas (un solo sentido) con sus pesos
		redNeuronas.connect(n1, n2, 200);
		redNeuronas.connect(n1, n3, 80);
		redNeuronas.connect(n1, n7, 100);

		redNeuronas.connect(n3, n2, 20);
		redNeuronas.connect(n3, n4, 1000);
		redNeuronas.connect(n3, n5, 5);
		redNeuronas.connect(n3, n6, 100);

		redNeuronas.connect(n7, n8, 90);
		redNeuronas.connect(n7, n9, 10);

		redNeuronas.connect(n8, n9, 70);
		
		System.out.println(red.neuronasActivadas(redNeuronas, "N1", 100));
	}

}
