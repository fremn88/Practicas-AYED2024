package tp2.ej7;
import tp2.ej1.*;
public class ParcialArboles {
	BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> getArbol(){
		return this.arbol;
	}
	
	public boolean isLeftTree(int num){
		   return isLeft(this.arbol, num);
		}


	private boolean isLeft(BinaryTree<Integer> ar, int num){
		boolean res = false;
		if(ar.getData() == num) { 
		    int izq = -1;
		    int der = -1;
		    if(ar.hasLeftChild()) {
		    	izq = cantHijoUnico(ar.getLeftChild()); //1
		    }
		    if(ar.hasRightChild()) {
		    	der = cantHijoUnico(ar.getRightChild());
		    }
		    if(izq>der){
		      res = true;
		    }
		}
		else {
		    if(ar.hasLeftChild()) {
		      res = isLeft(ar.getLeftChild(), num);
		    }
		    if(!res) {
		    	if(ar.hasRightChild()) {
		    		res = isLeft(ar.getRightChild(), num);
		    	}
		    }  
		}   
		return res;
	}	    

		private int cantHijoUnico(BinaryTree<Integer> ar) {
			int res = 0;
			if(ar.hasLeftChild()&&!ar.hasRightChild()) {
				res = 1 + cantHijoUnico(ar.getLeftChild());
			} else if(!ar.hasLeftChild()&&ar.hasRightChild()) {
				res = 1 + cantHijoUnico(ar.getRightChild());
			} else if(ar.hasLeftChild()&&ar.hasRightChild()) {
				res = cantHijoUnico(ar.getRightChild())+ cantHijoUnico(ar.getLeftChild());
			}
			return res;
		}
		  
}
