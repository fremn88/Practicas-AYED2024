package tp1.ej8;

public class TestCircularQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueue<String> q1 = new CircularQueue<String>();
		q1.enqueue("a");
		q1.enqueue("b");
		q1.enqueue("c");
		while(!q1.isEmpty()) {
			System.out.println(q1.dequeue());
		}
		System.out.println("--------------------");
		q1.enqueue("a");
		q1.enqueue("b");
		q1.enqueue("c");
		System.out.println(q1.head());
		System.out.println("--------------------");
		System.out.println(q1.size());
		System.out.println("--------------------");
		System.out.println(q1.toString());
		System.out.println("--------------------");
		q1.shift();
		System.out.println("--------------------");
		System.out.println(q1.toString());
	}

}
