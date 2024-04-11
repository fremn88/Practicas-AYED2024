package tp2.ej6;

import tp2.ej1.BinaryTree;

public class TestEj6 {

	public static void main(String[] args) {
		// Crear arbol binario a testear
		//				 1
		//				/  \
		//			   2    3
		//            / \  
		//			 4  5  
		// -----------------------------
		BinaryTree<Integer> testTree = new BinaryTree<Integer>();
		BinaryTree<Integer> testTreeIzq = new BinaryTree<Integer>();
		BinaryTree<Integer> testTreeDer = new BinaryTree<Integer>();
		testTreeIzq.setData(2);
		testTreeIzq.addLeftChild(new BinaryTree<Integer>(4));
		testTreeIzq.addRightChild(new BinaryTree<Integer>(5));
		testTreeDer.setData(3);
		testTree.addLeftChild(testTreeIzq);
		testTree.addRightChild(testTreeDer);
		testTree.setData(1);
		//------------------------------
		Transformacion test = new Transformacion(testTree);
		BinaryTree<Integer> result;
		//result.imptimirInorder();
		System.out.println("-----------------");
		test.suma();
		result = test.getArbol();
		result.imptimirInorder();
		//------------------------------
		// Esperado
		//				 14
		//				/  \
		//			   9    0
		//            / \  
		//			 0  0  
		// 0-9-0-14-0
		// -----------------------------
	}

}
