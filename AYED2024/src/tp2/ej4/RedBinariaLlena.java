package tp2.ej4;

import tp2.ej1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> a) {
		this.arbol = a;
	}
	
	public BinaryTree<Integer> getArbol(){
		return this.arbol;
	} // no haria falta! metodo retardo puede usar variables privadas de clase redbinariallena
	
	public int retardoReenvio() {
		int sum = 0;
		if(this.arbol!=null) {
			sum = this.arbol.getData();
			if(!this.arbol.isLeaf()) {
				if(this.arbol.hasLeftChild()&&this.arbol.hasRightChild()) {
					RedBinariaLlena auxIzq = new RedBinariaLlena(this.arbol.getLeftChild());
					RedBinariaLlena auxDer = new RedBinariaLlena(this.arbol.getRightChild());
					int izq = auxIzq.retardoReenvio();
					int der = auxDer.retardoReenvio();
					if(izq>=der) {
						sum+=izq;
					} else {
						sum+=der;
					}
				} else if(this.arbol.hasLeftChild()) {
					RedBinariaLlena auxIzq = new RedBinariaLlena(this.arbol.getLeftChild());
					sum+=auxIzq.retardoReenvio();
				} else {
					RedBinariaLlena auxDer = new RedBinariaLlena(this.arbol.getRightChild());
					sum+=auxDer.retardoReenvio();
				}
			}
		}
		return sum;
	}
}
