package vj2;

import java.util.Scanner;

public class drugi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesi koordinate donje desne ivice zida: ");
		float x1 = unos.nextFloat();
		float y1 = unos.nextFloat();
		
		System.out.println("Unesi koordinate gornje lijeve ivice zida: ");
		float x2 = unos.nextFloat();
		float y2 = unos.nextFloat();
		
		float a = x2-x1;
		float b = y2-y1;
		
		float povrsinaZida = a*b;
		float obimZida = (2*a) + (2*b);
		
		System.out.println("Povrsina zida je: " + povrsinaZida);
		System.out.println("Obim zida je: " + obimZida);
		
		
	}

}
