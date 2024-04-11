package tp2.ej5;

import tp1.ej8.Queue;
import tp2.ej1.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	// implementacion en gral ??
	public ProfundidadDeArbolBinario(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	// ??? debe respetar la firma 
	public int sumaElementosProfundidad(int p) {
		int result = 0;
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		BinaryTree<Integer> ar = this.arbol;
		if(ar!=null) {
			cola.enqueue(ar); 
			cola.enqueue(null);
			int nivel = 1;
			while(!cola.isEmpty()&&nivel<p) {
				BinaryTree<Integer> aux = cola.dequeue();
				if(aux!=null) {
					if(aux.hasLeftChild()) {
						cola.enqueue(aux.getLeftChild());
					}
					if(aux.hasRightChild()) {
						cola.enqueue(aux.getRightChild());
					}
				} else {
					if(!cola.isEmpty()) {
						cola.enqueue(null);
					}
					nivel++;
				}
			}
			if(nivel==p) {
				while(!cola.isEmpty()) {
					BinaryTree<Integer> aux = cola.dequeue();
					// Debo chequear si el dato del arbol desencolado no es nul ?? (no valdria isEmpty xq podria tener hijos y un dato null..)
					if(aux!=null&&aux.getData()!=null) {
						result+=aux.getData();
					}
				}
			} 
		}
		return result;
	}
}
