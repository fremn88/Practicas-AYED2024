package tp3.ej9;

import java.util.List;

import tp3.ej1.GeneralTree;

public class ParcialArbol {
	// asumo que el valor de raiz esta en la lista???
	public static boolean esDeSeleccion(GeneralTree<Integer> ar) {
		boolean es = true;
		if(ar!=null) {
			if(ar.hasChildren()) {
				List<GeneralTree<Integer>> hijos = ar.getChildren();
				Integer datoPadre = ar.getData();
				int i = 0;
				while(i<hijos.size()&&es) {
					GeneralTree<Integer> aux = hijos.get(i);
					if(aux.isLeaf()&&datoPadre>aux.getData()) {
						es = false;
					} else if(!aux.isLeaf()) {
						es = esDeSeleccion(aux);
					}
					i++;
				}
			} 	 
		}
		return es;
	}
}

