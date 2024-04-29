package tp3.ej9;

import java.util.LinkedList;
import java.util.List;

import tp3.ej1.GeneralTree;

public class TestTp3Ej9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		//						12B
		//				/		|		\
		//			  12A		24		15B
		//			/  |	   /       /   \
		//		  12    14     24	  15A	18
		//				|			/   \
		//				14			15   30
		//
		List<GeneralTree<Integer>> hijos15A = new LinkedList<GeneralTree<Integer>>();
		hijos15A.add(new GeneralTree<Integer>(15));
		hijos15A.add(new GeneralTree<Integer>(30));
		GeneralTree<Integer> tree15A = new GeneralTree<Integer>(15,hijos15A);
		
		List<GeneralTree<Integer>> hijos15B = new LinkedList<GeneralTree<Integer>>();
		hijos15B.add(tree15A);
		hijos15B.add(new GeneralTree<Integer>(18));
		GeneralTree<Integer> tree15B = new GeneralTree<Integer>(15,hijos15B);
		
		List<GeneralTree<Integer>> hijos24 = new LinkedList<GeneralTree<Integer>>();
		hijos24.add(new GeneralTree<Integer>(24));
		GeneralTree<Integer> tree24 = new GeneralTree<Integer>(24,hijos24);
		
		List<GeneralTree<Integer>> hijos14A = new LinkedList<GeneralTree<Integer>>();
		hijos14A.add(new GeneralTree<Integer>(14));
		GeneralTree<Integer> tree14A = new GeneralTree<Integer>(14,hijos14A);
		
		List<GeneralTree<Integer>> hijos12A = new LinkedList<GeneralTree<Integer>>();
		hijos12A.add(new GeneralTree<Integer>(12));
		hijos12A.add(tree14A);
		GeneralTree<Integer> tree12A = new GeneralTree<Integer>(12,hijos12A);
		
		List<GeneralTree<Integer>> hijos12B = new LinkedList<GeneralTree<Integer>>();
		hijos12B.add(tree12A);
		hijos12B.add(tree24);
		hijos12B.add(tree15B);
		GeneralTree<Integer> tree12 = new GeneralTree<Integer>(12,hijos12B);
		
		// imprimir arbol
		tree12.imprimirNiveles();
		System.out.println("");
		System.out.println(" --------------------- ");
		// testeo
		System.out.println(ParcialArbol.esDeSeleccion(tree12));
	}

}
