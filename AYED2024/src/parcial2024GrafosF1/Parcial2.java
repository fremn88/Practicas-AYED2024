package parcial2024GrafosF1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class Parcial2 {
	public static String resolver(Graph<Recinto> grafo, int tiempo) {
		String resultado;
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
		if(camino.size()==grafo.getSize()) {
			resultado = "Alcanzable";
		} else { resultado = "No Alcanzable ";}
		return resultado;
	}
	
	private static void dfs(Vertex<Recinto> origen, Graph<Recinto> grafo, int tiempo, boolean[] marca, List<Recinto> temp, List<Recinto> camino) {
		marca[origen.getPosition()] = true;
		tiempo -= origen.getData().getTiempo();
		if(tiempo<0) {
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
			System.out.println(origen.getData().getNombre());
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
}
