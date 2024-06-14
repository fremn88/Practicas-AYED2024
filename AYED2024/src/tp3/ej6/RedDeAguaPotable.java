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
		if(this.red!=null) {
			min = minimoCaudal(this.red,caudal);
		}
		return min;
	}
	
	private double minimoCaudal(GeneralTree<Character> ar, double caudal) {
		double min = 0;
		if(ar!=null) {
			if(ar.isLeaf()) {
				min = caudal;
			} else {
				List<GeneralTree<Character>> hijos = ar.getChildren();
				int cant = hijos.size();
				double aux = 0;
				for(GeneralTree<Character> i: hijos) {
					aux = minimoCaudal(i,caudal/cant);
					if(aux<min) {
						min = aux;
					}
				}
			}		
		}
		return min;
	}
}
