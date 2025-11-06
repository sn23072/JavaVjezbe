import java.util.*;
public class EProizvodTest {

	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        List<EProizvod> proizvodi = new ArrayList<>();
	        int izbor;

	        do {
	            System.out.println("\n1. Unos uređaja");
	            System.out.println("2. Prikaz svih uređaja");
	            System.out.println("3. Prikaz uređaja po tipu");
	            System.out.println("0. Izlaz");
	            System.out.print("Odaberite opciju: ");
	            izbor = ucitajInt(sc);

	            switch (izbor) {
	                case 1 -> {
	                    System.out.print("Opis: ");
	                    String opis = sc.nextLine();
	                    System.out.print("Šifra (RA/TE/TV...): ");
	                    String sifra = sc.nextLine().toUpperCase();
	                    System.out.print("Uvozna cijena: ");
	                    double cijena = ucitajDouble(sc);

	                    if (sifra.startsWith("RA")) {
	                        System.out.print("Procesor: ");
	                        String cpu = sc.nextLine();
	                        System.out.print("Memorija : ");
	                        int ram = ucitajInt(sc);
	                        proizvodi.add(new Racunari(opis, sifra, cijena, cpu, ram));
	                    } else if (sifra.startsWith("TE")) {
	                        System.out.print("OS: ");
	                        String os = sc.nextLine();
	                        System.out.print("Ekran : ");
	                        double ekran = ucitajDouble(sc);
	                        proizvodi.add(new Telefoni(opis, sifra, cijena, os, ekran));
	                    } else if (sifra.startsWith("TV")) {
	                        System.out.print("Ekran (inči): ");
	                        double ekran = ucitajDouble(sc);
	                        proizvodi.add(new TV(opis, sifra, cijena, ekran));
	                    } else {
	                        System.out.println("Nepoznata šifra!");
	                    }
	                }

	                case 2 -> {
	                    if (proizvodi.isEmpty()) System.out.println("Nema unosa.");
	                    else proizvodi.forEach(System.out::println);
	                }

	                case 3 -> {
	                    System.out.print("Unesite tip (RA/TE/TV): ");
	                    String tip = sc.nextLine().toUpperCase();
	                    EProizvod[] arr = proizvodi.toArray(new EProizvod[0]);
	                    for (EProizvod p : EProizvod.filtrirajPoTipu(arr, tip))
	                        System.out.println(p);
	                }

	                case 0 -> System.out.println("Kraj programa.");
	                default -> System.out.println("Pogrešan izbor");
	            }
	        } while (izbor != 0);
	    }

	    private static double ucitajDouble(Scanner sc) {
	        while (true) {
	            try { return Double.parseDouble(sc.nextLine().replace(',', '.')); }
	            catch (Exception e) { System.out.print("Pogrešan format! Ponovo: "); }
	        }
	    }

	    private static int ucitajInt(Scanner sc) {
	        while (true) {
	            try { return Integer.parseInt(sc.nextLine()); }
	            catch (Exception e) { System.out.print("Pogrešan format! Ponovo: "); }
	        }
	    }
	
}