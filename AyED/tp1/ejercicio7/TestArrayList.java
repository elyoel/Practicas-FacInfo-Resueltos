package tp1.ejercicio7;

import java.util.*;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> ls = new ArrayList<>();
		LinkedList<Integer> ls2 = new LinkedList<>();
		for (int i = 0; i < args.length; i++) {
			int n = Integer.decode(args[i]);
			ls.add(n);
			ls2.add(n);
		}
		System.out.println(ls);
		System.out.println(Funciones.esCapicua(ls));
		
		
		ArrayList<Integer> sucecion = (ArrayList<Integer>) Funciones.calcularSucesion(6);	
		
		System.out.println(sucecion);
		
		
		Funciones.invertirArrayList(sucecion);
		System.out.println(sucecion);
		
		System.out.println(Funciones.sumarLinkedList(ls2));
	}
	
}
