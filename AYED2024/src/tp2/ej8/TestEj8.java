package tp2.ej8;

import tp2.ej1.BinaryTree;

public class TestEj8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Crear arbol binario a testear a1:
		//				     2
		//				/        \
		//			   7          -5
		//           /   \       /
		//			23    6      19
		//		   /     /  \     \
		//		  -3    55  11     4
		//                         /
		//                        18
		// -----------------------------
		BinaryTree<Integer> testTree7 = new BinaryTree<Integer>();
		BinaryTree<Integer> testTree23 = new BinaryTree<Integer>();
		BinaryTree<Integer> testTree6 = new BinaryTree<Integer>();
		BinaryTree<Integer> testTree4 = new BinaryTree<Integer>();
		BinaryTree<Integer> testTree19 = new BinaryTree<Integer>();
		BinaryTree<Integer> testTree3 = new BinaryTree<Integer>();
		BinaryTree<Integer> testTree2 = new BinaryTree<Integer>();
		testTree23.setData(23);
		testTree23.addLeftChild(new BinaryTree<Integer>(-3));
		testTree6.setData(6);
		testTree6.addLeftChild(new BinaryTree<Integer>(55));
		testTree6.addRightChild(new BinaryTree<Integer>(11));
		testTree7.addLeftChild(testTree23);
		testTree7.addRightChild(testTree6);
		testTree7.setData(7);
		testTree2.setData(2);
		testTree2.addLeftChild(testTree7);
		testTree4.setData(4);
		testTree4.addLeftChild(new BinaryTree<Integer>(18));
		testTree19.setData(19);
		testTree19.addRightChild(testTree4);
		testTree3.setData(-5);
		testTree3.addLeftChild(testTree19);
		testTree2.addRightChild(testTree3);
		// Crear arbol binario a testear a1:
		//				     2
		//				/        \
		//			   7          -5
		//              \       /
		//			    6      19
		// -----------------------------
		BinaryTree<Integer> A1testTree7 = new BinaryTree<Integer>();
		BinaryTree<Integer> A1testTree_5 = new BinaryTree<Integer>();
		BinaryTree<Integer> A1testTree2 = new BinaryTree<Integer>();
		A1testTree7.setData(7);
		A1testTree7.addRightChild(new BinaryTree<Integer>(7));
		A1testTree2.setData(2);
		A1testTree2.addLeftChild(A1testTree7);
		A1testTree_5.setData(-5);
		A1testTree_5.addLeftChild(new BinaryTree<Integer>(19));
		A1testTree2.addRightChild(A1testTree_5);
		testTree2.imprimirNiveles();
		System.out.println("");
		A1testTree2.imprimirNiveles();
		ParcialArboles a = new ParcialArboles();
		System.out.println("");
		System.out.println(a.esPrefijo(A1testTree2,testTree2));
		
		
	}

}
