package tp5.ej1;

public class VertexAdjMat<T> implements Vertex<T> {
	private T data;
	private int position;
	
	public VertexAdjMat(T data, int pos) {
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
	
	void setPosition(int position) {
		this.position = position;
	}
	
	void decrementPosition() {
		this.position--;
	}
	
	

}
