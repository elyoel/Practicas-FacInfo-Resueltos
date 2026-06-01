package tp3.ejercicio4;

import tp1.ejercicio8.Queue;
import tp3.GeneralTree;

public class AnalizarArbol {
	public static double devolverMaximoPromedio (GeneralTree<Integer>arbol) {
		double max = 0, prom = 0; 
		int cant = 0;
		GeneralTree<Integer> aux;
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if (aux != null) {
				for (GeneralTree<Integer> child: aux.getChildren()) {
					cola.enqueue(child);
				}
				prom += aux.getData();
				cant++;
			} else {
				if (!cola.isEmpty())
					cola.enqueue(null);
					
				prom /= cant;
				if (prom > max)	max = prom;
				prom = 0;
				cant = 0;
			}
		}
		return max;
	}
}
