package tp1.ej3;

public class Test {

	public static void main(String[] args) {
		Estudiante[] vectorE = new Estudiante[2];
		Estudiante E1 = new Estudiante();
		E1.setNombre("Ricardo");
		E1.setApellido("Garcia");
		Estudiante E2 = new Estudiante();
		E2.setNombre("Ricardo");
		E2.setApellido("Garcia");
		vectorE[0] = E1;
		vectorE[1] = E2;
		for (int i = 0; i < vectorE.length; i++) {
			System.out.println(vectorE[i].tusDatos());
		}
		System.out.println(E1.equals(E2));
	}

}
