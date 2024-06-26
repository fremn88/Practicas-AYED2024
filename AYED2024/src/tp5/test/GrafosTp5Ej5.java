package tp5.test;

import java.util.LinkedList;
import java.util.List;

import tp5.ej1.GraphAdjList;
import tp5.ej5.Persona;
import tp5.ej5.QuedateEnCasa;

public class GrafosTp5Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjList<Persona> grafo1 = new GraphAdjList<Persona>();
		Persona p0 = new Persona(true,"p0","calle 4 num 189",false);
		Persona p1 = new Persona(false,"p1","calle 4 num 189",false);
		Persona p2 = new Persona(true,"p2","calle 4 num 189",false);
		Persona p3 = new Persona(false,"p3","calle 4 num 189",false);
		Persona p4 = new Persona(false,"p4","calle 4 num 189",false);
		Persona p5 = new Persona(false,"p5","calle 4 num 189",false);
		Persona p6 = new Persona(false,"p6","calle 4 num 189",false);
		Persona p7 = new Persona(false,"p7","calle 4 num 189",false);
		Persona p8 = new Persona(false,"p8","calle 4 num 189",false);
		Persona p9 = new Persona(false,"p9","calle 4 num 189",false);
		Persona p10 = new Persona(false,"p10","calle 4 num 189",false);
		Persona p11 = new Persona(false,"p11","calle 4 num 189",false);
		Persona p12 = new Persona(false,"p12","calle 4 num 189",false);
		Persona p13 = new Persona(false,"p13","calle 4 num 189",false);
		Persona p14 = new Persona(false,"p14","calle 4 num 189",false);
		
		grafo1.createVertex(p0);
		grafo1.createVertex(p1);
		grafo1.createVertex(p2);
		grafo1.createVertex(p3);
		grafo1.createVertex(p4);
		grafo1.createVertex(p5);
		grafo1.createVertex(p6);
		grafo1.createVertex(p7);
		grafo1.createVertex(p8);
		grafo1.createVertex(p9);
		grafo1.createVertex(p10);
		grafo1.createVertex(p11);
		grafo1.createVertex(p12);
		grafo1.createVertex(p13);
		grafo1.createVertex(p14);
		
		grafo1.connect(grafo1.search(p0), grafo1.search(p1));
		grafo1.connect(grafo1.search(p0), grafo1.search(p2));
		grafo1.connect(grafo1.search(p0), grafo1.search(p3));
		grafo1.connect(grafo1.search(p0), grafo1.search(p4));
		grafo1.connect(grafo1.search(p0), grafo1.search(p5));
		grafo1.connect(grafo1.search(p1), grafo1.search(p0));
		grafo1.connect(grafo1.search(p1), grafo1.search(p6));
		grafo1.connect(grafo1.search(p2), grafo1.search(p0));
		grafo1.connect(grafo1.search(p2), grafo1.search(p7));
		grafo1.connect(grafo1.search(p3), grafo1.search(p0));
		grafo1.connect(grafo1.search(p3), grafo1.search(p8));
		grafo1.connect(grafo1.search(p4), grafo1.search(p0));
		grafo1.connect(grafo1.search(p5), grafo1.search(p0));
		grafo1.connect(grafo1.search(p5), grafo1.search(p9));
		grafo1.connect(grafo1.search(p6), grafo1.search(p1));
		grafo1.connect(grafo1.search(p6), grafo1.search(p10));
		grafo1.connect(grafo1.search(p7), grafo1.search(p2));
		grafo1.connect(grafo1.search(p7), grafo1.search(p11));
		grafo1.connect(grafo1.search(p8), grafo1.search(p3));
		grafo1.connect(grafo1.search(p8), grafo1.search(p12));
		grafo1.connect(grafo1.search(p9), grafo1.search(p5));
		grafo1.connect(grafo1.search(p10), grafo1.search(p6));
		grafo1.connect(grafo1.search(p10), grafo1.search(p13));
		grafo1.connect(grafo1.search(p11), grafo1.search(p7));
		grafo1.connect(grafo1.search(p11), grafo1.search(p13));
		grafo1.connect(grafo1.search(p12), grafo1.search(p8));
		grafo1.connect(grafo1.search(p13), grafo1.search(p10));
		grafo1.connect(grafo1.search(p13), grafo1.search(p11));
		grafo1.connect(grafo1.search(p13), grafo1.search(p14));		
		grafo1.connect(grafo1.search(p14), grafo1.search(p13));	
		
		List<Persona> lis = QuedateEnCasa.armarCartera(grafo1, 3, p0);
		for(Persona p: lis) {
			System.out.println(p.toString());
		};
	}

}
