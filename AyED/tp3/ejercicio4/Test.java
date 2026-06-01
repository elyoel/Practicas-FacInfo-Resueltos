package tp3.ejercicio4;

import java.util.LinkedList;
import java.util.List;

import tp3.GeneralTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(14);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(4));
		children2.add(new GeneralTree<Integer>(7));
		children2.add(new GeneralTree<Integer>(6));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(25, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(19));
		
		List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
		children4.add(new GeneralTree<Integer>(5));
		
		children3.add(new GeneralTree<Integer>(6, children4));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(25, children3);
		List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
		childen.add(a1);
		childen.add(a2);
		childen.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(1, childen);
		System.out.println("Datos del Arbol: ");
		
		System.out.println(AnalizarArbol.devolverMaximoPromedio(a));
		
		System.out.println(a.esAncestro(25, 5));
	}

}
