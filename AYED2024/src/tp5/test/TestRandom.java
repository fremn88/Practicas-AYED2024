package tp5.test;

public class TestRandom {
	    public static void main(String[] args) {
	        int[] numero = new int[1];
	        numero[0] = 5;
	        incrementarNumero(numero);
	        System.out.println("El valor de numero después de llamar a incrementarNumero: " + numero[0]);
	    }

	    public static void incrementarNumero(int[] n) {
	        n[0]++;
	        System.out.println("El valor de n dentro de la función incrementarNumero: " + n[0]);
	    }
}
