package tp3.ej6;
import java.util.*;
import tp3.ej1.GeneralTree;

public class RedDeAguaPotable {
	GeneralTree<Character> red;
	
	public RedDeAguaPotable(GeneralTree<Character> arbol) {
		this.red = arbol;
	}
	
	public double minimoCaudal(double caudal) {
		double min = 0;
		if(this.red.isLeaf()) {
			min = caudal;
		} else {
			List<GeneralTree<Character>> hijos = this.red.getChildren();
			int cant = hijos.size();
			double aux = 0;
			for(GeneralTree<Character> i: hijos) {
				RedDeAguaPotable hija = new RedDeAguaPotable(i);
				aux = hija.minimoCaudal(caudal/cant);
				if(aux<min) {
					min = aux;
				}
			}
		}
		return min;
	}
}
