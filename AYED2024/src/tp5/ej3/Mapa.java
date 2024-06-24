package tp5.ej3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;
import tp5.ej2.Recorridos;

@SuppressWarnings("hiding")
public class Mapa<String> {
	Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapa) {
		this.mapaCiudades = mapa;
	}
	
	// OK chequeado
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> camino = new ArrayList<String>();
		if(!mapaCiudades.isEmpty()) {
			boolean[] marca = new boolean[this.mapaCiudades.getSize()];
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen!=null&&destino!=null) {
				dfsModificado(origen,destino,marca,camino);
			}
		}
		return camino;
	}
	
	// DFS V1
	private boolean dfsModificado(Vertex<String> origen, Vertex<String> destino, boolean[] marca, List<String> camino) {
		marca[origen.getPosition()] = true;
		boolean fin = false;
		camino.add(origen.getData());
		if(origen == destino) {
			fin = true;
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator();
			while(it.hasNext()&&!fin) {
				Vertex<String> v = it.next().getTarget();
				int j = v.getPosition();
				if(!marca[j]) {
					fin = dfsModificado(v,destino,marca,camino);
				}
			}
			if(!fin) {
				camino.remove(camino.size()-1);
			}
			marca[origen.getPosition()] = false;
			}
		return fin;
	}	
	
	public List<String> devolverCamino2(String ciudad1, String ciudad2){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		if(!mapaCiudades.isEmpty()) {
			boolean[] marca = new boolean[this.mapaCiudades.getSize()];
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen!=null&&destino!=null) {
				dfsModificadoV2(origen,destino,marca,camino,temp);
			}
		}
		return camino;
	}
	
	// DFS V2
	private void dfsModificadoV2(Vertex<String> origen, Vertex<String> destino, boolean[] marca, List<String> camino, List<String> temp) {
		marca[origen.getPosition()] = true;
		temp.add(origen.getData());
		if(origen == destino) {
			camino.addAll(temp);
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator(); //Las aristas nunca estan null, al crearlas se olbiga a inicalizarla si el vertice la tiene null.
			while(it.hasNext()&&camino.isEmpty()) {
				Vertex<String> v = it.next().getTarget();
				if(!marca[v.getPosition()]) {
					dfsModificadoV2(v,destino,marca,camino,temp);
				}
			}
			temp.remove(origen.getData());
			marca[origen.getPosition()] = false;
		}
	}
	
	// Ej3.inc2
	
	public List<String> devolverCaminoExeptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		if(!mapaCiudades.isEmpty()) {
			boolean[] marca = new boolean[this.mapaCiudades.getSize()];
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen!=null&&destino!=null) {
				dfsModificadoInc2(origen,destino,marca,camino,temp,ciudades);
			}
		}
		return camino;
	}
	
	// OK chequeado
	
	private void dfsModificadoInc2(Vertex<String> origen, Vertex<String> destino, boolean[] marca, List<String> camino, List<String> temp, List<String> ciudades) {
		marca[origen.getPosition()] = true;
		temp.add(origen.getData());
		if(origen == destino) {
			camino.addAll(temp);
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator(); //Las aristas nunca estan null, al crearlas se olbiga a inicalizarla si el vertice la tiene null.
			while(it.hasNext()&&camino.isEmpty()) {
				Vertex<String> v = it.next().getTarget();
				if(!marca[v.getPosition()]&&!ciudades.contains(v.getData())) {
					dfsModificadoInc2(v,destino,marca,camino,temp,ciudades);
				}
			}
			temp.remove(origen.getData());
			marca[origen.getPosition()] = false;
		}
	}
	
	// Ej3.inc3		
	// sin peso	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
		if(mapaCiudades!=null) {
			boolean[] marcas = new boolean[mapaCiudades.getSize()];
			Integer distancia = 0;
			List<String> temp = new LinkedList<String>();
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen!=null&&destino!=null) {
				dfsModificadoCaminoCorto(origen,destino,marcas,camino,temp,distancia);
			}
		}
		return camino;
	}

	private void dfsModificadoCaminoCorto(Vertex<String> origen, Vertex<String> destino, boolean[] marcas, List<String> camino, List<String> temp, Integer distancia) {
		temp.add(origen.getData());
		marcas[origen.getPosition()] = true;
		/*
		System.out.print("distancia "+distancia+" ");
		System.out.print("origen == dest "+(origen==destino)+" || ");
		System.out.println("camino size: "+camino.size());
		*/
		if(origen == destino) {
			if(camino.isEmpty()) {
				camino.addAll(temp);
				//System.out.println("camino size primero: "+camino.size());
			}
			else if(distancia<camino.size()-1) {
				camino.removeAll(camino);
				camino.addAll(temp);
				//System.out.println("camino size despues: "+camino.size());
			}
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator();
			distancia++;
			while(it.hasNext()) {
				Vertex<String> v = it.next().getTarget();
				if(!marcas[v.getPosition()]) {
					dfsModificadoCaminoCorto(v,destino,marcas,camino,temp,distancia);
				}
			}
			distancia--;
		}
		/*
		for(String i: temp) {
			System.out.print(i);
		}
		
		System.out.println("");
		System.out.println("-------");
		*/
		marcas[origen.getPosition()] = false;
		temp.remove(origen.getData());
	}
	
	// con peso y metodo void
	public List<String> caminoMasCortoConPeso(String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
		if(mapaCiudades!=null) {
			boolean[] marcas = new boolean[mapaCiudades.getSize()];
			int[] minimo = new int[1]; minimo[0] = 9999;
			int[] distancia = new int[1]; distancia[0] = 0;
			List<String> temp = new LinkedList<String>();
			Vertex<String> origen = mapaCiudades.search(ciudad1);
			Vertex<String> destino = mapaCiudades.search(ciudad2);
			if(origen!=null&&destino!=null) {
				dfsModificadoCaminoMasCorto2(origen,destino,marcas,camino,temp,distancia,minimo);
			}
		}
		return camino;
	}
	
	private void dfsModificadoCaminoMasCorto2(Vertex<String> origen, Vertex<String> destino, boolean[] marcas, List<String> camino, List<String> temp, int[] distancia, int[] minimo) {
		marcas[origen.getPosition()] = true;
		temp.add(origen.getData());
		/*
		for(String i: temp) {
			System.out.print(i);
		}
		
		System.out.println("-----------");
		*/
		if(origen == destino) {
			if(distancia[0]<minimo[0]) {
				camino.removeAll(camino);
				camino.addAll(temp);
				minimo[0] = distancia[0];
			}
		} else {
			//System.out.println("entre");
			List<Edge<String>> aristas = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator();
			while(it.hasNext()&&distancia[0]<minimo[0]) {
				//System.out.println("while");
				Edge<String> e = it.next();
				Vertex<String> v = e.getTarget();
				distancia[0] += e.getWeight();
				if(!marcas[v.getPosition()]&&distancia[0]<minimo[0]) {
					dfsModificadoCaminoMasCorto2(v,destino,marcas,camino,temp,distancia,minimo);
					//System.out.println("distancia: "+distancia[0]);
				}
				distancia[0] -= e.getWeight();
			}
		}
		temp.remove(origen.getData());
		marcas[origen.getPosition()] = false;
	}
	
	
	// Ej3.inc4
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanque){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		Trayectos<String> min = new Trayectos<String>(camino, 9999);
		Trayectos<String> actual = new Trayectos<String>(temp, 0);
		if(origen!=null&&destino!=null) {
			dfsModificadoCombustible(origen,destino,marca,min,actual,tanque);
		}
		return camino;
	}
	
	private void dfsModificadoCombustible(Vertex<String> origen, Vertex<String> destino, boolean[] marca, Trayectos<String> min, Trayectos<String> actual, int tanque) {
		marca[origen.getPosition()] = true;
		actual.getLista().add(origen.getData());
		if(origen == destino) {
			min.getLista().addAll(actual.getLista());
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator();
			while(it.hasNext()&&min.getLista().isEmpty()) {
				Edge<String> e = it.next();
				Vertex<String> v = e.getTarget();
				if(!marca[v.getPosition()]) {
					tanque -= e.getWeight();
					if(tanque>=0) {
						dfsModificadoCombustible(v,destino,marca,min,actual,tanque);
					}
					tanque += e.getWeight();
				}
			}
		}	
		marca[origen.getPosition()] = false;
		actual.getLista().remove(origen.getData());
	}
	
	// Ej3.inc5
	
	public List<String> caminoMenorCargaCombustible(String ciudad1, String ciudad2, int tanque){
		List<String> camino = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		Vertex<String> origen = mapaCiudades.search(ciudad1);
		Vertex<String> destino = mapaCiudades.search(ciudad2);
		Trayectos<String> min = new Trayectos<String>(camino, 9999);
		Trayectos<String> actual = new Trayectos<String>(temp, 0);
		if(origen!=null&&destino!=null) {
			dfsModificadoMenorCargaCombustible(origen,destino,marca,min,actual,tanque,tanque,0);
		}
		return camino;
	}
	
	private void dfsModificadoMenorCargaCombustible(Vertex<String> origen, Vertex<String> destino, boolean[] marca, Trayectos<String> min, Trayectos<String> actual, int tanque, int recarga, int cant) {
		marca[origen.getPosition()] = true;
		actual.getLista().add(origen.getData());
		if(origen == destino) {
			if(cant<min.getPeso()) {
				min.getLista().clear();
				min.getLista().addAll(actual.getLista());
				min.setPeso(cant);
			}
		} else {
			List<Edge<String>> aristas = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = aristas.iterator();
			while(it.hasNext()&&actual.getPeso()<min.getPeso()) {
				Edge<String> e = it.next();
				Vertex<String> v = e.getTarget();
				if(!marca[v.getPosition()]) {
					tanque -= e.getWeight();
					if(tanque<0) {
						cant++;
						dfsModificadoMenorCargaCombustible(v,destino,marca,min,actual,recarga,recarga,cant);
						cant--;
					} else {
						dfsModificadoMenorCargaCombustible(v,destino,marca,min,actual,tanque,recarga,cant);
					}
					tanque += e.getWeight();
				}
			}
		}	
		marca[origen.getPosition()] = false;
		actual.getLista().remove(origen.getData());
	}
}
