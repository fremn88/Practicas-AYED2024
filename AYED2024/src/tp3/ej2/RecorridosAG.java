package tp3.ej2;

import java.util.ArrayList;
import java.util.List;

import tp1.ej8.Queue;
import tp3.ej1.GeneralTree;

public class RecorridosAG {
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, int n){
		List<Integer> res = new ArrayList<Integer>();
		// debo preguntar si a != null ???? Luego debo preguntar si !a.isEmpty ????
		if(a!=null) {
			if(!a.isEmpty()) {
				Integer aux = a.getData();
				if(aux%2!=0&&aux>n) {
					res.add(aux);
				}
			}
			if(a.hasChildren()) {
				List<GeneralTree<Integer>> ListaHijos = a.getChildren();
				while(!ListaHijos.isEmpty()) {
					GeneralTree<Integer> hijo = ListaHijos.remove(0);
					res.addAll(this.numerosImparesMayoresQuePreOrden(hijo, n));
				}
			}
		}
		return res;
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, int n){
		List<Integer> res = new ArrayList<Integer>();
		if(a!=null) {
			if(a.hasChildren()) {
				List<GeneralTree<Integer>> ListaHijos = a.getChildren();
				GeneralTree<Integer> hijo = ListaHijos.remove(0);
				if(hijo!=null) {
					res.addAll(this.numerosImparesMayoresQueInOrden(hijo, n));
				}
				if(!a.isEmpty()) {
					Integer aux = a.getData();
					if(aux%2!=0&&aux>n) {
						res.add(aux);
					}
				}
				while(!ListaHijos.isEmpty()) {
					hijo = ListaHijos.remove(0);
					res.addAll(this.numerosImparesMayoresQuePreOrden(hijo, n));
				}
			}
			else if(!a.isEmpty()) {
				Integer aux = a.getData();
				if(aux%2!=0&&aux>n) {
					res.add(aux);
				}
			}
		}
		return res;
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, int n){
		List<Integer> res = new ArrayList<Integer>();
		// debo preguntar si a != null ???? Luego debo preguntar si !a.isEmpty ????
		if(a!=null) {
			if(a.hasChildren()) {
				List<GeneralTree<Integer>> ListaHijos = a.getChildren();
				while(!ListaHijos.isEmpty()) {
					GeneralTree<Integer> hijo = ListaHijos.remove(0);
					res.addAll(this.numerosImparesMayoresQuePostOrden(hijo, n));
				}
			}
			if(!a.isEmpty()) {
				Integer aux = a.getData();
				if(aux%2!=0&&aux>n) {
					res.add(aux);
				}
			}
		}
		return res;
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, int n){
		List<Integer> res = new ArrayList<Integer>();
		// debo preguntar si a != null ???? Luego debo preguntar si !a.isEmpty ????
		if(a!=null) {
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			cola.enqueue(a);
			cola.enqueue(null);
			while(!cola.isEmpty()) {
				GeneralTree<Integer> v = cola.dequeue();
				if(v!=null) {
					if(!v.isEmpty()) {
						Integer aux = v.getData();
						if(aux%2!=0&&aux>n) {
							res.add(aux);
						}
					}
					if(v.hasChildren()) {
						List<GeneralTree<Integer>> ListaHijos = v.getChildren();
						while(!ListaHijos.isEmpty()) {
							GeneralTree<Integer> hijo = ListaHijos.remove(0);
							cola.enqueue(hijo);
						}
					}
				}
				else if(!cola.isEmpty()) {
					cola.enqueue(null);
				}
			}
		}
		return res;
	}
}
