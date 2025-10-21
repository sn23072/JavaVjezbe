import java.util.Scanner;
	public class ZadatakPrvi {
	

	    public static String Manhattan() {

	        Scanner unos = new Scanner(System.in);

	        System.out.print("Unesi broj katapulta: ");
	        int N = unos.nextInt();

	        System.out.print("Unesite maksimalnu distancu za domet: ");
	        int D = unos.nextInt();

	        System.out.print("Unesite health dvorca: ");
	        int HD = unos.nextInt();

	        System.out.print("Unesite napad katapulta: ");
	        int KA = unos.nextInt();

	        int brKatapultaIzDometa = 0; 

	        System.out.println("Unesite koordinate katapulta (x y): ");
	        for (int i = 0; i < N; i++) {
	            int xKatapulta = unos.nextInt();
	            int yKatapulta = unos.nextInt();

	            
	            int menhetnRastojanje = Math.abs(xKatapulta) + Math.abs(yKatapulta);

	            if (menhetnRastojanje <= D) {
	                brKatapultaIzDometa++;
	            }
	        }

	        System.out.println("Broj katapulta koji predstavljaju prijetnju: " + brKatapultaIzDometa);

	        if (brKatapultaIzDometa * KA >= HD) {
	            return "Dvorac je srusen";
	        } else {
	            return "Dvorac nije srusen";
	        }
	    }

	    public static void main(String[] args) {
	        
	        String rezultat = Manhattan();
	        System.out.println(rezultat);
	    }
	}


