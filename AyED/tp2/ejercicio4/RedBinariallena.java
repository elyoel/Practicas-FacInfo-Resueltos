package tp2.ejercicio4;

import tp2.BinaryTree;

public class RedBinariallena {
	    // Función principal de suma
	    public static int sumaCaminoMaximo(BinaryTree<Integer> ab) {
	    	if (ab == null) return 0;
	    	if (ab.isLeaf()) {
	            return ab.getData();
	        }

	        int sumaIzq = 0, sumaDer = 0;
	        
	        if (ab.hasLeftChild())
	        	sumaIzq = sumaCaminoMaximo(ab.getLeftChild());
	        if (ab.hasRightChild())
	        	sumaDer = sumaCaminoMaximo(ab.getRightChild());

	        return ab.getData() + Math.max(sumaIzq, sumaDer);
	    }
}
