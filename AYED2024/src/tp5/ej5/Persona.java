package tp5.ej5;

public class Persona {
	private boolean esEmpleado;
	private String nombre;
	private String domicilio;
	private boolean cobro;

	public Persona(boolean esEmpleado, String nombre, String domicilio, boolean cobro) {
		this.esEmpleado = esEmpleado;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.cobro = cobro;
	}
	public boolean getEsEmpleado() {
		return esEmpleado;
	}
	public void setEsEmpleado(boolean estado) {
		this.esEmpleado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public boolean equals(Object p) {
		return this.nombre == ((Persona)p).nombre;
	}
	public boolean getCobro() {
		return cobro;
	}
	public void setCobro(boolean cobro) {
		this.cobro = cobro;
	}
	public String toString() {
		return this.nombre;
	}
}
