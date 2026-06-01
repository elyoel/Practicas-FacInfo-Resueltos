package tp2.ejercicio2;

import tp1.ejercicio8.Queue;
import tp2.BinaryTree;

public class TestBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> ab = new BinaryTree<>();
		ab.setData(20);
		ab.addLeftChild(new BinaryTree<Integer>());
		ab.addRightChild(new BinaryTree<Integer>());
		ab.getLeftChild().setData(440);
		ab.getRightChild().setData(49);
		
		System.out.println(ab.getData());
		System.out.println(ab.getLeftChild().getData());
		System.out.println(ab.getRightChild().getData());
		
		System.out.println(ab.contarHojas(ab));
		
		BinaryTree<Integer> ab2 = ab.espejo(ab);
		
		System.out.println(ab2.getData());
		System.out.println(ab2.getLeftChild().getData());
		System.out.println(ab2.getRightChild().getData());
		
		Queue<Integer> cola = new Queue<>();
		
		cola.enqueue(10);
		cola.enqueue(33);
		cola.enqueue(21);
		cola.enqueue(06);
		cola.dequeue();
		System.out.println(cola.toString());
		
		System.out.println();
		
		BinaryTree<Integer> aux = new BinaryTree<Integer>();
		aux.insertar(1);
		aux.insertar(2);
		aux.insertar(3);
		aux.insertar(4);
		aux.insertar(5);
		aux.insertar(6);
		aux.insertar(7);
		aux.insertar(8);
		
		System.out.println();
		aux.entreNiveles(0,3);
	}

}
