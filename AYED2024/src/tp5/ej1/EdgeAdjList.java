package tp5.ej1;

public class EdgeAdjList<T> implements Edge<T> {
	private Vertex<T> target;
	private int weight;
	
	public EdgeAdjList() {
		
	}
	
	public EdgeAdjList(Vertex<T> vertex, int weight) {
		this.target=vertex;
		this.weight=weight;
	}
	
	@Override
	public Vertex<T> getTarget() {
		// TODO Auto-generated method stub
		return this.target;
	}
	
	public void setTarget(Vertex<T> target) {
		this.target=target;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

}
