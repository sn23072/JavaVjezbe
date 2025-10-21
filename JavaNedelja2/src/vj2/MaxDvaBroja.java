package vj2;

import java.util.Scanner;

public class MaxDvaBroja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesi prvi broj");
	//	float prviBroj;
		float prviBroj = unos.nextFloat();
	
		System.out.println("Unesi drugi broj");
	//	float drugiBroj;
		float drugiBroj = unos.nextFloat();
		
		if(prviBroj > drugiBroj) {
			System.out.println("Prvi broj je veci od drugog.");
		}else if(prviBroj == drugiBroj) {
			System.out.println("Brojevi su jednaki.");
		}
		else {
			System.out.println("Drugi broj je veci od prvog.");
		}
	}

}
