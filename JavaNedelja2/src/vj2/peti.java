package vj2;

import java.util.Scanner;

public class peti {
	
	public static double distanca(double x1,double y1,double x2,double y2) {
		
		double dist = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		return dist;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Zamislite da se u ravni nalazi dron na poziciji(x,y). Na razlicitim koordinatama
		//(xi,yi) nalaze se paketi koje dron moze da pokupi.Za N paketa poznate su njihove koordinate
		//(xi,yi).Potrebno je izracunati ukupnu udaljenost koju bi dron morao da predje do baze (x,y)
		//do tih paketa(zbir svih udaljenosti), ali samo za pakete koji se nalaze u prvom kvadrantu(sjeveroisticna strana grada).
		//Napomena: dron uvijek krece od pozicije (x,y)
	
		Scanner unos = new Scanner(System.in);
		
			System.out.println("Broj paketa");
			int n = unos.nextInt();
			
			System.out.println("Pocetna kordinata");
			double x = unos.nextDouble();
			double y = unos.nextDouble();
			
			double uDistanca = 0;
			for(int i =1;i<=n;i++) {
				
				System.out.println("Koordinate paketa "+i);
				double x1 = unos.nextDouble();
				double y1 = unos.nextDouble();
				if(x1>=0 && y1>=0) {
					double dist = distanca(x, y, x1, y1);
					uDistanca+=2*dist;
				}
		}
		
		System.out.println(uDistanca);
		}
		
	}


