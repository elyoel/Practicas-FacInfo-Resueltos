package tp2.ejercicio6;

import tp2.BinaryTree;

public class Transformacion {
	protected BinaryTree<Integer> ab;
	
	
	public void setAb (BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	private int sumaHijos(BinaryTree<Integer> ab) {
		int sum = 0;
		if (ab.hasLeftChild()) {
			sum += ab.getLeftChild().getData();
		}
		if (ab.hasRightChild()) {
			sum += ab.getRightChild().getData();
		}
		return sum;
	}
	private void recorrer(BinaryTree<Integer> ab, BinaryTree<Integer> ab2) {
		ab2.setData(sumaHijos(ab));
		if (ab.hasLeftChild()) {
			ab2.addLeftChild(new BinaryTree<Integer>());
			recorrer(ab.getLeftChild(), ab2.getLeftChild());
		}
		if (ab.hasRightChild()) {
			ab2.addRightChild(new BinaryTree<Integer>());
			recorrer(ab.getRightChild(), ab2.getRightChild());
		}
		ab2.setData(sumaHijos(ab2) + ab2.getData());
	}
	
	public BinaryTree<Integer> suma (){
		BinaryTree<Integer> aux = new BinaryTree<>();
		if (this.ab != null) {
			if (ab.isLeaf()) {
				aux.setData(0);;
			} else {
				recorrer(this.ab, aux);
			}
		}
		return aux;
	}
}