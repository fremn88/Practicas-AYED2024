package tp5.ej5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class QuedateEnCasa {
	
	public static List<Persona> armarCartera(Graph<Persona> grafo, int grado, Persona p){
		List<Persona> resultado = new LinkedList<Persona>();
		if(!grafo.isEmpty()&&p.getEsEmpleado()) {
			Vertex<Persona> origen = grafo.search(p);
			if(origen!=null) {
				boolean[] marca = new boolean[grafo.getSize()];
                dfs(origen,grafo,grado,marca,resultado);
			}
		}
		return resultado;
	}
	
	private static void dfs(Vertex<Persona> persona, Graph<Persona> grafo, int grado, boolean[] marca, List<Persona> resultado) {
        marca[persona.getPosition()] = true;
        if(grado>=0&&resultado.size()<40){
            if(!persona.getData().getEsEmpleado()&&!persona.getData().getCobro()){
                resultado.add(persona.getData());
            }
            List<Edge<Persona>> aristas = grafo.getEdges(persona);
            Iterator<Edge<Persona>> it = aristas.iterator();
            while(it.hasNext()&&resultado.size()<40&&grado>0){
                Edge<Persona> e = it.next();	
                Vertex<Persona> v = e.getTarget();
                if(!marca[v.getPosition()]){
                    dfs(v,grafo,grado-1,marca,resultado);
                }
            }
        }
    }
}
