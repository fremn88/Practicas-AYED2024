package tp3.ej3;

import java.util.ArrayList;
import java.util.List;

import tp3.ej1.GeneralTree;

public class TestEj3 {

	public static void main(String[] args) {
		// crear arbol testeo 
		// 				1
		//			/	|	\
		//			7   3    4
		//		   / \
		//         5  9
		
		List<GeneralTree<Integer>> hijos2 = new ArrayList<GeneralTree<Integer>>();
		hijos2.add(new GeneralTree<Integer>(5));
		hijos2.add(new GeneralTree<Integer>(9));
		GeneralTree<Integer> ar2 = new GeneralTree<Integer>(7,hijos2);
		List<GeneralTree<Integer>> hijos1 = new ArrayList<GeneralTree<Integer>>();
		hijos1.add(ar2);
		hijos1.add(new GeneralTree<Integer>(3));
		hijos1.add(new GeneralTree<Integer>(4));
		GeneralTree<Integer> testTree = new GeneralTree<Integer>(1,hijos1);

		//System.out.print(testTree.altura());
		// Esperado: 1 7 3 5 9
		// 
		//System.out.println(testTree.nivel(10));
		System.out.print(testTree.ancho());
	}

}
