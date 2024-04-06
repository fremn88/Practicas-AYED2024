package tp1.ej7;

import java.util.*;

public class TestEj7i {

	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    LinkedList<Integer> lista = new LinkedList<Integer>();
		for(int i=0;i<3;i++) {
			lista.add(s.nextInt());
		}
		for(Integer i: lista) {
			System.out.println(i);
		}
		Ej7i obj = new Ej7i();
		int result = obj.sumarLinkedList(lista);
		System.out.println(result);
	}
}
