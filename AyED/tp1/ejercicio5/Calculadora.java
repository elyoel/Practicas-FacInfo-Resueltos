package tp1.ejercicio5;

import java.util.List;

public class Calculadora {
	public static Numero ObtenerMinMaxAvg (List<Integer> ls) {
		Numero num = new Numero();
		int total = 0;
		int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
		for (int n: ls){
			if (n > max){
				max = n;
			}
			if (n < min) {
				min = n;
			}
			total += n;
		}
		total /= ls.size();
		num.setMaximo(max);
		num.setMinimo(min);
		num.setPromedio(total);
		return num;
	}
	
	public static void ObteneMinMaxAvg (List<Integer> ls, Numero num) {
		Numero resultado = ObtenerMinMaxAvg(ls);
		num.setMaximo(resultado.getMaximo());
		num.setMinimo(resultado.getMinimo());
		num.setPromedio(resultado.getPromedio());
	}
	public static void ImprimirMinMaxAvg (List<Integer> ls) {
		Numero num = ObtenerMinMaxAvg(ls);
		System.out.println(num.getMaximo());
		System.out.println(num.getMinimo());
		System.out.println(num.getPromedio());
	}
	
}
