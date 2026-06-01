package tp3.ejercicio7;

import java.util.ArrayList;
import java.util.List;

import tp3.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> ab;
	
	public List<Integer> caminoAHojaMasLejana (){
		List<Integer> camino = new ArrayList<>();
		if (ab != null && ab.isEmpty()) {
			buscarCamino(camino, new ArrayList<Integer>(), this.ab);
		}
		return camino;
	}
	private void buscarCamino(List<Integer> camino, List<Integer> caminoAct, GeneralTree<Integer> ab) {
		caminoAct.add(ab.getData());
		
		if (ab.isLeaf()) {
			if (caminoAct.size() > camino.size()) {
				camino.clear();
				camino.addAll(caminoAct);
			}
		} else {
			for (GeneralTree<Integer> child : ab.getChildren()) {
				buscarCamino(camino, caminoAct, child);
				
			}
		}
		caminoAct.removeLast();
	}
	
	
	
}
