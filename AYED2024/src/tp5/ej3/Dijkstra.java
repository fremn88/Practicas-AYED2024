package tp5.ej3;

import java.util.ArrayList;
import java.util.List;

import tp1.ej8.Queue;
import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class Dijkstra {
	
	private final static int numGrande = 9999;
	Graph<String> mapaCiudades;
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> lista = new ArrayList<String>();
		int tamanio = this.mapaCiudades.getSize();
		int[] pesos = new int[tamanio];
		int[] previo = new int[tamanio];
		boolean[] marca = new boolean[tamanio];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		
		if(origen!=null&&destino!=null) {
			int posInicial = mapaCiudades.search(ciudad1).getPosition();
			int posFinal = mapaCiudades.search(ciudad2).getPosition();

			for(int i=0; i<pesos.length;i++) {
				pesos[i]=numGrande;
			}
			pesos[posInicial] = 0;
			
			//Se implementa Dijkstra
			
			Queue<Vertex<String>> q = new Queue<Vertex<String>>();
			q.enqueue(this.mapaCiudades.getVertex(posInicial));
			while(!q.isEmpty()) {
				Vertex<String> v = q.dequeue();
				int posAnterior = v.getPosition();
				marca[posAnterior] = true;
				List<Edge<String>> aristas = this.mapaCiudades.getEdges(v);
				for(Edge<String> arista: aristas) {
					Vertex<String> w = arista.getTarget();
					int posActual = w.getPosition();
					if(!marca[posActual]) {
						if(pesos[posActual]>pesos[posAnterior]+arista.getWeight()) {
							pesos[posActual] = pesos[posAnterior]+arista.getWeight();
							previo[posActual] = v.getPosition();
						}
	
					}		
				}
				q.enqueue(mapaCiudades.getVertex(buscarMenorDesco(pesos,marca)));
			}
		}
			//Armar camino minimo con la tabla ... ?
		
		return lista;
	}
	
	private int buscarMenorDesco(int[] pesos, boolean[] marca) {
		int pos = 0;
		int min = numGrande;
		for(int i=0; i<pesos.length; i++) {
			if(pesos[i]<min&&!marca[i]) {
				pos = i;
				min = pesos[i];
			}
		}
		return pos;
	}        
}
