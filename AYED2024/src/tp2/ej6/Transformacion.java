package tp2.ej6;
import tp2.ej1.*;
public class Transformacion {
	BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> getArbol(){
		return this.arbol;
	}
	
	public BinaryTree<Integer> suma() {
		if(this.getArbol()!=null) {
			tot(this.getArbol());
		}
		return this.arbol;
	}
	
	private int tot(BinaryTree<Integer> ar) {
		int tot = 0;
		if(ar.isLeaf()) {
			tot = ar.getData();
			ar.setData(0);
			return tot;
		} else {
			if(ar.hasLeftChild()) {
				tot += tot(ar.getLeftChild());
			}
			if(ar.hasRightChild()) {}
				tot += tot(ar.getRightChild());
		}
		int aux = ar.getData();
		ar.setData(tot);
		return tot+aux;
	}
	

}
