import java.util.Scanner;

public class SortiranjeNizova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner unos = new Scanner(System.in);
		System.out.println("Unesi dužinu niza :");
		int velicinaNiza = unos.nextInt();
		int [] brojevi = new int[velicinaNiza];
		
		for (int i = 0; i < brojevi.length; i ++) {
			System.out.println("Unesite " + (i + 1) + ". element niza: " );
			brojevi[i] = unos.nextInt();
			
		}
		
		for(int i = 0; i < brojevi.length - 1; i ++) {
			for( int j = 0; j < brojevi.length - i - 1; j ++) {
				if(brojevi[j] > brojevi[j+1]) {
					int temp = brojevi[j];
					brojevi[j] = brojevi[j+1];
					brojevi[j+1] = temp;
				}
				
			}
			
		}
		
		for(int x: brojevi) {
			System.out.println(x);
		}
	}

}
