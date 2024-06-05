package tp5.ej3;

import java.util.ArrayList;
import java.util.List;

import tp1.ej8.Queue;
import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

@SuppressWarnings("hiding")
public class Mapa<String> {
	private final static int numGrande = 9999;
	Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapa) {
		this.mapaCiudades = mapa;
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		int posCiudad1 = this.buscaPosDfs(ciudad1);
		dfsModificado(posCiudad1,temp,camino,marca,ciudad2);
		return camino;
	}
	
	private void dfsModificado(int pos, List<String> temp, List<String> camino, boolean[] marca, String ciudad2) {
		marca[pos] = true;
		Vertex<String> v = this.mapaCiudades.getVertex(pos);
		temp.add(v.getData());
		if(v.getData().equals(ciudad2)) {
			camino.addAll(temp);
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			for(Edge<String> arista: aristas) {
				Vertex<String> u = arista.getTarget();
				if(!marca[u.getPosition()]) {
					dfsModificado(pos,temp,camino,marca,ciudad2);
				}
			}
		}
		
	}	
	
	private int buscaPosDfs(String ciudad){
		int pos = 0;
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];		 
		for(int i=1;i<=marca.length;i++) {
			if(!marca[i]) {
				dfs(i,pos,marca,ciudad);
			}
		}
		return pos;
	}
	
	private void dfs(int i, int pos, boolean[] marca, String ciudad) {
		marca[i]=true;
		Vertex<String> v = this.mapaCiudades.getVertex(i);
		if(v.getData().equals(ciudad)) {
			pos = i;
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			if(aristas!=null) { 								
				for(Edge<String> arista: aristas) {
					Vertex<String> destino = arista.getTarget();
					i = destino.getPosition();
					if(!marca[i]) {
						dfs(i,pos,marca,ciudad);
					}
				}
			}
		}
	}
	
	// Ej3.inc2
	
	public List<String> devolverCaminoExeptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		if(!ciudades.contains(ciudad1)&&!ciudades.contains(ciudad2)) {
			int posCiudad1 = this.buscaPosDfs(ciudad1);
			for(int i=0; i<marca.length;i++) {
				marca[i]=false;
			}
			dfsModificado2(posCiudad1,temp,camino,marca,ciudad2,ciudades);
		}
		return camino;
	}
	
	private void dfsModificado2(int pos, List<String> temp, List<String> camino, boolean[] marca, String ciudad2, List<String> ciudades) {
		marca[pos] = true;
		boolean excepcion = false;
		Vertex<String> v = this.mapaCiudades.getVertex(pos);
		temp.add(v.getData());
		if(v.getData().equals(ciudad2)) {
			camino.addAll(temp);
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			for(Edge<String> arista: aristas) {
				Vertex<String> u = arista.getTarget();
				excepcion = ciudades.contains(u.getData());
				if(!excepcion) {
					if(!marca[u.getPosition()]) {
						dfsModificado(pos,temp,camino,marca,ciudad2);
					}
				}
			}
		}
		
	}	
	
	// Ej3.inc3
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> lista = new ArrayList<String>();
		int tamanio = this.mapaCiudades.getSize();
		int[] pesos = new int[tamanio];
		int[] previo = new int[tamanio];
		boolean[] marca = new boolean[tamanio];
		int posInicial = buscaPosDfs(ciudad1);
		int posFinal = buscaPosDfs(ciudad2);
		
		// se ejecuta busqueda solo si las ciudades ingresadas existen.
		if(posInicial!=0&&posFinal!=0) {
			//inicializo vector pesos
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
			
			//Armar camino minimo con la tabla ... ?
		}
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
