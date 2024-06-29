package parcial2024GrafosF1;

public class Recinto {
	private int tiempo;
	private String nombre;
	
	public Recinto(int tiempo, String nombre) {
		super();
		this.tiempo = tiempo;
		this.nombre = nombre;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean equals(Object r) {
		return this.nombre == ((Recinto)r).nombre;
	}
	
}
