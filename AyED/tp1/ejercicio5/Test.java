package tp1.ejercicio5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numeros = new LinkedList<>();
		for (int i = 1; i <= 10; i++) {
			numeros.add(10 * i);
		}
		
		Numero resultado = Calculadora.ObtenerMinMaxAvg(numeros);
		System.out.println("Metodo con return: ");
		System.out.println(resultado.getMaximo());
		System.out.println(resultado.getMinimo());
		System.out.println(resultado.getPromedio());
		
		Numero resultado2 = new Numero();
		Calculadora.ObteneMinMaxAvg(numeros, resultado2);
		System.out.println("Metodo con Parametro: ");
		System.out.println(resultado2.getMaximo());
		System.out.println(resultado2.getMinimo());
		System.out.println(resultado2.getPromedio());
		
		System.out.println("Metodo sin return ni parametros: ");
		Calculadora.ImprimirMinMaxAvg(numeros);
	}

}
