package tp2.ej4;
import tp2.ej1.BinaryTree;

public class TestEj4 {

	public static void main(String[] args) {
		// Crear arbol binario a testear
		//				 1
		//				/  \
		//			   2    3
		//            / \  / \
		//			 4  5  6  7
		// -----------------------------
		BinaryTree<Integer> testTree = new BinaryTree<Integer>();
		BinaryTree<Integer> testTreeIzq = new BinaryTree<Integer>();
		BinaryTree<Integer> testTreeDer = new BinaryTree<Integer>();
		testTreeIzq.setData(2);
		testTreeIzq.addLeftChild(new BinaryTree<Integer>(4));
		testTreeIzq.addRightChild(new BinaryTree<Integer>(5));
		testTreeDer.setData(3);
		testTreeDer.addLeftChild(new BinaryTree<Integer>(6));
		testTreeDer.addRightChild(new BinaryTree<Integer>(7));
		testTree.addLeftChild(testTreeIzq);
		testTree.addRightChild(testTreeDer);
		testTree.setData(1);
		//------------------------------
		RedBinariaLlena test = new RedBinariaLlena(testTree);
		System.out.println(test.retardoReenvio());
		// esperado 11
		
	}

}
