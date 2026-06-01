package tp3.ejercicio9;

import tp3.GeneralTree;

public class ParcialArboles {
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		boolean cumple = false;
		if (arbol != null && !arbol.isEmpty()) {
			cumple = recorrerArbol(arbol);
		}
		return cumple;
	}
	private static boolean recorrerArbol(GeneralTree<Integer> ab) {
		boolean cumple = true;
		Integer min = Integer.MAX_VALUE;
		if (!ab.isLeaf()) {
			for (GeneralTree<Integer> child : ab.getChildren()) {
				min = Integer.min(child.getData(), min);
			}
			cumple = (ab.getData() == min);
			
			if (cumple) {
				for (GeneralTree<Integer> child : ab.getChildren()) {
					cumple = recorrerArbol(child);
				}
			}
		}
		return cumple;
	}
}
