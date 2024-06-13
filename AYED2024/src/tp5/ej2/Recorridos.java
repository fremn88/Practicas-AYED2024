package tp5.ej2;

import java.util.ArrayList;
import java.util.List;

import tp1.ej8.Queue;
import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class Recorridos<T> {
	
	public List<T> dfs(Graph<T> grafo){
		List<T> lista = new ArrayList<T>();
		boolean[] marca = new boolean[grafo.getSize()];		 
		for(int i=1;i<=grafo.getSize();i++) {
			if(!marca[i]) {
				dfs(i,grafo,lista,marca);
			}
		}
		return lista;
	}
	
	void dfs(int i,Graph<T> grafo,List<T> lista,boolean[] marca) {
		marca[i]=true;
		Vertex<T> v = grafo.getVertex(i);
		lista.add(v.getData());
		List<Edge<T>> aristas = grafo.getEdges(v);	// no hace falta chequear null.						
		for(Edge<T> arista: aristas) {
			Vertex<T> destino = arista.getTarget();
			int posicion = destino.getPosition();
			if(!marca[posicion]) {
				dfs(posicion,grafo,lista,marca);
				}
			}
	}
	
	// Orden dfs |V|+|E|
	
	public List<T> bfs(Graph<T> grafo){
		boolean[] marca = new boolean[grafo.getSize()];
		List<T> lista = new ArrayList<T>();
		for(int i=1;i<=grafo.getSize();i++) {
			if(!marca[i]) {
				bfs(i,grafo,lista,marca);
			}
		}
		return lista;
	}
	
	private void bfs(int i, Graph<T> grafo, List<T> lista, boolean[] marca) {
		Queue<Vertex<T>> q = new Queue<Vertex<T>>();
		q.enqueue(grafo.getVertex(i));
		marca[i]=true;
		while(!q.isEmpty()) {
			Vertex<T> v = q.dequeue();
			lista.add(v.getData());
			List<Edge<T>> aristas = grafo.getEdges(v);
			for(Edge<T> arista: aristas) {
				Vertex<T> u = arista.getTarget();
				int pos = u.getPosition();
				if(!marca[pos]) {
					marca[pos] = true;
					q.enqueue(v);
				}
			}
		}
	}
	
	// Orden bfs |V|+|E|
	
}
