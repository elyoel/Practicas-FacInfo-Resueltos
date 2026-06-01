package tp2.ejercicio6;

import tp2.BinaryTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> ab = new BinaryTree<>(), ab2;
		
		ab.insertar(1);
		ab.insertar(2);
		ab.insertar(3);
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		ab.getRightChild().insertar(5);
		ab.getRightChild().insertar(6);
		ab.getRightChild().insertar(7);
		ab.getRightChild().insertar(8);
		
		
		ab.printLevelTraversal();
		
		Transformacion t = new Transformacion();
		t.setAb(ab);
		ab2 = t.suma();
		
		System.out.println();
		System.out.println();
		
		ab2.printLevelTraversal();
		
		
	}

}
