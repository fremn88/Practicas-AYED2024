package tp2.ej3;
import java.util.ArrayList;

import tp2.ej1.*;
public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public BinaryTree<Integer> getArbol(){
		return this.arbol; // no haria falta! metodo nuemerosPAres tiene acceso a variable de instancia privada.
	}
	
	public ArrayList<Integer> numerosPares(){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		BinaryTree<Integer> ar = this.arbol;
		if(ar!=null) {
			if(ar.getData()%2==0) {
				lista.add(ar.getData());
			}
			if(!this.arbol.isLeaf()) {
				if(this.arbol.hasLeftChild()) {
					ContadorArbol auxI = new ContadorArbol(this.arbol.getLeftChild());
					lista.addAll(auxI.numerosPares());
				}
				if(this.arbol.hasRightChild()) {
					ContadorArbol auxD = new ContadorArbol(this.arbol.getRightChild());
					lista.addAll(auxD.numerosPares());
				}
			}
		}
		return lista;
	}
	
}
