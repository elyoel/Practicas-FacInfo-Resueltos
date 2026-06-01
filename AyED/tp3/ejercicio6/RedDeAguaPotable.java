package tp3.ejercicio6;

import tp3.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> ab;
	
	public double minimoCaudal(double caudal) {
		double lt = 0;
		if (ab != null) {
			lt = recorrido(ab, caudal);
		}
		return lt;
	}
	private double recorrido(GeneralTree<Character> ab, double caudal) {
		if (ab.isLeaf()) return caudal;
		double min = caudal;
		double lt = caudal / ab.getChildren().size();
		for (GeneralTree<Character> child : ab.getChildren()) {
			double act = recorrido(child, lt);
			if (act < min) min = act;
		}
		return min;
	}
}
