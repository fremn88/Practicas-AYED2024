package tp5.test;

import java.util.LinkedList;
import java.util.List;

import tp5.ej1.GraphAdjList;
import tp5.ej3.Mapa;

public class GrafosTp5Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjList<String> grafo1 = new GraphAdjList<String>();
		// agrego vertices
		grafo1.createVertex("Ciudad0");
		grafo1.createVertex("Ciudad1");
		grafo1.createVertex("Ciudad2");
		grafo1.createVertex("Ciudad3");
		grafo1.createVertex("Ciudad4");
		grafo1.createVertex("Ciudad5");
		grafo1.createVertex("Ciudad6");
		grafo1.createVertex("Ciudad7");
		grafo1.createVertex("Ciudad8");
		grafo1.connect(grafo1.search("Ciudad0"), grafo1.search("Ciudad1"));
		grafo1.connect(grafo1.search("Ciudad0"), grafo1.search("Ciudad2"));
		grafo1.connect(grafo1.search("Ciudad0"), grafo1.search("Ciudad4"));
		grafo1.connect(grafo1.search("Ciudad0"), grafo1.search("Ciudad8"));
		grafo1.connect(grafo1.search("Ciudad1"), grafo1.search("Ciudad0"));
		grafo1.connect(grafo1.search("Ciudad1"), grafo1.search("Ciudad2"));
		grafo1.connect(grafo1.search("Ciudad2"), grafo1.search("Ciudad0"));
		grafo1.connect(grafo1.search("Ciudad2"), grafo1.search("Ciudad1"));
		grafo1.connect(grafo1.search("Ciudad2"), grafo1.search("Ciudad3"));
		grafo1.connect(grafo1.search("Ciudad2"), grafo1.search("Ciudad7"));
		grafo1.connect(grafo1.search("Ciudad3"), grafo1.search("Ciudad2"));
		grafo1.connect(grafo1.search("Ciudad3"), grafo1.search("Ciudad4"));
		grafo1.connect(grafo1.search("Ciudad3"), grafo1.search("Ciudad5"));
		grafo1.connect(grafo1.search("Ciudad4"), grafo1.search("Ciudad0"));
		grafo1.connect(grafo1.search("Ciudad4"), grafo1.search("Ciudad3"));
		grafo1.connect(grafo1.search("Ciudad8"), grafo1.search("Ciudad0"));
		grafo1.connect(grafo1.search("Ciudad5"), grafo1.search("Ciudad3"));
		grafo1.connect(grafo1.search("Ciudad5"), grafo1.search("Ciudad6"));
		grafo1.connect(grafo1.search("Ciudad6"), grafo1.search("Ciudad5"));
		grafo1.connect(grafo1.search("Ciudad6"), grafo1.search("Ciudad7"));
		grafo1.connect(grafo1.search("Ciudad7"), grafo1.search("Ciudad2"));
		grafo1.connect(grafo1.search("Ciudad7"), grafo1.search("Ciudad6"));

		List<String> prohibidas = new LinkedList<String>();
		prohibidas.add("Ciudad4");
		prohibidas.add("Ciudad5");
		prohibidas.add("Ciudad6");
		System.out.println("-------------------------------------------");
		Mapa<String> test2 = new Mapa<String>(grafo1);
		/*
		List<String> lis2 = test2.devolverCaminoExeptuando("Ciudad0", "Ciudad7", prohibidas);
		for(String i: lis2) {
			System.out.println(i);
		}
		System.out.println("-------------------------------------------");
		*/
		List<String> lis1 = test2.caminoMasCorto("Ciudad0", "Ciudad7");
		for(String i: lis1) {
			System.out.println(i);
		}
		//System.out.println(grafo1.getVertex(0)==grafo1.getVertex(1));
		//System.out.println((grafo1.belongs(grafo1.search("Nivel_0"))&&grafo1.belongs(grafo1.search("Nivel_1A"))));

		/*
		VertexAdjList<String> v = (VertexAdjList<String>) grafo1.getVertex(0);
		List<Edge<String>> aristas = v.getEdges();
		Edge<String> arista0 = aristas.get(1);
		//System.out.println(arista0.getTarget().getData());
		//System.out.println(grafo1.search("Nivel_2CB").getPosition());
		grafo1.removeVertex(v);
		System.out.println(grafo1.getVertex(0).getData());
		*/
		System.out.println("-------------------------------------------");
		
		
	}

}
