package tp1.ej7;
import tp1.ej3.*;
import java.util.*;
public class IncisoD {
	
	public static boolean existeEstudiante(ArrayList<Estudiante> arr, Estudiante e1) {
		boolean existe = false;
		for(int i=0;i<arr.size();i++){
			if(e1.equals(arr.get(i))) {
				existe = true;
			}
		}
		return existe;
	}
	
	public static boolean esCapicua(ArrayList<Integer> arr) {
		boolean resul = false;
		//Caso base
		if(arr.size()==0 || arr.size()==1) {
			resul = true;
		} 
		//Caso recursivo
		else if(arr.get(0).equals(arr.get(arr.size()-1))) {
			arr.remove(0);
			arr.remove(arr.size()-1);
			if(arr.size()==0 || arr.size()==1) {
				resul = true;
			} else {esCapicua(arr);}
		}
		return resul;
	}
	
	
	public static boolean esKapicua(ArrayList<Integer> lista) {
        int posi = 0;
        int posj = lista.size() - 1;
        boolean result = true; 
        while (posi < posj) { 
            if (!lista.get(posi).equals(lista.get(posj))) { 
                result = false; 
                break; 
            }
            posi++; 
            posj--;
        }
        return result;
	}
	/*
	public static void metodo7d(ArrayList<Estudiante> ListaOriginal) {
		//creo un estudiante
		Estudiante e4 = new Estudiante("alejandro", "Garcia");
		//verifico que un estudiante no existe en la lista y lo agrego, mediante metodo de instancia "equals" (sobreescrito) y el metodo de clase
		//"existe estudiante" de esta clase
		System.out.println(existeEstudiante(ListaOriginal,e4));
		if(!existeEstudiante(ListaOriginal,e4)) {
			ListaOriginal.add(e4);
		}
		//imprime para verificar
		for(int i=0;i<ListaOriginal.size();i++){
			System.out.println(ListaOriginal.get(i).tusDatos());
		}
	}
	*/
	public static void main(String[] args) {
		//crea lista con 3 estudiantes leido de  teclado		
		/*
		Scanner s = new Scanner(System.in);
		ArrayList<Estudiante> ListaOriginal = new ArrayList<Estudiante>();
		Estudiante e1 = new Estudiante("Alejandro","Garcia");
		Estudiante e2 = new Estudiante("Pedro","Ramirez");
		Estudiante e3 = new Estudiante("Mora","Puricelli");

		ListaOriginal.add(e1);
		ListaOriginal.add(e2);
		ListaOriginal.add(e3);
		*/
		/*
		for(int i=0;i<3;i++) {
			Estudiante e = new Estudiante();
			System.out.println("Ingrese nombre");
			e.setNombre(s.nextLine());
			System.out.println("Ingrese apellido");
			e.setApellido(s.nextLine());
			ListaOriginal.add(e);
		}
		*/
		/*
		//copia lista
		ArrayList<Estudiante> ListaCopia = new ArrayList<Estudiante>();
		ListaCopia = (ArrayList<Estudiante>) ListaOriginal.clone();
		
		//imprime
		int index = 0;
		System.out.println("ListaOriginal");
		while(ListaOriginal.size()>index) {
			System.out.println(ListaOriginal.get(index++).tusDatos());
		}
		System.out.println("ListaCopia");
		int indexx = 0;
		while(ListaCopia.size()>indexx) {
			System.out.println(ListaCopia.get(indexx++).tusDatos());
		}
		*/
		/*
		//Remueve
		System.out.println("Removiendo..");
		ListaCopia.remove(2);
		
		//imprime para verificar
		for(int i=0;i<ListaOriginal.size();i++){
			System.out.println(ListaOriginal.get(i).tusDatos());
		}
		for(int i=0;i<ListaCopia.size();i++){
			System.out.println(ListaCopia.get(i).tusDatos());
		}
		*/
		
		//creo un estudiante
		//IncisoD.metodo7d(ListaOriginal);
		
		//Test 7f
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese numeros: ");
		arr.add(s.nextInt());
		arr.add(s.nextInt());
		arr.add(s.nextInt());		
		System.out.println(esKapicua(arr));
	}

}
