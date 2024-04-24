package tp3.ej7;

import java.util.LinkedList;
import java.util.List;

import tp3.ej1.GeneralTree;

public class TestEj7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		//						12
		//				/		|		\
		//			  17		9		15
		//			/  |	   /       /   \
		//		  10    6     8		  14	18
		//				|			/   \
		//				1			16   7
		//
		List<GeneralTree<Integer>> hijos14 = new LinkedList<GeneralTree<Integer>>();
		hijos14.add(new GeneralTree<Integer>(16));
		hijos14.add(new GeneralTree<Integer>(7));
		GeneralTree<Integer> tree14 = new GeneralTree<Integer>(14,hijos14);
		
		List<GeneralTree<Integer>> hijos15 = new LinkedList<GeneralTree<Integer>>();
		hijos15.add(tree14);
		hijos15.add(new GeneralTree<Integer>(18));
		GeneralTree<Integer> tree15 = new GeneralTree<Integer>(15,hijos15);
		
		List<GeneralTree<Integer>> hijos9 = new LinkedList<GeneralTree<Integer>>();
		hijos9.add(new GeneralTree<Integer>(8));
		GeneralTree<Integer> tree9 = new GeneralTree<Integer>(9,hijos9);
		
		List<GeneralTree<Integer>> hijos6 = new LinkedList<GeneralTree<Integer>>();
		hijos6.add(new GeneralTree<Integer>(1));
		GeneralTree<Integer> tree6 = new GeneralTree<Integer>(6,hijos6);
		
		List<GeneralTree<Integer>> hijos17 = new LinkedList<GeneralTree<Integer>>();
		hijos17.add(new GeneralTree<Integer>(10));
		hijos17.add(tree6);
		GeneralTree<Integer> tree17 = new GeneralTree<Integer>(17,hijos17);
		
		List<GeneralTree<Integer>> hijos12 = new LinkedList<GeneralTree<Integer>>();
		hijos12.add(tree17);
		hijos12.add(tree9);
		hijos12.add(tree15);
		GeneralTree<Integer> tree12 = new GeneralTree<Integer>(12,hijos12);
		
		// imprimir arbol
		tree12.imprimirNiveles();
		System.out.println("");
		System.out.println(" --------------------- ");
		// testeo
		Caminos test = new Caminos(tree12);
		List<Integer> lista = test.caminoAHojaMasLejana();
		for(Integer i: lista) {
			System.out.println(i+" ");
		}
		
		
		
		
	}

}
