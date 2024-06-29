package parcial2024GrafosF1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class Parcial {
	
	public static int resolver(Graph<Recinto> grafo, int tiempo) {
		List<Recinto> camino = new LinkedList<Recinto>();
		if(!grafo.isEmpty()) {
			Recinto entrada = new Recinto(15,"entrada");
			Vertex<Recinto> origen = grafo.search(entrada);
			if(origen!=null) {
				List<Recinto> temp = new LinkedList<Recinto>();
				boolean[] marca = new boolean[grafo.getSize()];
				dfs(origen,grafo,tiempo,marca,temp,camino);
			}
		}
		return camino.size();
	}
	
	private static void dfs(Vertex<Recinto> origen, Graph<Recinto> grafo, int tiempo, boolean[] marca, List<Recinto> temp, List<Recinto> camino) {
		marca[origen.getPosition()] = true;
		tiempo -= origen.getData().getTiempo();
		if(tiempo<=0) {
			if(!camino.isEmpty()) {
				if(camino.size()<temp.size()) {
					camino.clear();
					camino.addAll(temp);
				}
			} else {
				camino.addAll(temp);
			}
		} else {
			temp.add(origen.getData());
			List<Edge<Recinto>> aristas = grafo.getEdges(origen);
			Iterator<Edge<Recinto>> it = aristas.iterator();
			while(it.hasNext()) {
				Edge<Recinto> e = it.next();
				Vertex<Recinto> v = e.getTarget();
				if(!marca[v.getPosition()]) {
					int t = e.getWeight();
					if(tiempo-t>0) {
						dfs(v,grafo,tiempo-t,marca,temp,camino);
					}
				}
			}
			if(!camino.isEmpty()) {
				if(camino.size()<temp.size()) {
					camino.clear();
					camino.addAll(temp);
				}
			} else {
				camino.addAll(temp);
			}
			temp.remove(origen.getData());
		}
		marca[origen.getPosition()] = false;
	}
	
	public static int resolverV2(Graph<Recinto> grafo, int tiempo) {
		int max = 0;
		if(!grafo.isEmpty()) {
			Recinto entrada = new Recinto(15,"entrada");
			Vertex<Recinto> origen = grafo.search(entrada);
			if(origen!=null) {
				boolean[] marca = new boolean[grafo.getSize()];
				if(tiempo-origen.getData().getTiempo()>=0) {
					max = dfsV2(origen,grafo,tiempo-origen.getData().getTiempo(),marca,1,0);
				}
			}
		}
		return max;
	}
	
	private static int dfsV2(Vertex<Recinto> origen, Graph<Recinto> grafo, int tiempo, boolean[] marca, int cant, int max) {
		marca[origen.getPosition()] = true;
		List<Edge<Recinto>> aristas = grafo.getEdges(origen);
		Iterator<Edge<Recinto>> it = aristas.iterator();
		while(it.hasNext()) {
			Edge<Recinto> e = it.next();
			Vertex<Recinto> v = e.getTarget();
			int costoTiempo = e.getWeight()+v.getData().getTiempo();
			if(!marca[v.getPosition()]&&costoTiempo<=tiempo) {
				max = dfsV2(v,grafo,tiempo-costoTiempo,marca,cant++,max);
			}
		}
		if(cant>max) {
			max = cant;
		}
		marca[origen.getPosition()] = false;
		return max;
	}
}






















