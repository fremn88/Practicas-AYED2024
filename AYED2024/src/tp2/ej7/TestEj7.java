package tp2.ej7;

import tp2.ej1.BinaryTree;

public class TestEj7 {

	public static void main(String[] args) {
		// Crear arbol binario a testear
		//				     2
		//				/        \
		//			   7          3
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
		ParcialArboles test = new ParcialArboles(testTree2);
		System.out.println("--------------");
		test.getArbol().imprimirNiveles();
		System.out.println("");
		System.out.println("--------------");
		System.out.println("num = 7 "+test.isLeftTree(7));
		System.out.println("num = 2 "+test.isLeftTree(2));
		System.out.println("num = -5 "+test.isLeftTree(-5));
		System.out.println("num = 19 "+test.isLeftTree(19));
		System.out.println("num = -3 "+test.isLeftTree(-3));
	}

}
