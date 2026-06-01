package tp5.ejercicio5;

public class Persona {
	private String nombre;
	private String domicilio;
	private String estado;
	
	public Persona(String nombre, String domicilio, String estado) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.estado = estado;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEstado() {
		return estado;
	}

}