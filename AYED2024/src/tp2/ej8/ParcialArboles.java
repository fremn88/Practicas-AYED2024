package tp2.ej8;
import tp2.ej1.*;
public class ParcialArboles {
	
	public boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		boolean res = false;
		if(a1.getData()==a2.getData()) {
			boolean izq = true, der = true;
			if(a1.hasLeftChild()&&a2.hasLeftChild()) {
				izq = esPrefijo(a1.getLeftChild(),a2.getLeftChild());
				}
			if(a2.hasRightChild()&&a1.hasRightChild()) {
				der = esPrefijo(a1.getRightChild(),a2.getRightChild());
				}
			res = izq&&der;
			}
		
		return res;
		}
}
