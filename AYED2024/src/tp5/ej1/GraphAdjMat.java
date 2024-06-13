package tp5.ej1;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMat<T> implements Graph<T> {
	
	private static final int Empty_Value = 0; // static: valor unico para la clase; es el mismo para todas las instancias
	// final: una vez declarado, no se puede modificar mas adelante
	private int maxVertices;
	private List<VertexAdjMat<T>> vertices;
	private int [][] adjMat;
	
	//Constructor: recibe el numero maximo de vertices a utilizar, e iniicaliza la matriz de adyacencia
	public GraphAdjMat(int maxVert){
		//inicializo parametros
		maxVertices = maxVert;
		vertices = new ArrayList<>();
		adjMat = new int[maxVertices][maxVertices];
		//inicializo matriz en valor 0
		for(int i=0; i<maxVertices;i++) {
			for(int j=0; j<maxVertices;j++) {
				adjMat[i][j]= Empty_Value;
				}
			}
		}
	
	@Override
	public Vertex<T> createVertex(T data) {
		// TODO Auto-generated method stub
		int newPos = this.vertices.size(); //obtengo la posicion para guardarla como dato en vertice. Esta resulta del tamaño de la lista de verticves del grafo al momento de crear el vertice.
		VertexAdjMat<T> vertex= new VertexAdjMat<T>(data,newPos);
		this.vertices.add(vertex);
		return vertex;
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		// TODO Auto-generated method stub
		//si no existe el vertice, el metodo remove devuelve false y sale sin modificar nada.
		if(!this.vertices.remove(vertex)) {
			return;
		}
		//debo eliminar la fila de la matriz correspondiente al vertice removido, y tambien la columna.
		int indice = vertex.getPosition();
		int ultimo = this.vertices.size();
		//"piso" la fila con dato de la fila siguiente, se corren todas las filas.
		for(int fila=indice; fila<ultimo; fila++) {
			adjMat[fila]=adjMat[fila+1];
		}
		//elimino la columna, pisando los datos de las columnas siguientes, como antes
		for(int fila=0; fila<ultimo; fila++) {
			for(int col=indice; col<ultimo; col++) {
				adjMat[fila][col] = adjMat[fila][col+1];
			}
		}
		//se reasignan posiciones de los vertices en lista de vertices
		for(int fila=indice; fila<ultimo; fila++) {
			this.vertices.get(fila).decrementPosition();
		}
		//se setea en 0 la ultima fila
		for(int col=0; col<ultimo; col++) {
			adjMat[ultimo][col] = Empty_Value;
		}
		//se setea en 0 la ultima columna
		for(int fila=0; fila<ultimo; fila++) {
			adjMat[fila][ultimo] = Empty_Value;
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
	
	private boolean belongs(Vertex<T> vertex) {
		int pos = vertex.getPosition();
		return pos>=0 && pos<this.vertices.size() && this.vertices.get(pos)==vertex;
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		connect(origin,destination,1);
	}

	@Override
	public void connect(Vertex<T> origin, Vertex<T> destination, int weight) {
		// TODO Auto-generated method stub
		if(this.belongs(origin)&&this.belongs(destination)) {
			adjMat[((VertexAdjMat<T>)origin).getPosition()][((VertexAdjMat<T>)destination).getPosition()]=weight;
		}
		
	}

	@Override
	public void disconnect(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		if(this.belongs(origin)) {
			this.connect(origin,destination,Empty_Value);
		}
		
	}

	@Override
	public boolean existsEdge(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		return this.weight(origin, destination)!=Empty_Value;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.vertices.isEmpty();
	}

	@Override
	public List<Vertex<T>> getVertices() {
		// TODO Auto-generated method stub
		return new ArrayList<>(this.vertices);
	}

	@Override
	public int weight(Vertex<T> origin, Vertex<T> destination) {
		// TODO Auto-generated method stub
		int weight = Empty_Value;
		if(this.belongs(origin)&&this.belongs(destination)) {
			weight = adjMat[((VertexAdjMat<T>)origin).getPosition()][((VertexAdjMat<T>)destination).getPosition()];	
		}
		return weight;
	}

	@Override
	public List<Edge<T>> getEdges(Vertex<T> v) {
		// TODO Auto-generated method stub
		List<Edge<T>> edges = new ArrayList<Edge<T>>();
		if(this.belongs(v)) {
			int fila = v.getPosition();
			for(int i=0; i<this.vertices.size(); i++) {
				if(adjMat[fila][i]!=Empty_Value) {
					edges.add(new EdgeAdjMat<T>(this.vertices.get(fila),adjMat[fila][i]));
				}
			}
		}
		return edges;
	}

	@Override
	public Vertex<T> getVertex(int position) {
		// TODO Auto-generated method stub
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

}
