package tp1.ej7;
import java.util.*;
public class Ej7i {
	public int sumarLinkedList(LinkedList<Integer> lista) {
		int val = 0;
		if(lista == null || lista.isEmpty()) {
			return val;
		} else {
			val = lista.remove(0);
			return val+sumarLinkedList(lista);
		}
		
	}
}
