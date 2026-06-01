package tp1.ejercicio3;

public class Profesor {
	private String nombre;
	private String apellido;
	private String catedra;
	private String email;
	private String facultad;
	
	public Profesor() {
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getCatedra() {
		return catedra;
	}
	public String getEmail() {
		return email;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tuDatos() {
		return "Mis datos son: " + this.getNombre() + ", " + 
				this.getApellido() + ", " +
				this.getEmail() + ", " +
				this.getCatedra() + ", " +
				this.getFacultad() + ", ";
	}
	
}
