package tp4.ej1;

import java.util.LinkedList;
import java.util.List;

public class GraphAdjList<T> implements Graph<T> {
	
	private LinkedList<VertexAdjList<T>> vertices;

	@Override
	public Vertex<T> createVertex(T data) {
		// TODO Auto-generated method stub
		int newPos = this.vertices.size(); //obtengo la posicion para guardarla como dato en vertice. Esta resulta del tamaño de la lista de verticves del grafo al momento de crear el vertice.
		VertexAdjList<T> vertex= new VertexAdjList<T>(data,newPos);
		this.vertices.add(vertex);
		return vertex;
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		// TODO Auto-generated method stub
		int posVert = vertices.indexOf(vertex); //verifica existencia de vertex en lista, si no existe dev -1.
		if(posVert>-1) {
			vertices.remove(vertex);
			//corrimiento?
		}
		//con el vertice removido, se deben reposicionar los vertices desde la posicion eliminada, decrementando en 1 hasta el fin de la lista.
		//se deben eliminar todas las aristas que apunten al vertice eliminado
	}

	@Override
	public Vertex<T> search(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		//tomo vertice origen, obtengo lista de aristas
		
		//para cada arista, obtengo el target
		//si el target es == destination, se setea el target del vetice en null
		
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		//outcast ????
		((VertexAdjList<T>)origin).desconectar(destination);
	}

	@Override
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Vertex<T>> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int weight(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Vertex<T> getVertex(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Edge<T>> getEdges(Vertex<T> v) {
		// TODO Auto-generated method stub
		return null;
	}

}
