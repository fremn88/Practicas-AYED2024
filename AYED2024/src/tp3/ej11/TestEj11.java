package tp3.ej11;

import java.util.LinkedList;
import java.util.List;

import tp3.ej1.GeneralTree;

public class TestEj11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		//0						1 
		//				/		|	     \
		//1			  0		    1		  1
		//			/   |	   /  \        \
		//2		   1     1    1	   0     	1
		//		   |	  			|	     \
		//3		   1				0         1
		//							|        / \
		//4							0       1   0
		//
		List<GeneralTree<Integer>> hijos3A = new LinkedList<GeneralTree<Integer>>();
		hijos3A.add(new GeneralTree<Integer>(1));
		hijos3A.add(new GeneralTree<Integer>(0));
		GeneralTree<Integer> tree3A = new GeneralTree<Integer>(1,hijos3A);
		
		List<GeneralTree<Integer>> hijos3B = new LinkedList<GeneralTree<Integer>>();
		hijos3B.add(new GeneralTree<Integer>(1));
		GeneralTree<Integer> tree3B = new GeneralTree<Integer>(0,hijos3B);
		
		List<GeneralTree<Integer>> hijos2A = new LinkedList<GeneralTree<Integer>>();
		hijos2A.add(tree3A);
		GeneralTree<Integer> tree2A = new GeneralTree<Integer>(0,hijos2A);
		
		List<GeneralTree<Integer>> hijos2B = new LinkedList<GeneralTree<Integer>>();
		hijos2B.add(tree3B);
		//GeneralTree<Integer> tree2B = new GeneralTree<Integer>(0,hijos2B);
		
		List<GeneralTree<Integer>> hijos2C = new LinkedList<GeneralTree<Integer>>();
		hijos2C.add(new GeneralTree<Integer>(1));
		//GeneralTree<Integer> tree2C = new GeneralTree<Integer>(1,hijos2C);
	
		List<GeneralTree<Integer>> hijos1A = new LinkedList<GeneralTree<Integer>>();
		hijos1A.add(tree2A);
		//GeneralTree<Integer> tree1A = new GeneralTree<Integer>(1,hijos1A);

		List<GeneralTree<Integer>> hijos1B = new LinkedList<GeneralTree<Integer>>();
		hijos1B.add(new GeneralTree<Integer>(1));
		//hijos1B.add(tree2B);
		GeneralTree<Integer> tree1B = new GeneralTree<Integer>(1,hijos1B);
		
		List<GeneralTree<Integer>> hijos1C = new LinkedList<GeneralTree<Integer>>();
		hijos1C.add(new GeneralTree<Integer>(1));
		hijos1C.add(new GeneralTree<Integer>(1));
		GeneralTree<Integer> tree1C = new GeneralTree<Integer>(0,hijos1C);
		
		List<GeneralTree<Integer>> hijos0 = new LinkedList<GeneralTree<Integer>>();
		hijos0.add(tree1C);
		hijos0.add(tree1B);
		//hijos0.add(tree1A);
		GeneralTree<Integer> tree0 = new GeneralTree<Integer>(1,hijos0);
		
		// imprimir arbol
		tree0.imprimirNiveles();
		System.out.println("");
		System.out.println(" --------------------- ");
		// testeo
		System.out.println(ParcialArbol.resolver(tree0));
	}

}
