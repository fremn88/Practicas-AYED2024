package tp5.ej1;

import java.util.LinkedList;
import java.util.List;

public class GraphAdjList<T> implements Graph<T> {
	
	private List<VertexAdjList<T>> vertices;

	public void setVertices(List<VertexAdjList<T>> vertices) {
		this.vertices = vertices;
	}
	
	@Override
	public Vertex<T> createVertex(T data) {
		// TODO Auto-generated method stub
		int newPos = 0;
		if(vertices==null) {
			vertices = new LinkedList<VertexAdjList<T>>();
		} else {
			newPos = this.vertices.size(); //obtengo la posicion para guardarla como dato en vertice. Esta resulta del tamaño de la lista de verticves del grafo al momento de crear el vertice.
		}
		VertexAdjList<T> vertex= new VertexAdjList<T>(data,newPos);
		this.vertices.add(vertex);
		return vertex;
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		// TODO Auto-generated method stub
		//verifica existencia de vertex en lista (el mismo objeto)
		int position = vertex.getPosition();
		if(this.vertices.get(position)!=vertex) {
			return;
		}
		this.vertices.remove(vertex);
		//con el vertice removido, se deben reposicionar los vertices desde la posicion eliminada, decrementando en 1 hasta el fin de la lista.
		//evitamos usar una variable adicional trabajando con "position"
		for(;position<this.vertices.size();position++) {
			this.vertices.get(position).decrementPosition();
		}
		//luego quedan eliminar todas las aristas que apunten al vertice eliminado
		for(Vertex<T> origen: this.vertices) {
			this.disconnect(origen, vertex);
		}
	}

	@Override
	public Vertex<T> search(T data) {
		// TODO Auto-generated method stub
		for(Vertex<T> vertice: vertices) {
			if(vertice.getData().equals(data)) {
				return vertice;
			}
		}
		return null;
	}
	
	public boolean belongs(Vertex<T> vertex) {
		if(vertex!=null) {
			int pos = vertex.getPosition();
			return pos>=0 && pos<this.vertices.size() && this.vertices.get(pos)==vertex;
		} else return false;	
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		//chequeo que ambos vertices pertenezcan al grafo (que esten en lista de vertices adyacentes)
		//si pertenencen, llamo al metodo conectar del vertice origen
		if(this.belongs(origin)&&this.belongs(destination)) {
			((VertexAdjList<T>)origin).connect(destination);
		}
		
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		// TODO Auto-generated method stub
		if(this.belongs(origin)&&this.belongs(destination)) {
			((VertexAdjList<T>)origin).connect(destination,weight);
		}
		
		
	}

	@Override
	public void disconnect(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		if(this.belongs(origin)) {
			((VertexAdjList<T>)origin).disconnect(destination);
		}
	}

	@Override
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		return (((VertexAdjList<T>)origin).getEdge(destination)!=null);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.vertices.isEmpty();
	}

	@Override
	public List<Vertex<T>> getVertices() {
		// TODO Auto-generated method stub
		return new LinkedList<Vertex<T>>(this.vertices);
	}
	
	private Edge<T> edge(Vertex<T> origen, Vertex<T> destino){
		Edge<T> arista = null;
		if(this.belongs(origen)) {
			arista = ((VertexAdjList<T>)origen).getEdge(destino);
		}
		return arista;
	}
	
	@Override
	public int weight(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		int peso = 0;
		Edge<T> arista = this.edge(origin, destination);
		if(arista!=null) {
			peso = arista.getWeight();
		}
		return peso;
	}


	@Override
	public Vertex<T> getVertex(int position) {
		// TODO Auto-generated method stub
		//verificar que la posicion recibida es correcta
		if(position<0||position>=this.vertices.size()) {
			return null;
		}
		return this.vertices.get(position);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.vertices.size();
	}

	@Override
	public List<Edge<T>> getEdges(Vertex<T> v) {
		// TODO Auto-generated method stub
		if(this.belongs(v)) {
			return ((VertexAdjList<T>)v).getEdges();
		}
		return null;
	}

}
