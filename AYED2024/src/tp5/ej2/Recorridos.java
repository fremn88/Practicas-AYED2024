package tp5.ej2;

import java.util.ArrayList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class Recorridos<T> {
	
	public List<T> dfs(Graph<T> grafo){
		List<T> lista = new ArrayList<T>();
		boolean[] marca = new boolean[grafo.getSize()];
		for(int i=0;i<grafo.getSize();i++) {
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
		List<Edge<T>> aristas = grafo.getEdges(v);
		if(aristas!=null) {
			for(Edge<T> arista: aristas) {
				Vertex<T> destino = arista.getTarget();
				int posicion = destino.getPosition();
				if(!marca[posicion]) {
					dfs(posicion,grafo,lista,marca);
				}
			}
		}
	}
}
