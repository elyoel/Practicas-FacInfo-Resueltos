package tp2.ejercicio3;

import java.util.*;
import tp2.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> ab;
	
	public ContadorArbol (BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	private static void recorridoInOrden (List<Integer> ls, BinaryTree<Integer> ab) {
		ls.addAll(new ArrayList<Integer>(ab.getData()));
		
		if (ab.hasLeftChild()) {
			recorridoInOrden(ls, ab);
		}
		if (ab.hasRightChild()) {
			recorridoInOrden(ls, ab);
		}
	}
	
	public List<Integer> numerosPares_1 (){
		List<Integer> ls = new ArrayList<>();
		if (this.ab == null) {
			return ls;
		}
		recorridoInOrden(ls, this.ab);
		return ls;
	}
	
	
}
