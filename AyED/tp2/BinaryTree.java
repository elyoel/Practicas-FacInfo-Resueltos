 package tp2;

import tp1.ejercicio8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	
	private int contar (BinaryTree<T> ab) {
		int leaf = 0; 
		if (ab.isLeaf()) {
			 return 1;
		 }
		 if (ab.hasLeftChild()) {
			 leaf += contar(ab.getLeftChild());
		 }
		 if (ab.hasRightChild()) {
			 leaf += contar(ab.getRightChild());
		 }
		 return leaf;
		 
	}
	public int contarHojas(BinaryTree<T> ab) {
		if (ab == null) return 0;
		
		if (ab.isLeaf())
			return 1;
		
		return contar(ab);
	}
		
		
    private void recorrerEspejo(BinaryTree<T> ab, BinaryTree<T> ab2) {    	
    	ab2.setData(ab.getData());
    	
    	if (ab.hasLeftChild()) {
    		ab2.addRightChild(new BinaryTree<T>());
    		recorrerEspejo(ab.getLeftChild(), ab2.getRightChild());
    	}
    	if (ab.hasRightChild()) {
    		ab2.addLeftChild(new BinaryTree<T>());
    		recorrerEspejo(ab.getRightChild(), ab2.getLeftChild());
    	}
    }
    public BinaryTree<T> espejo(BinaryTree<T> ab){
    	if (ab == null) return null;
    	
    	BinaryTree<T> ab_aux = new BinaryTree<>();
    	
    	if (ab.isLeaf()) {
			ab_aux.setData(ab.getData());
    		return ab_aux;
    	}
    	
    	recorrerEspejo(ab, ab_aux);
    	return ab_aux;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		BinaryTree<T> ab = null;
	   	 Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
	   	 cola.enqueue(this);
	   	 cola.enqueue(null);
	   	 int nivel = 0;
	   	 while (!cola.isEmpty()) {
	   		 ab = cola.dequeue();
	   		 if (ab != null) {
	   			 if (nivel >= n && nivel <= m) {
	   				 System.out.print("-" + ab.getData() + "-");
	   			 }
	   			 if (ab.hasLeftChild()) {
	   				 cola.enqueue(ab.getLeftChild());
	   			 }
	   			 if (ab.hasRightChild()) {
	   				 cola.enqueue(ab.getRightChild());
	   			 }
	   			 
	   		 } else if (!cola.isEmpty()) {
	   			 nivel++;
	   			 System.out.println();
	   			 cola.enqueue(null);
	   		 }
	   	 }
	}
	public void insertar(T dato) {
		if (this.data == null) {
	        this.data = dato;
	        return;
	    }
		
		Queue<BinaryTree<T>> cola = new Queue<>();
	    cola.enqueue(this);
	    
	    while (!cola.isEmpty()) {
	        BinaryTree<T> actual = cola.dequeue();
	        
	        // Intento insertar a la izquierda
	        if (!actual.hasLeftChild()) {
	            actual.addLeftChild(new BinaryTree<T>(dato));
	            return; // Ya inserté, salgo del método
	        } else {
	            cola.enqueue(actual.getLeftChild());
	        }
	        
	        // Intento insertar a la derecha
	        if (!actual.hasRightChild()) {
	            actual.addRightChild(new BinaryTree<T>(dato));
	            return; // Ya inserté, salgo del método
	        } else {
	            cola.enqueue(actual.getRightChild());
	        }
	    }
	}
	
	public void printLevelTraversal() {
		 BinaryTree<T> ab = null;
		 Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		 cola.enqueue(this);
		 cola.enqueue(null);
		 while (!cola.isEmpty()) {
		 ab = cola.dequeue();
		 if (ab != null) {
		 System.out.print("-" + ab.getData() + "-");
		 if (ab.hasLeftChild()) {
		 cola.enqueue(ab.getLeftChild());
		 }
		 if (ab.hasRightChild()) {
		 cola.enqueue(ab.getRightChild());
		 }
		 } else if (!cola.isEmpty()) {
		 System.out.println();
		 cola.enqueue(null);
		 }
		 }
	}

		
}

