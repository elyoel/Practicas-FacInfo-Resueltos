package tp5.ejercicio5;
import tp5.*;
import tp5.listaAdy.*;

public class MirrorBankTest {

	public static void main(String[] args) {
		
		Graph<Persona> grafo = new AdjListGraph<Persona>();
		// Creación de vértices
		// Creación de vértices (Empleados)
		Persona empleado2 = new Persona("Empleado 2", "-", "empleado");
		Vertex<Persona> emp1 = grafo.createVertex(new Persona("Empleado 1", "-", "empleado"));
		Vertex<Persona> emp2 = grafo.createVertex(empleado2);
		Vertex<Persona> emp3 = grafo.createVertex(new Persona("Empleado 3", "-", "empleado"));

		// Creación de vértices (Jubilados)
		Vertex<Persona> jub4 = grafo.createVertex(new Persona("Jubilado 4", "-", "jubilado"));
		Vertex<Persona> jub5 = grafo.createVertex(new Persona("Jubilado 5", "-", "jubilado"));
		Vertex<Persona> jub6 = grafo.createVertex(new Persona("Jubilado 6", "-", "jubilado"));
		Vertex<Persona> jub7 = grafo.createVertex(new Persona("Jubilado 7", "-", "jubilado"));
		Vertex<Persona> jub8 = grafo.createVertex(new Persona("Jubilado 8", "-", "jubilado"));
		Vertex<Persona> jub9 = grafo.createVertex(new Persona("Jubilado 9", "-", "jubilado"));
		Vertex<Persona> jub10 = grafo.createVertex(new Persona("Jubilado 10", "-", "jubilado"));
		Vertex<Persona> jub11 = grafo.createVertex(new Persona("Jubilado 11", "-", "jubilado"));
		Vertex<Persona> jub12 = grafo.createVertex(new Persona("Jubilado 12", "-", "jubilado"));
		Vertex<Persona> jub13 = grafo.createVertex(new Persona("Jubilado 13", "-", "jubilado"));
		Vertex<Persona> jub14 = grafo.createVertex(new Persona("Jubilado 14", "-", "jubilado"));

		// Conexiones bidireccionales (Grafo no dirigido)
		grafo.connect(emp1, emp2); grafo.connect(emp2, emp1);

		grafo.connect(emp2, jub4); grafo.connect(jub4, emp2);
		grafo.connect(emp2, jub5); grafo.connect(jub5, emp2);
		grafo.connect(emp2, jub6); grafo.connect(jub6, emp2);
		grafo.connect(emp2, jub7); grafo.connect(jub7, emp2);
		grafo.connect(emp2, jub8); grafo.connect(jub8, emp2);

		grafo.connect(jub4, jub9); grafo.connect(jub9, jub4);
		grafo.connect(jub4, jub10); grafo.connect(jub10, jub4);
		grafo.connect(jub4, jub11); grafo.connect(jub11, jub4);

		grafo.connect(jub5, emp3); grafo.connect(emp3, jub5);
		grafo.connect(jub5, jub12); grafo.connect(jub12, jub5);

		grafo.connect(jub6, jub13); grafo.connect(jub13, jub6);
		grafo.connect(jub6, jub14); grafo.connect(jub14, jub6);
		
		for (Persona p: MirrorBank.obtenerJubilados(grafo, empleado2 , 1)) {
			System.out.println(p.getNombre());
		}
	}

}
