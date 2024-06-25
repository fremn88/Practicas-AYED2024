package tp5.test;

import java.util.LinkedList;
import java.util.List;

import tp5.ej1.GraphAdjList;
import tp5.ej4.VisitaOslo;

public class GrafosTp5Ej4 {

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
		grafo1.createVertex("Ciudad9");
		grafo1.connect(grafo1.search("Ciudad0"), grafo1.search("Ciudad1"),1);
		grafo1.connect(grafo1.search("Ciudad0"), grafo1.search("Ciudad2"),8);
		grafo1.connect(grafo1.search("Ciudad0"), grafo1.search("Ciudad4"),5);
		grafo1.connect(grafo1.search("Ciudad0"), grafo1.search("Ciudad8"),80);
		grafo1.connect(grafo1.search("Ciudad1"), grafo1.search("Ciudad0"),1);
		grafo1.connect(grafo1.search("Ciudad1"), grafo1.search("Ciudad2"),80);
		grafo1.connect(grafo1.search("Ciudad1"), grafo1.search("Ciudad9"),1);
		grafo1.connect(grafo1.search("Ciudad2"), grafo1.search("Ciudad0"),8);
		grafo1.connect(grafo1.search("Ciudad2"), grafo1.search("Ciudad1"),80);
		grafo1.connect(grafo1.search("Ciudad2"), grafo1.search("Ciudad3"),3);
		grafo1.connect(grafo1.search("Ciudad2"), grafo1.search("Ciudad7"),50);
		grafo1.connect(grafo1.search("Ciudad2"), grafo1.search("Ciudad9"),1);
		grafo1.connect(grafo1.search("Ciudad3"), grafo1.search("Ciudad2"),3);
		grafo1.connect(grafo1.search("Ciudad3"), grafo1.search("Ciudad4"),2);
		grafo1.connect(grafo1.search("Ciudad3"), grafo1.search("Ciudad5"),5);
		grafo1.connect(grafo1.search("Ciudad3"), grafo1.search("Ciudad6"),1);
		grafo1.connect(grafo1.search("Ciudad4"), grafo1.search("Ciudad0"),5);
		grafo1.connect(grafo1.search("Ciudad4"), grafo1.search("Ciudad3"),2);
		grafo1.connect(grafo1.search("Ciudad4"), grafo1.search("Ciudad5"),1);
		grafo1.connect(grafo1.search("Ciudad8"), grafo1.search("Ciudad0"),80);
		grafo1.connect(grafo1.search("Ciudad5"), grafo1.search("Ciudad3"),5);
		grafo1.connect(grafo1.search("Ciudad5"), grafo1.search("Ciudad4"),1);
		grafo1.connect(grafo1.search("Ciudad5"), grafo1.search("Ciudad6"),2);
		grafo1.connect(grafo1.search("Ciudad6"), grafo1.search("Ciudad3"),1);
		grafo1.connect(grafo1.search("Ciudad6"), grafo1.search("Ciudad5"),2);
		grafo1.connect(grafo1.search("Ciudad6"), grafo1.search("Ciudad7"),4);
		grafo1.connect(grafo1.search("Ciudad7"), grafo1.search("Ciudad2"),50);
		grafo1.connect(grafo1.search("Ciudad7"), grafo1.search("Ciudad6"),4);
		grafo1.connect(grafo1.search("Ciudad7"), grafo1.search("Ciudad9"),1);
		grafo1.connect(grafo1.search("Ciudad9"), grafo1.search("Ciudad1"),1);
		grafo1.connect(grafo1.search("Ciudad9"), grafo1.search("Ciudad2"),1);
		grafo1.connect(grafo1.search("Ciudad9"), grafo1.search("Ciudad7"),1);
		
		List<String> lis = new LinkedList<String>();
		//lis.add("Ciudad2");
		lis.add("Ciudad3");
		lis.add("Ciudad9");
		List<String> resul = VisitaOslo.paseoEnBici(grafo1, "Ciudad7", 131, lis);
		for(String i: resul) {
			System.out.println(i);
		}
	}

}
