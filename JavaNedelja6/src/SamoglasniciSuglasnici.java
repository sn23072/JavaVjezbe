import java.util.Scanner;

public class SamoglasniciSuglasnici {

	private static boolean jeSamoglasnik(char c) {
		c = Character.toLowerCase(c);

		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	public static void main(String[] args) {

			Scanner unos = new Scanner(System.in);
			System.out.println("Unesi neku recenicu: ");
			String recenica = unos.nextLine();

			int brojSamoglasnika = 0;
			int brojSlova = 0;

			for (int i = 0; i < recenica.length(); i++) {
				char c = recenica.charAt(i);
				// abstraktna klasa je klasa iz koje ne mozemo da napraviko instancu
				if (Character.isLetter(c)) {
					brojSlova++;
					if (jeSamoglasnik(c)) {
						brojSamoglasnika++;
					}
				}
			}
			System.out.println("Broj samoglasnika je: " + brojSamoglasnika);
			System.out.println("Broj suglasnika je: " + (brojSlova - brojSamoglasnika));
		

	}

}