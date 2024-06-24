package tp5.ej3;

import java.util.List;

public class Trayectos<T> {
	private List<T> lista;
	private int peso;
	
	public Trayectos(List<T> lista, int peso) {
		this.lista = lista;
		this.peso = peso;
	}

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
