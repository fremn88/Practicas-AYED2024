package tp5.ej5;

import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class QuedateEnCasa {
	
	public static List<Persona> armarCartera(Graph<Persona> grafo, int grado, Persona p){
		List<Persona> resultado = new LinkedList<Persona>();
		if(!grafo.isEmpty()&&p.getEsEmpleado()) {
			Vertex<Persona> origen = grafo.search(p);
			if(origen!=null) {
				boolean[] marca = new boolean[grafo.getSize()];
				
			}
		}
		return resultado;
	}
	
	private static void dfs(Vertex<Persona> origen, Graph<Persona> grafo, int grado, boolean[] marca, List<Persona> jubilados) {
		marca[origen.getPosition()] = true;
		jubilados.add(origen.getData());
		
	}
}
