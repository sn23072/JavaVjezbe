package vj2;

import java.util.Scanner;

public class cetvrti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Na parkin ulazi N automobila. Za svaki auto unosi se broj sati. Cijena je 2e po satu
		//ali ako auto ostane duze od 5 sati, od sestog sata cijena je 1e.Program racuna ukuopnu zaradu
		
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesi broj automobila");
		int brojAutomobila = unos.nextInt();
		int cijena = 0;
		int ukupnaZarada = 0;
		int brojSati;
		
		for(int i = 0;i < brojAutomobila; i++) {
			System.out.println("Unesi broj sati");
			brojSati = unos.nextInt();
			if (brojSati<= 5) {
				cijena = brojSati*2;
			}else {
				cijena = 5 * 2 +(brojSati - 5);
			}
			ukupnaZarada += cijena;
		}
		
		System.out.println("Ukupna zarada parkinga je : " + ukupnaZarada);
		
	}

}
