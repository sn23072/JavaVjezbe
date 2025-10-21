package vj2;

import java.util.Scanner;

public class prvi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner unos = new Scanner(System.in);
		System.out.println("Unesi stranicu a pravougaonika:");
		float a = unos.nextFloat();
		System.out.println("Unesi stranicu b pravougaonika:");
		float b = unos.nextFloat();
		
		float povrsinaPravougaonika = a*b;
		float obimPravougaonika = (2*a)+(2*b);
		
		System.out.println("Povrsina pravougaonika je: " + povrsinaPravougaonika);
		System.out.println("Obim pravougaonika je: " + obimPravougaonika);
		
	}

}
