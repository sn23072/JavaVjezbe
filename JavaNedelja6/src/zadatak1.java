import java.util.Scanner;

public class zadatak1 {

	public static void main(String[] args) {

		Scanner unos = new Scanner(System.in);
		System.out.println("Unesi neku recenicu: ");
		String recenica = unos.nextLine();

		// za space moze i (\s)
		String[] rijeci = recenica.split(" ");

		int brojRijeci = rijeci.length;

		System.out.println("Recenica ima: " + brojRijeci + " rijeci");

	}

}
