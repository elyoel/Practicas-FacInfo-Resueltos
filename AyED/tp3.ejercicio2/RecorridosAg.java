package tp3.ejercicio2;

import java.util.List;
import java.util.ArrayList;
import tp3.Queue;

import tp3.GeneralTree;

public class RecorridosAg {
	private boolean verificar(Integer n, Integer valor) {
		return (n % 2 == 0) && (valor > n);
	}

	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> list = new ArrayList<>();
		if (a != null)
			recorridoPreOrden(a, n, list);
		return list;
	}
	private void recorridoPreOrden(GeneralTree <Integer> a, Integer n, List<Integer> l) {
		int data = a.getData();
		if (verificar(n, data))
			l.add(data);
		
		for (GeneralTree<Integer> child : a.getChildren()) {
			recorridoPreOrden(child, n, l);
		}
	}
	
	//public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> ls = new ArrayList<>();
		if (a != null)
			recorridoPostOrden(a, n, ls);
		return ls;
	}
	private void recorridoPostOrden(GeneralTree <Integer> a, Integer n, List<Integer> ls) {
		for (GeneralTree<Integer> child : a.getChildren()){
			recorridoPostOrden(child, n, ls);
		}

		int data = a.getData();
		if (verificar(n, data)) 
			ls.add(data);
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
		List<Integer> ls = new ArrayList<>();
		GeneralTree<Integer> ab_aux;
		int data;
		Queue<GeneralTree<Integer>> cola = new Queue<>();
		cola.enqueue(a);
		while (!cola.isEmpty()) {
			 ab_aux = cola.dequeue();
			 
			 data = ab_aux.getData();
			 if (verificar(n, data))
				 ls.add(ab_aux.getData());
			 
			 List<GeneralTree<Integer>> children = ab_aux.getChildren();
			 for (GeneralTree<Integer> child: children) {
				 cola.enqueue(child);
			 }
		}
		return ls;
	}
	
	
}
