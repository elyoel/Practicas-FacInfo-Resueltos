package tp1.ejercicio3;

public class Estudiante {
	private String nombre;
	private String apellido;
	private int comision;
	private String email;
	private String direcion;
	
	
	public Estudiante() {
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getComision() {
		return comision;
	}
	public String getEmail() {
		return email;
	}
	public String getDirrecion() {
		return direcion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDirecion(String dirrecion) {
		this.direcion = dirrecion;
	}
	
	public String tuDatos() {
		return "Mis datos son: " + this.getNombre() + ", " + 
				this.getApellido() + ", " +
				this.getComision() + ", " +
				this.getEmail() + ", " +
				this.getDirrecion() + ", ";
	}
	
	
	
}
