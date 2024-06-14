package tp3.ej2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ej1.GeneralTree;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, int n){
		List<Integer> res = new ArrayList<Integer>();
		if(a!=null) {
			numerosImparesMayoresQuePreOrden(a,n,res);
		}
		return res;
	}
	
	private void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, int n, List<Integer> lis) {
		Integer dato = a.getData();
		if(dato%2!=0&&dato>n) {
			lis.add(a.getData());
		}
		List<GeneralTree<Integer>> hijos = a.getChildren();
		Iterator<GeneralTree<Integer>> it = hijos.iterator();
		while(it.hasNext()) {
			numerosImparesMayoresQuePreOrden(it.next(),n,lis);
		}
	}
	
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, int n){
		List<Integer> res = new ArrayList<Integer>();
		if(a!=null) {
			numerosImparesMayoresQueInOrden(a,n,res);
		}
		return res;
	}
	
	public void numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, int n, List<Integer> lis) {
		List<GeneralTree<Integer>> hijos = a.getChildren();
		if(a.hasChildren()) {
			numerosImparesMayoresQueInOrden(hijos.get(0),n,lis);
		}
		Integer dato = a.getData();
		if(dato%2!=0&&dato>n) {
			lis.add(a.getData());
		}
		for(int i=1;i<hijos.size();i++) {
			numerosImparesMayoresQueInOrden(hijos.get(i),n,lis);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, int n){
		List<Integer> res = new ArrayList<Integer>();
		if(a!=null) {
			numerosImparesMayoresQuePostOrden(a,n,res);
		}
		return res;
	}
	
	private void numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, int n, List<Integer> lis) {
		List<GeneralTree<Integer>> hijos = a.getChildren();
		Iterator<GeneralTree<Integer>> it = hijos.iterator();
		while(it.hasNext()) {
			numerosImparesMayoresQuePreOrden(it.next(),n,lis);
		}
		Integer dato = a.getData();
		if(dato%2!=0&&dato>n) {
			lis.add(a.getData());
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, int n){
		List<Integer> res = new ArrayList<Integer>();
		GeneralTree<Integer> ar;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(a);
		while(!cola.isEmpty()) {
			ar = cola.dequeue();
			if(ar!=null) {
				Integer dato = ar.getData();
				if(dato%2!=0&&dato>n) {
					res.add(dato);
				}
				if(ar.hasChildren()) {
					List<GeneralTree<Integer>> hijos = a.getChildren();
					for(GeneralTree<Integer> hijo: hijos) {
						cola.enqueue(hijo);
					}
				}
			}
		}
		return res;
	}
}
