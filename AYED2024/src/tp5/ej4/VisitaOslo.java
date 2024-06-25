package tp5.ej4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class VisitaOslo {

    public static List<String> paseoEnBici(Graph<String> grafo, String destino, int maxTiempo, List<String> restringidos){
        List<String> camino = new LinkedList<String>();
        List<String> temp = new LinkedList<String>();
        Vertex<String> origen = grafo.search("Ciudad0");
        Vertex<String> destino1 = grafo.search(destino);
        boolean[] marca = new boolean[grafo.getSize()];
        if(origen!=null&&destino1!=null){
           dfs(grafo,origen,destino1,marca,temp,camino,restringidos,maxTiempo);
        }
        return camino;
    }

    private static void dfs(Graph<String> grafo, Vertex<String> origen, Vertex<String> destino, boolean[] marca, List<String> temp, List<String> camino, List<String> restringidos, int tiempo){
    	marca[origen.getPosition()] = true;
    	temp.add(origen.getData());
    	if(origen == destino) {
    		camino.addAll(temp);
    	} else {
	    	List<Edge<String>> aristas = grafo.getEdges(origen);
	        Iterator<Edge<String>> it = aristas.iterator();
	        while(it.hasNext()&&camino.isEmpty()){
	        	Edge<String> e = it.next();
	            Vertex<String> u = e.getTarget();
	            tiempo-=e.getWeight();
	            if(!marca[u.getPosition()]&&tiempo>=0&&!restringidos.contains(u.getData())){
	                dfs(grafo,u,destino,marca,temp,camino,restringidos,tiempo);
	            }
	            tiempo+=e.getWeight();
	        }
    	}
    	marca[origen.getPosition()] = false;
    	temp.remove(origen.getData());
    }
	
}
