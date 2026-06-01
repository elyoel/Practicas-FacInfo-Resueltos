package tp1.ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Estudiante> estudiantes = new ArrayList<>();
		Estudiante e = new Estudiante();
		e.setNombre("Pepe");
		e.setApellido("Jerez");
		e.setComision(1);
		e.setDirecion("Avenida siempre viva 123");
		e.setEmail("pepe@gmail.com");
		
		estudiantes.add(e);
		
		e = new Estudiante();
		
		e.setNombre("Juan");
		e.setApellido("Carlos");
		e.setComision(1);
		e.setDirecion("Avenida siempre viva 321");
		e.setEmail("juan@gmail.com");
		
		estudiantes.add(e);

		System.out.println(estudiantes.getFirst().tuDatos());
		System.out.println(estudiantes.getLast().tuDatos());
		
	}

}
