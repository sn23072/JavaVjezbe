import java.util.Scanner;

public class zadatak4 {

	public static void main(String[] args) {

		// Napisati program koji za unijeti string S ( karakteri stringa cifre od 0-9)
		// enkriptuje na sljedeci nacin: ako je paran broj pretvara se u 0, a ako je
		// karakter neparan broj pretvara se u 1. Npr za s = '15023' rezulteta je 11001

		Scanner unos = new Scanner(System.in);
		System.out.print("Unesi string brojeva (0-9): ");
		String s = unos.next();

		for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cifra = Character.getNumericValue(c);

            if (cifra % 2 == 0) {
                enkriptovano += "0";
            } else {
                enkriptovano += "1";
            }
        }

        System.out.println("Enkriptovani string: " + enkriptovano);
    }
}