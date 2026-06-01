package tp2.ejercicio4;

import java.util.Scanner;

import tp2.BinaryTree;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> ab = new BinaryTree<>();
		Scanner teclado = new Scanner(System.in);
		int n = teclado.nextInt();
		while (n != 1){
			ab.insertar(n);
			n = teclado.nextInt();
		}
		
		ab.printLevelTraversal();
		
		System.out.print(RedBinariallena.sumaCaminoMaximo(ab));
		
	}

}
