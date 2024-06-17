package tp5.test;

import java.util.List;

import tp5.ej1.Edge;
import tp5.ej1.GraphAdjList;
import tp5.ej1.VertexAdjList;
import tp5.ej2.Recorridos;

public class Grafos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjList<String> grafo1 = new GraphAdjList<String>();
		// agrego vertices
		grafo1.createVertex("Nivel_0");
		grafo1.createVertex("Nivel_1A");
		grafo1.createVertex("Nivel_1B");
		grafo1.createVertex("Nivel_1C");
		grafo1.connect(grafo1.search("Nivel_0"), grafo1.search("Nivel_1A"));
		grafo1.connect(grafo1.search("Nivel_0"), grafo1.search("Nivel_1B"));
		grafo1.connect(grafo1.search("Nivel_0"), grafo1.search("Nivel_1C"));
		grafo1.createVertex("Nivel_2AA");
		grafo1.createVertex("Nivel_2AB");
		grafo1.createVertex("Nivel_2BA");
		grafo1.createVertex("Nivel_2CA");
		grafo1.createVertex("Nivel_2CB");
		grafo1.connect(grafo1.search("Nivel_1A"), grafo1.search("Nivel_2AA"));
		grafo1.connect(grafo1.search("Nivel_1A"), grafo1.search("Nivel_2AB"));
		grafo1.connect(grafo1.search("Nivel_1B"), grafo1.search("Nivel_2BA"));
		grafo1.connect(grafo1.search("Nivel_1C"), grafo1.search("Nivel_2CA"));
		grafo1.connect(grafo1.search("Nivel_1C"), grafo1.search("Nivel_2CB"));
		//System.out.println(grafo1.getVertex(0)==grafo1.getVertex(1));
		//System.out.println((grafo1.belongs(grafo1.search("Nivel_0"))&&grafo1.belongs(grafo1.search("Nivel_1A"))));
		//System.out.println(grafo1.existsEdge(grafo1.search("Nivel_1A"), grafo1.search("Nivel_2AA")));
		/*
		VertexAdjList<String> v = (VertexAdjList<String>) grafo1.getVertex(0);
		List<Edge<String>> aristas = v.getEdges();
		Edge<String> arista0 = aristas.get(1);
		//System.out.println(arista0.getTarget().getData());
		//System.out.println(grafo1.search("Nivel_2CB").getPosition());
		grafo1.removeVertex(v);
		System.out.println(grafo1.getVertex(0).getData());
		*/
		
		Recorridos<String> test = new Recorridos<String>();
		List<String> lis = test.bfs(grafo1);
		for(String i: lis) {
			System.out.println(i);
		}
		
		
	}

}
