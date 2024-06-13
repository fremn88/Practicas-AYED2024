package tp5.ej4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.Graph;
import tp5.ej1.Vertex;

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> grafo, String destino, int maxTiempo, List<String> restringidos){
        List<String> camino = new LinkedList<String>();
        List<String> temp = new LinkedList<String>();
        Vertex<String> origen = grafo.search("Ayuntamiento");
        Vertex<String> destino1 = grafo.search(destino);
        boolean[] marca = new boolean[grafo.getSize()];
        if(origen!=null&&destino1!=null){
            int j = origen.getPosition();
            marca[j] = true;
            int tiempo = maxTiempo;
            temp.add(origen.getData());
            dfs(j,grafo,temp,camino,destino,tiempo,marca,restringidos);
        }
        return camino;
    }

    private void dfs(int j, Graph<String> grafo, List<String> temp, List<String> camino, String destino, int tiempo, boolean[] marca, List<String> restringidos){
        Vertex<String> v = grafo.getVertex(j);
        if(v.getData().equals(destino)){
            camino.addAll(temp);
            return;
            }
        List<Edge<String>> aristas = grafo.getEdges(v);
        Iterator<Edge<String>> it = aristas.iterator();
        while(it.hasNext()&&camino.isEmpty()){
            Vertex<String> u = it.next().getTarget();
            int j1 = u.getPosition();
            tiempo-=it.next().getWeight();
            if(!marca[j1]&&tiempo>=0&&!restringidos.contains(u.getData())){
                marca[j1] = true;
                temp.add(u.getData());
                dfs(j1,grafo,temp,camino,destino,tiempo,marca,restringidos);
                marca[j1]=false;
                temp.remove(u.getData());
            }
            tiempo+=it.next().getWeight();
        }
    }
	
}
