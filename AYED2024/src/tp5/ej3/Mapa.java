package tp5.ej3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
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
	
	// OK chequeado
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if(origen!=null&&destino!=null) {
			marca[origen.getPosition()]=true;
			temp.add(origen.getData());
			dfsModificado(origen.getPosition(),temp,camino,marca,ciudad2);
		}
		return camino;
	}
	
	// OK chequeado
	private void dfsModificado(int pos, List<String> temp, List<String> camino, boolean[] marca, String ciudad2) {
		Vertex<String> v = this.mapaCiudades.getVertex(pos);
		if(v.getData().equals(ciudad2)) {
			camino.addAll(temp);
			return;
		}
		List<Edge<String>> aristas = mapaCiudades.getEdges(v);
		Iterator<Edge<String>> it = aristas.iterator();
		while(it.hasNext()&&camino.isEmpty()) {
			Vertex<String> u = it.next().getTarget();
			int j = u.getPosition();
			if(!marca[j]) {
				marca[j]=true;
				temp.add(u.getData());
				dfsModificado(j,temp,camino,marca,ciudad2);
				temp.remove(u.getData());
				marca[j]=false;
			}
		}
	}	
	
	// Ej3.inc2
	
	public List<String> devolverCaminoExeptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		if(!ciudades.contains(ciudad1)&&!ciudades.contains(ciudad2)) {
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen!=null&&destino!=null) {
				marca[origen.getPosition()]=true;
				temp.add(origen.getData());
				dfsModificado2(origen.getPosition(),temp,camino,marca,ciudad2,ciudades);
			}
		}
		return camino;
	}
	
	// OK chequeado
	private void dfsModificado2(int pos, List<String> temp, List<String> camino, boolean[] marca, String ciudad2, List<String> ciudades) {
		Vertex<String> v = this.mapaCiudades.getVertex(pos);
		if(v.getData().equals(ciudad2)) {
			camino.addAll(temp);
			return;
		}
		List<Edge<String>> aristas = mapaCiudades.getEdges(v);
		Iterator<Edge<String>> it = aristas.iterator();
		while(it.hasNext()&&camino.isEmpty()) {
			Vertex<String> u = it.next().getTarget();
			int j = u.getPosition();
			if(!marca[j]&&!ciudades.contains(u.getData())) {
				marca[j]=true;
				temp.add(u.getData());
				dfsModificado(j,temp,camino,marca,ciudad2);
				temp.remove(u.getData());
				marca[j]=false;
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
	
	// sin usar Dijkstra
	
	public List<String> caminoMasCorto2(String ciudad1, String ciudad2){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		int distancia = 0;
		int min = numGrande;
		if(origen!=null&&destino!=null) {
			marca[origen.getPosition()]=true;
			temp.add(origen.getData());
			dfsModificadoCaminoCorto(origen.getPosition(),temp,camino,marca,ciudad2,min,distancia);
		}
		
		return camino;
	}
	
	private void dfsModificadoCaminoCorto(int pos, List<String> temp, List<String> camino, boolean[] marca, String ciudad2, int minimo, int distancia) {
		Vertex<String> v = this.mapaCiudades.getVertex(pos);
		if(v.getData().equals(ciudad2)) {
			if(distancia<minimo) {
				camino = new LinkedList<String>(temp);
				minimo = distancia;
			}
			return;
		}
		List<Edge<String>> aristas = mapaCiudades.getEdges(v);
		Iterator<Edge<String>> it = aristas.iterator();
		while(it.hasNext()) {
			Vertex<String> u = it.next().getTarget();
			int j = u.getPosition();
			if(!marca[j]) {
				temp.add(u.getData());
				distancia++;
				marca[j]=true;
				dfsModificadoCaminoCorto(j,temp,camino,marca,ciudad2,minimo,distancia);
				temp.remove(u.getData());  //acondiciono lista y distancia para evaluar otros caminos en los demas vertices.
				distancia--;
				marca[j]=false;
				}
			}
	}
	
	
	// Ej3.inc4
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanque){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		if(origen!=null&&destino!=null) {
			marca[origen.getPosition()]=true;
			temp.add(origen.getData());
			dfsModificadoCombustible(origen.getPosition(),temp,camino,marca,ciudad2,tanque);
		}
		return camino;
	}
	
	private void dfsModificadoCombustible(int pos, List<String> temp, List<String> camino, boolean[] marca, String ciudad2, int tanque) {
		Vertex<String> v = mapaCiudades.getVertex(pos);
		if(v.getData().equals(ciudad2)) {
			camino.addAll(temp);
			return;
		} 
		List<Edge<String>> aristas = mapaCiudades.getEdges(v);
		Iterator<Edge<String>> it = aristas.iterator();
		while(it.hasNext()&&camino.isEmpty()) {
			Vertex<String> u = it.next().getTarget();
			int j = u.getPosition();
			if(!marca[j]) {
				tanque-=it.next().getWeight();
				if(tanque>0) {
					marca[j]=true;
					temp.add(u.getData());
					dfsModificadoCombustible(j,temp,camino,marca,ciudad2,tanque);
					marca[j]=false;
					temp.remove(u.getData());
				}	
				tanque+=it.next().getWeight();
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
			boolean[] marca = new boolean[mapaCiudades.getSize()]; // lista comienza en 1?
			dfsModificadoMenorCarga(posCiudad1,temp,camino,marca,ciudad2,tanque,recarga,cargas,minimo);
		}
		return camino;
	}
	
	private void dfsModificadoMenorCarga(int pos, List<String> temp, List<String> camino, boolean[] marca, String ciudad2, int tanque, int recarga, int cargas, int minimo) {
		// marca[pos]=true; no marco aca porque necesito tener el vertice de ciudad2 no marcado, para evaluar los distintos caminos.
		Vertex<String> v = mapaCiudades.getVertex(pos);
		// temp.add(v.getData()); no se puede agregar aca xq no se en esta instancia si llego a v.
		if(v.getData().equals(ciudad2)) {
			if(cargas<minimo) {
				camino.addAll(temp);
				minimo = cargas;
				
			}
		} else {
			//si no llegue a ciudad, marco visitado (aca siempre llego con un vertice no visitado)
			marca[pos]=true;
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
