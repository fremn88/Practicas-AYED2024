package tp1.ej3;

public class Estudiante {
	private String nombre;
	private String apellido;
	/*
	public Estudiante(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}
	*/
	public void setNombre(String s) {
		nombre = s;
	}

	public void setApellido(String s) {
		apellido = s;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String tusDatos() {
		return "Nombre y apellido: " + this.getNombre() + " " + this.getApellido();
	}
	//para el 7d, sobreescribo "equals" de modo de comparar nombre y apellido
	//el metodo toma un estudiante de input, y lo compara con las propiedades de la instancia que ejecuta el metodo haciendo uso de
	//la palabra reservada "this"
	public boolean equals(Estudiante e) {
		return (e.getApellido()==this.getApellido() && e.getNombre()==this.nombre);
	}
}
