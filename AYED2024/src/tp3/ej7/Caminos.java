package tp3.ej7;

import java.util.LinkedList;
import java.util.List;

import tp3.ej1.GeneralTree;

public class Caminos {
	GeneralTree<Integer> arbol;
	
	public Caminos() {
		
	}
	
	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> res = new LinkedList<Integer>();
		res.addAll(this.camino(arbol));
		return res;
	}
	
	private List<Integer> camino(GeneralTree<Integer> ar){
		List<Integer> res = new LinkedList<Integer>();
		if(ar!=null) {
			if(ar.getData()!=null) {
				res.add(ar.getData());
			}
			if(ar.hasChildren()) {
				int tamanio = 0;
				List<Integer> larga = new LinkedList<Integer>();
				List<Integer> auxList = new LinkedList<Integer>();
				List<GeneralTree<Integer>> hijos = ar.getChildren(); 
				for(GeneralTree<Integer> i: hijos) {
					Caminos aux = new Caminos(i);
					auxList = aux.caminoAHojaMasLejana();
					if(auxList.size()>tamanio) {
						tamanio = auxList.size();
						larga = auxList;
					}
				}
				res.addAll(larga);
			}
		}
		return res;
	}
	
}
