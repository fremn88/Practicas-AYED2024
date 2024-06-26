package tp5.ej6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class BuscadorDeCaminos {
	
	Graph<String> bosque;
	
	public BuscadorDeCaminos(Graph<String> bosque) {
		this.bosque = bosque;
	}
	
	public List<List<String>> recorridosMasSeguros(){
		List<List<String>> resultado = new LinkedList<List<String>>();
		if(!bosque.isEmpty()) {
			Vertex<String> origen = bosque.search("Caperucita");
			Vertex<String> destino = bosque.search("Abuela");
			if(origen!=null&&destino!=null) {
				List<String> lis = new LinkedList<String>();
				boolean[] marca = new boolean[bosque.getSize()];
				dfs(origen,destino,marca,resultado,lis);
			}
		}
		return resultado;
	}
	
	private void dfs(Vertex<String> origen, Vertex<String> destino, boolean[] marca, List<List<String>> resultado, List<String> lis) {
		marca[origen.getPosition()] = true;
		lis.add(origen.getData());
		if(origen == destino) {
			List<String> aux = new LinkedList<String>(lis);
			resultado.add(aux);
			//lis se deja como esta?
		} else {
			List<Edge<String>> aristas = bosque.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator();
			while(it.hasNext()) {
				Edge<String> e = it.next();
				Vertex<String> v = e.getTarget();
				if(!marca[v.getPosition()]&&e.getWeight()<=5) {
					dfs(v,destino,marca,resultado,lis);
				}
			}
		}
		marca[origen.getPosition()] = false;
		lis.remove(origen.getData());
	}
}
