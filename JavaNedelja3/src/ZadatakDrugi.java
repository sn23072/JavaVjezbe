import java.util.Scanner;

public class ZadatakDrugi {

	    public static void main(String[] args) {
	        Scanner unos = new Scanner(System.in);

	        System.out.print("Unesite koordinate centra (cx cy): ");
	        double cx = unos.nextDouble();
	        double cy = unos.nextDouble();

	        System.out.print("Unesite unutrašnji poluprečnik R1: ");
	        double R1 = unos.nextDouble();

	        System.out.print("Unesite spoljašnji poluprečnik R2: ");
	        double R2 = unos.nextDouble();

	        System.out.print("Unesite broj trkača N: ");
	        int N = unos.nextInt();

	        int brojTrkacaUPrstenu = 0;
	        double maxUdaljenost = 0;
	        double najudaljenijiX = 0;
	        double najudaljenijiY = 0;

	        System.out.println("Unesite koordinate trkača (xi yi):");

	        for (int i = 0; i < N; i++) {
	            double xi = unos.nextDouble();
	            double yi = unos.nextDouble();

	            double rastojanje = Math.sqrt(Math.pow(xi - cx, 2) + Math.pow(yi - cy, 2));

	            if (rastojanje >= R1 && rastojanje <= R2 && yi >= cy) {
	                brojTrkacaUPrstenu++;
	            }

	            if (rastojanje > maxUdaljenost) {
	                maxUdaljenost = rastojanje;
	                najudaljenijiX = xi;
	                najudaljenijiY = yi;
	            }
	        }

	        //System.out.println(" ");
	        System.out.println("Broj trkača u prstenu i gornjoj poluravni: " + brojTrkacaUPrstenu);
	        System.out.printf("Najudaljeniji trkač: (%.2f, %.2f) udaljen %.2f od centra%n",
	                najudaljenijiX, najudaljenijiY, maxUdaljenost);
	    }
	}

