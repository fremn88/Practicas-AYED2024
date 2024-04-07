package tp2.ej5;

import tp2.ej1.BinaryTree;

public class TestEj5 {

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
		ProfundidadDeArbolBinario test = new ProfundidadDeArbolBinario(testTree);
		System.out.println(test.sumaElementosProfundidad(3));
	}

}
