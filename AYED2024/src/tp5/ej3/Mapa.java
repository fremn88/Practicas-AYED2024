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
		boolean[] marca = new boolean[this.mapaCiudades.getSize()+1];
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
					dfsModificado(u.getPosition(),temp,camino,marca,ciudad2);
				}
			}
		}
		
	}	
	
	private int buscaPosDfs(String ciudad){
		int pos = 0;
		boolean[] marca = new boolean[this.mapaCiudades.getSize()+1];		 
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
		boolean[] marca = new boolean[this.mapaCiudades.getSize()+1];
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
						dfsModificado(u.getPosition(),temp,camino,marca,ciudad2);
					}
				}
			}
		}
		
	}	
	
	// Ej3.inc3
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> lista = new ArrayList<String>();
		int tamanio = this.mapaCiudades.getSize()+1;
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
	
	// Ej3.inc4
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanque){
		List<String> camino = new ArrayList<String>();
		int posCiudad1 = buscaPosDfs(ciudad1);
		int posCiudad2 = buscaPosDfs(ciudad2);
		if(posCiudad1>0&&posCiudad2>0) {
			List<String> temp = new ArrayList<String>();
			boolean[] marca = new boolean[mapaCiudades.getSize()+1]; // lista comienza en 1?
			dfsModificadoCombustible(posCiudad1,temp,camino,marca,ciudad2,tanque);
		}
		return camino;
	}
	
	private void dfsModificadoCombustible(int pos, List<String> temp, List<String> camino, boolean[] marca, String ciudad2, int tanque) {
		marca[pos]=true;
		Vertex<String> v = mapaCiudades.getVertex(pos);
		temp.add(v.getData());
		if(v.getData().equals(ciudad2)) {
			camino.addAll(temp);
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			for(Edge<String> arista: aristas) {
				Vertex<String> u = arista.getTarget();
				if(!marca[u.getPosition()]) {
					int combRestante = tanque-arista.getWeight();
					if(combRestante>0) {
						dfsModificadoCombustible(u.getPosition(),temp,camino,marca,ciudad2,combRestante);
					}			
				}
			}
		}
	}
	
	// Ej3.inc4
	
	public List<String> caminoMenorCargaCombustible(String ciudad1, String ciudad2, int tanque){
		List<String> camino = new ArrayList<String>();
		int minimo = numGrande;
		int cargas = 0;
		int recarga = tanque;
		int posCiudad1 = buscaPosDfs(ciudad1);
		int posCiudad2 = buscaPosDfs(ciudad2);
		if(posCiudad1>0&&posCiudad2>0) {
			List<String> temp = new ArrayList<String>();
			boolean[] marca = new boolean[mapaCiudades.getSize()+1]; // lista comienza en 1?
			dfsModificadoMenorCarga(posCiudad1,temp,camino,marca,ciudad2,tanque,recarga,cargas,minimo);
		}
		return camino;
	}
	
	private void dfsModificadoMenorCarga(int pos, List<String> temp, List<String> camino, boolean[] marca, String ciudad2, int tanque, int recarga, int cargas, int minimo) {
		marca[pos]=true;
		Vertex<String> v = mapaCiudades.getVertex(pos);
		// temp.add(v.getData()); no se puede agregar aca xq no se en esta instancia si llego a v.
		if(v.getData().equals(ciudad2)) {
			if(cargas<minimo) {
				camino.addAll(temp);
				minimo = cargas;
			}
		} else {
			//caso en que debo recargar
			if(tanque==0) {
				tanque=recarga;
				cargas++;
			}
			List<Edge<String>> aristas = mapaCiudades.getEdges(v);
			for(Edge<String> arista: aristas) {
				Vertex<String> u = arista.getTarget();
				if(!marca[u.getPosition()]) {
					tanque = tanque-arista.getWeight();
					if(tanque>=0) {
						temp.add(u.getData()); // agrego u dado que verifique q llego con el tanque
						dfsModificadoMenorCarga(u.getPosition(),temp,camino,marca,ciudad2,tanque,recarga,cargas,minimo);
						temp.remove(temp.size()); // vuelvo la lista temp a su estado original para verificar cada vertice
					}
					tanque = tanque+arista.getWeight(); // vuelvo a setear el tanque en inicial, para verificar cada vertice
				}
			}
		}
	}
}
