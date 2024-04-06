package tp1.ej8;
public class TestQueue {

	public static void main(String[] args) {
		Queue<String> q1 = new Queue<String>();
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
		
	}

}
