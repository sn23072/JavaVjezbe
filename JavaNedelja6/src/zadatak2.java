import java.util.Scanner;

public class zadatak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Unesite recenicu koja sadrzi vise rijeci odvojenih prazninama i odrediti broj
		// rijeci.
		// Provjerite da li je umesena rijec palindrom

		Scanner unos = new Scanner(System.in);
		System.out.println("Unesi neku recenicu: ");
		String recenica = unos.nextLine();

		recenica = recenica.trim();

		// pretvara string builder u string to.string metodom
		// reverse okrece rijeci u recenici
		String okrenutTekst = new StringBuilder(recenica).reverse().toString();

		System.out.println(recenica.equalsIgnoreCase(okrenutTekst));

	}

}
