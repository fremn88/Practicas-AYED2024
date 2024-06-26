package tp3.ej10;

import java.util.LinkedList;
import java.util.List;

import tp3.ej1.GeneralTree;

public class ParcialArbol {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> lis = new LinkedList<Integer>();
		if(arbol!=null) {
			
		}
		return lis;
	}
	
	private PesoLista resolver(GeneralTree<Integer> ar, int nivel) {
		List<Integer> lis = new LinkedList<Integer>();
		if(ar.isLeaf()) {
			int peso = 0;
			if(ar.getData()==1) {
				lis.add(1);
				peso = nivel;
			}
			return new PesoLista(peso,lis);
		} else {
			int pesoMax = 0;
			PesoLista actual;
			List<GeneralTree<Integer>> hijos = ar.getChildren();
			for(GeneralTree<Integer> hijo: hijos) {
				actual = resolver(hijo,nivel+1);
				if(actual.getPeso()>pesoMax) {
					pesoMax = actual.getPeso();
					lis = actual.getLista();
				}
			}
			lis.add(1);
			return new PesoLista(pesoMax+nivel,lis);
		}
	}
	
	/*
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> lista = resolver(arbol,0);
		int i = 0;
		while(i<lista.size()) {
			lista.set(i, 1);
			i++;
		}
		return lista;
	}

	private static List<Integer> resolver(GeneralTree<Integer> arbol, Integer nivel){
		List<Integer> lista = new LinkedList<Integer>();
		if(arbol!=null) {
			if(arbol.isLeaf()) {
				if(arbol.getData()==1) {
					if(nivel == 0) {
						lista.add(arbol.getData());
					} else {
						lista.add(arbol.getData()*nivel);
					}
				}
			} else {
				List<Integer> larga = new LinkedList<Integer>();
				List<GeneralTree<Integer>> hijos = arbol.getChildren();
				for(GeneralTree<Integer> i: hijos) {
					List<Integer> listaHijo = resolver(i,nivel+1);
					if(suma(larga)<suma(listaHijo)) {
						larga = listaHijo;
					}
				}
				lista.addAll(larga);
			}
		}
		return lista;
	}
	
	private static Integer suma(List<Integer> lista) {
		Integer suma = 0;
		for(Integer i: lista) {
			suma += i;
		}
		return suma;
	}
	
	/*
	private static Integer valorMax(GeneralTree<Integer> arbol, Integer nivel){
		int valor = 0;
		if(arbol!=null) {
			valor = arbol.getData()*nivel;
			if(arbol.hasChildren()) {
				Integer valorAnterior = 0;
				List<GeneralTree<Integer>> hijos = arbol.getChildren();
				for(GeneralTree<Integer> i: hijos) {
					Integer valorActual = valorMax(i, nivel+1);
					if(valorActual>valorAnterior) {
						valorAnterior = valorActual;
					}
				}
				valor += valorAnterior;
			} 
		}
		return valor;
	}
	*/
}
