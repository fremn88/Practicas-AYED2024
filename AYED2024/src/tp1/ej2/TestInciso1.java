package tp1.ej2;
import java.util.Scanner;

public class TestInciso1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		if(n>0) {
			int[] Test = Inciso1.multiplos(n);
			for(int i=0;i<Test.length;i++) {
				System.out.println(Test[i]);
			}
		}
	}
}
