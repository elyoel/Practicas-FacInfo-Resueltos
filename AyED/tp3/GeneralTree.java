package tp3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {
		int altura = 0;
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			aux = cola.dequeue();
			if (aux != null) {
				for (GeneralTree<T> child: aux.getChildren()) {
					cola.enqueue(child);
				}
			} else {
				if (!cola.isEmpty()) {
					altura++;
					cola.enqueue(null);
				}
				
			}
		}
		return altura;
	}
	
	public int nivel(T dato){
		int nivel = 0;
		boolean encontre = false;
		GeneralTree<T> ab_aux = null;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty() && !encontre) {
			 ab_aux = cola.dequeue();
			 if (ab_aux != null) {
				 for (GeneralTree<T> child: ab_aux.getChildren())
					 cola.enqueue(child);
				 encontre = (ab_aux.getData().equals(dato));
			 } else {
				 if (!cola.isEmpty()) {
					 cola.enqueue(null);
					 nivel++;
				 }
			 }
		}

		if (!encontre) nivel = -1;
		return nivel;
	  }

	public int ancho(){
		int cont = 0, max = 1;
		GeneralTree<T> ab_aux;
		Queue<GeneralTree<T>> cola = new Queue<>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			 ab_aux = cola.dequeue();
			 if (ab_aux != null) {
				 for (GeneralTree<T> child: ab_aux.getChildren()) {
					 cola.enqueue(child);
					 cont++;
				 }
			 } else {
				 if (!cola.isEmpty()) {
					 if (cont > max) max = cont;
					 cont = 0;
					 cola.enqueue(null);
				 }
			 }
		}
		return max;
	}
	
	
	private boolean existe(T dato) {
		if (this.isEmpty()) return false;
		
		boolean encontre = this.getData().equals(dato);
				
		Iterator<GeneralTree<T>> it = this.getChildren().iterator();
		while (it.hasNext() && !encontre) {
			encontre = it.next().existe(dato);
		}
		return encontre;
	}
	
	public boolean esAncestro(T a, T b) {
		if (this.isLeaf()) return false;
		
		boolean ok = false;
		if (a.equals(this.getData())) {
			ok = this.existe(b);
		} else {
			Iterator<GeneralTree<T>> it = this.getChildren().iterator();
			while (it.hasNext() && !ok) {
				ok = it.next().esAncestro(a, b);
			}
		}
		return ok;
	}
}