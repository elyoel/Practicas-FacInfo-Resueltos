/*
1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.
NOTA: Calcular el área con la fórmula Área = √s(s − a)(s − b)(s − c) , donde a, b y c son
los lados y s =
𝐚+𝐛+𝐜
2
. La función raíz cuadrada es Math.sqrt(#)

 */

package tema3;
import PaqueteLectura.Lector;
/*
 * @author Yoel
 */
public class Actividad_1 {

    public static void main(String[] args) {
        /* Proceda a codear */
        Triangulo tri = new Triangulo();
        tri.setLadoA(Lector.leerDouble());
        tri.setLadoB(Lector.leerDouble());
        tri.setLadoC(Lector.leerDouble());
        tri.setColorLinea(Lector.leerString());
        tri.setColorRelleno(Lector.leerString());

        System.out.println(tri.calcularArea());
        System.out.println(tri.calcularPerimetro());
        
    }

}