package tp3.ej1;

import java.util.LinkedList;
import java.util.List;
import tp1.ej8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	

	
	public int altura() {
		int res = 0;
		if(this.hasChildren()) {
			List<GeneralTree<T>> ListaHijos = this.getChildren(); 
			int aux1 = 0;
			int aux2 = 0;
			for(GeneralTree<T> hijo: ListaHijos){
				// no es necesario preguntar si el hijo es null
				aux2 = hijo.altura();
				if(aux2>aux1){
					aux1 = aux2;
				}
			}
			res = 1 + aux1;
		}
		
		return res;
	}

	public int nivel(T dato){
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>(); 
		cola.enqueue(this);
		cola.enqueue(null);
		int nivel = 0;
		boolean encontre = false;
		while(!cola.isEmpty()&&!encontre) {
			GeneralTree<T> v = cola.dequeue();
			if(v!=null) {
				if(v.getData()!=null) {
					if(v.getData()==dato) {
						encontre = true;
					}
					if(v.hasChildren()) {
						List<GeneralTree<T>> hijos = v.getChildren(); 
						for(GeneralTree<T> i: hijos) {
							cola.enqueue(i);
						}
					}
				}
			} else if(!cola.isEmpty()) {
				cola.enqueue(null);
				nivel++;
			} else if(!encontre) {
				nivel = 0;
			}
		}
		return nivel;
	  }

	public int ancho(){
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>(); 
		cola.enqueue(this);
		cola.enqueue(null);
		int ancho1 = 1;
		int ancho2 = 0;
		while(!cola.isEmpty()) {
			GeneralTree<T> v = cola.dequeue();
			if(v!=null) {
				if(v.hasChildren()) {
					List<GeneralTree<T>> hijos = v.getChildren();
					for(GeneralTree<T> i: hijos) {
						cola.enqueue(i);
						ancho2++;
					}
				}
			} else if(!cola.isEmpty()) {
				cola.enqueue(null);
			}
			if(ancho2>ancho1) {
				ancho1=ancho2;
				ancho2=0;
			}
		}
		return ancho1;		
	}
	
	public boolean esAncestro(T a, T b) {
		boolean encontre = false;
		if(this.getData()==a) {
			if(this.hasChildren()) {
				List<GeneralTree<T>> hijos = this.getChildren();
				for(GeneralTree<T> hijo: hijos){
					if(!encontre){
						encontre = hijo.esDescendiente(b);
					}
				}
			}
		} else {
			//busco ancestro y ejecuto busqueda descendiente
			if(this.hasChildren()) {
				List<GeneralTree<T>> hijos = this.getChildren();
				for(GeneralTree<T> hijo: hijos){
					encontre = hijo.esAncestro(a, b);
				}
			}
		}
		return encontre;
	}
	
	private boolean esDescendiente(T b) {
		boolean encontre = false;
		if(this.getData()==b) {
			encontre = true;
		} else if(this.hasChildren()) {
			List<GeneralTree<T>> hijos = this.getChildren();
			for(GeneralTree<T> hijo: hijos){
				encontre = hijo.esDescendiente(b);
			}
		}
		return encontre;
	}
	
	public void imprimirNiveles() {
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue((GeneralTree<T>) this); 
		cola.enqueue(null);
		System.out.print("[ ");
		while(!cola.isEmpty()) {
			GeneralTree<T> aux = cola.dequeue();
			if(aux!=null) {
				System.out.print(aux.getData()+" ");
				if(aux.hasChildren()) {
					List<GeneralTree<T>> hijos = new LinkedList<GeneralTree<T>>();
					hijos = aux.getChildren();
					for(GeneralTree<T> i: hijos) {
						cola.enqueue(i);
					}
				}
			} else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					System.out.print(" ]");
					System.out.println("");
					System.out.print("[ ");
					}
				}
			}
		System.out.print("]");
	}
}


