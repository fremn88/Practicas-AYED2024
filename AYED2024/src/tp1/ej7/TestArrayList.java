package tp1.ej7;
import java.util.*;
public class TestArrayList {

	public static void main(String[] args) {
		//ArrayList
		/*
		ArrayList<Integer> arr = new ArrayList(); // ArrayList es una lista de objetos, por lo que no soporta tipos primitivos, pero si wrappers.
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un numeros: ");
		for(int i=0;i<3;i++) {
			arr.add(s.nextInt());
		}
		System.out.println("Ha ingresado los numeros: ");
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i));
		}
		*/
		//LinkedList: implementa la interface "List" al igual que ArrayList, es decir posee los mismos metodos.
		/*
		LinkedList<Integer> arr = new LinkedList();
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un numeros: ");
		for(int i=0;i<3;i++) {
			arr.add(s.nextInt());
		}
		System.out.println("Ha ingresado los numeros: ");
		for(int i=0;i<arr.size();i++){
			System.out.println(arr.get(i));
		}
		*/
		//Conclusion: dependiendo de lo que necesite hacer, se elije uno o el otro, pero en este caso daria igual cualquiera de los dos.
		
		//Alternativas para recorrerlo
		/*
		ArrayList<Integer> arr = new ArrayList(); // ArrayList es una lista de objetos, por lo que no soporta tipos primitivos, pero si wrappers.
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un numeros: ");
		for(int i=0;i<3;i++) {
			arr.add(s.nextInt());
		}
		
		System.out.println("Ha ingresado los numeros: ");
		/*
		for(Integer i : arr){
			System.out.println(i);
		}
		*/
		/*
		int index = 0;
		while(arr.size()>index) {
			System.out.println(arr.get(index++)); // index++, el "++" a la derecha indica que primero se opera la funcion get, por ultimo se incrementa index en 1.
		}
		*/
		/*
		Iterator it = arr.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		*/
	}

}
