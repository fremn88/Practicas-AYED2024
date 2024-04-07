package tp2.ej3;

import java.util.ArrayList;

import tp2.ej1.BinaryTree;

public class TestEj3 {
	public static void main(String[] args) {
		// Crear arbol binario a testear
		//				 1
		//				/  \
		//			   2    3
		//            / \  / 
		//			 4  5  6
		// -----------------------------
		BinaryTree<Integer> testTree = new BinaryTree<Integer>();
		BinaryTree<Integer> testTreeIzq = new BinaryTree<Integer>();
		BinaryTree<Integer> testTreeDer = new BinaryTree<Integer>();
		testTreeIzq.setData(2);
		testTreeIzq.addLeftChild(new BinaryTree<Integer>(4));
		testTreeIzq.addRightChild(new BinaryTree<Integer>(5));
		testTreeDer.setData(3);
		testTreeDer.addLeftChild(new BinaryTree<Integer>(6));
		testTree.addLeftChild(testTreeIzq);
		testTree.addRightChild(testTreeDer);
		testTree.setData(1);
		//------------------------------
		ArrayList<Integer> test = new ArrayList<Integer>();
		ContadorArbol aux = new ContadorArbol(testTree);
		test = aux.numerosPares();
		for(Integer i: test) {
			System.out.println(i+" ");
		}
		// esperado: 2 4 6
	}
}
