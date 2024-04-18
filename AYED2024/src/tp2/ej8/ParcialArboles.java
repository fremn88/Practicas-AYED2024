package tp2.ej8;
import tp2.ej1.*;
public class ParcialArboles {
	
	public boolean esPrefijo(BinaryTree<Integer> a1, BinaryTree<Integer> a2) {
		if(a1.hasLeftChild()&&a1.hasRightChild()) {
			if(a2.hasLeftChild()&&a2.hasRightChild()) {
				return esPrefijo(a1.getLeftChild(),a2.getLeftChild())&&esPrefijo(a1.getRightChild(),a2.getRightChild());
			}
			else {
				return false;
			}
		}
		else if(a1.hasLeftChild()&&!a1.hasRightChild()) {
			if(a2.hasLeftChild()) {
				return esPrefijo(a1.getLeftChild(),a2.getLeftChild());
			}
			else {
				return false;
			}
		}
		else if(!a1.hasLeftChild()&&a1.hasRightChild()) {
			if(a2.hasRightChild()) {
				return esPrefijo(a1.getRightChild(),a2.getRightChild());
			}
			else {
				return false;
			}
		}
		else {
			if(a1.getData() == a2.getData()) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
}
