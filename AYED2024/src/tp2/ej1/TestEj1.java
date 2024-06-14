package tp2.ej1;
public class TestEj1 {

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
		//testTreeIzq.addRightChild(new BinaryTree<Integer>(5));
		testTreeDer.setData(3);
		testTreeDer.addLeftChild(new BinaryTree<Integer>(6));
		testTree.addLeftChild(testTreeIzq);
		testTree.addRightChild(testTreeDer);
		testTree.setData(1);
		//-------------------------------
		

		System.out.println("Recorrido original Inorder");
		testTree.imptimirInorder();
		System.out.println("Cantidad de hojas: "+testTree.contarHojas());
		System.out.println("Recorrido espejo Inorder");
		//				 1
		//				/  \
		//			   3    2
		//              /  /  \
		//			    6   4  5
		// -----------------------------
		testTree.espejo().imptimirInorder();
		
		
		
		//testTree.entreNiveles(2, 3);
	}

}
