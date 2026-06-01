package tp1.ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Contador {
	public static List<Integer> multiplos(){
		Scanner teclado = new Scanner(System.in);
		int n = teclado.nextInt();
		List<Integer> aux = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			aux.add(n * i);
		}
		return aux;
	}
}
