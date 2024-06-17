package tp3.ej10;

import java.util.List;

public class PesoLista {
	int peso;
	List<Integer> lis;
	
	public PesoLista(int peso, List<Integer> lis) {
		this.peso=peso;
		this.lis=lis;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public List<Integer> getLista(){
		return this.lis;
	}
}
