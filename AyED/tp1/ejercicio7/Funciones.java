package tp1.ejercicio7;

import java.util.*;
public class Funciones {
	public static boolean esCapicua(List<Integer> lista) {
		int i, j = lista.size() - 1;
		boolean aux = true;
		for (i = 0; i <= (lista.size() / 2) + 1; i++) {
			if (lista.get(i) != lista.get(j)) {
				aux = false;
				break;
			}
			j--;
		}
		return aux;	
	}
	private static int Sucecion (int n) {
		if (n == 1) {
			return 1;
		} else {
			if (n % 2 == 0) {
				return (n / 2);
			}
		}
		return 3 * n + 1;
	}
	public static List<Integer> calcularSucesion (int n) {
		List<Integer> ls = new ArrayList<>();
		if (n == 1) {
			ls.add(1);
			return ls;
		}
		ls.add(n);
		ls.addAll(calcularSucesion(Sucecion(n)));
		return ls;
	}
	
	private static void invertirList(ArrayList<Integer> ls, int ini, int fin) {
		if (ini >= fin) {
			return;
		}
		int aux = ls.get(ini);
		ls.set(ini, ls.get(fin));
		ls.set(fin, aux);
		invertirList(ls, ini + 1, fin - 1);
	}
	public static void invertirArrayList (ArrayList<Integer> lista){
		invertirList(lista, 0, lista.size() - 1);
	}
	
	private static int sumaRecursiva (Iterator<Integer> ls) {
		if (!ls.hasNext()) {
			return 0;
		}
		return ls.next() + sumaRecursiva(ls);
	}
	public static int sumarLinkedList (LinkedList<Integer> lista) {
		if (lista.isEmpty()) {
			return 0;
		}
		Iterator<Integer> it_ls = lista.iterator();
		return sumaRecursiva(it_ls);
	}
	
	public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2){
		ArrayList<Integer> ls = new ArrayList<>();
		ls.addAll(lista1);
		ls.addAll(lista2);
		ls.sort(null);
		return ls;
	}
}
