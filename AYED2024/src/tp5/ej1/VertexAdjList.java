package tp5.ej1;

import java.util.List;

public class VertexAdjList<T> implements Vertex<T> {
	private T data;
	private int position; //numeracion para el grafo.
	private List<Edge<T>> edges; //lista de aristas adyacentes. 
	
	public VertexAdjList(T data, int pos) {
		this.data=data;
		this.position=pos;
	}
	
	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return this.data;
	}

	@Override
	public void setData(T data) {
		// TODO Auto-generated method stub
		this.data=data;
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}
	
	public List<Edge<T>> getEdges(){
		return this.edges;
	}
	
	Edge<T> getEdge(Vertex<T> verticeDestino){
		//recibe un destino, obtiene la arista que apunta a ese dstino y la devuelve
		Edge<T> arista = null;
		for(Edge<T> i: this.edges) {
			if(i.getTarget()==verticeDestino) {
				arista = i;
			}
		}
		return arista;
	}
	
	void disconnect(Vertex<T> vertice) {
		//recibe un vertice destino, si existe arista la elimina de la lista "edges"
		Edge<T> arista = this.getEdge(vertice);
		if(arista!=null) {
			edges.remove(arista);
		}
	}
	
	void decrementPosition() {
		this.position--;
	}
	
	void connect(Vertex<T> destino) {
		//para el caso de grafo no pesado, uso el metodo con peso = 1
		this.connect(destino,1);
	}
	
	void connect(Vertex<T> destino, int weight) {
		//hago la conexion siempre y cuando esta no exista de forma preliminar.
		Edge<T> arista = this.getEdge(destino);
		if(arista == null) {
			this.edges.add(new EdgeAdjList<T>(destino,weight));
		}
	}

}
