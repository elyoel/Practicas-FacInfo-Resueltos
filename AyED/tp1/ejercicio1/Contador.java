package tp1.ejercicio1;

public class Contador {

		public static void metodoConFor(int a, int b) {
			System.out.println("Metodo con for, numeros entre: " + a + " : " + b);
			for (int i = a; i <= b; i++) {
				System.out.println(i);
			}
		}
		
		public static void metodoConWhile(int a, int b) {
			System.out.println("Metodo con while, numeros entre: " + a + " : " + b);
			while (a <= b) {
				System.out.println(a);
				a++;
			}
		}
		
		public static void metodoConRecursion(int a, int b) {
			if (a == b) {
				System.out.println(a);
			} else {
				System.out.println(a);
				metodoConRecursion(a + 1, b);
			}
		}
}
