package tp5.test;

import tp5.ej1.GraphAdjList;
import tp5.ej5.Persona;

public class GrafosTp5Ej5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona uno = new Persona(false,"pepe","calle 4 num 189");
		Persona dos = new Persona(true,"pipi","calle 4 num 189");
		GraphAdjList<Persona> grafo1 = new GraphAdjList<Persona>();
		grafo1.createVertex(uno);
		grafo1.createVertex(dos);
		System.out.println(grafo1.search(uno).getData().getEsEmpleado());
		
	}

}
