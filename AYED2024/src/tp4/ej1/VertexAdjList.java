package tp4.ej1;

import java.util.LinkedList;

public class VertexAdjList<T> implements Vertex<T> {
	private T data;
	private int position; //numeracion para el grafo.
	private LinkedList<Edge<T>> edges; //lista de aristas adyacentes. 
	
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
	
	public Edge<T> getEdge(Vertex<T> verticeDestino){
		//recibe un destino, obtiene la arista que apunta a ese dstino y la devuelve
		Edge<T> arista = null;
		for(Edge<T> i: this.edges) {
			if(i.getTarget()==verticeDestino) {
				arista = i;
			}
		}
		return arista;
	}
	
	public void desconectar(Vertex<T> vertice) {
		//recibe un vertice destino, elimina de la lista "edges" la arista con dicho destino
		Edge<T> arista = this.getEdge(vertice);
		if(arista!=null) {
			edges.remove(arista);
		}
	}
		

}
