package tp3.ej11;

import java.util.List;

import tp1.ej8.Queue;
import tp3.ej1.GeneralTree;

public class ParcialArbol {
	public static boolean resolver(GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		int nodosAntes = 1;
		int nodosDesp = 0;
		boolean creciente = true;
		while(!cola.isEmpty()&&creciente) {
			GeneralTree<Integer> aux = cola.dequeue();
			if(aux!=null) {
				if(aux.hasChildren()) {
					List<GeneralTree<Integer>> hijos = aux.getChildren();
					for(GeneralTree<Integer> hijo: hijos) {
						cola.enqueue(hijo);
						nodosDesp++;
					}
				}
			} else if(!cola.isEmpty()) {
				cola.enqueue(null);
				creciente = (nodosDesp == nodosAntes + 1);
				nodosAntes = nodosDesp;
				nodosDesp = 0;
			}
		}
		return creciente;
	}
}
