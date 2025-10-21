package vj2;

import java.util.Scanner;

public class treci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesi koordinate hrasta: ");
		float x1 = unos.nextFloat();
		float y1 = unos.nextFloat();
		
		System.out.println("Unesi koordinate kuce: ");
		float x2 = unos.nextFloat();
		float y2 = unos.nextFloat();
		
		float a = x2-x1;
		float b = y2-y1;
		
		float dKvadrat = (a*a)+ (b*b);
		
		float blago = (float) Math.sqrt(dKvadrat);
		
		System.out.println("Koordinate blaga su: " + blago);
		
	}

}
