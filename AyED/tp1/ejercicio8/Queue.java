package tp1.ejercicio8;

import java.util.LinkedList;

public class Queue <T>{
	LinkedList<T> data;
	
	public Queue () {
		super();
		data = new LinkedList<T>();
	}
	
	public void enqueue (T data) {
		this.data.add(data);
	}
	
	public T dequeue () {
		return this.data.removeFirst();
	}
	
	public T head () {
		return this.data.getFirst();
	}
	
	public boolean isEmpty () {
		return this.data.isEmpty();
	}
	
	public int size () {
		return this.data.size();
	}
	
	public String toString () {
		String aux = "";
		for (T dat: this.data) {
			aux += dat + " ";
		}
		return aux;
	}
}
