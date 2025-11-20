import java.util.ArrayList;

public class TestVozilo {
    public static void main(String[] args) {

        ArrayList<Vozilo> vozila = new ArrayList<>();

        vozila.add(new Biciklo("B923hka1", 20));
        vozila.add(new Motor("M2324hl21", 80));
        vozila.add(new Automobil("A23lb2l1", 280));

        double udaljenost = 10; 

        System.out.println("Računanje dostave za " + udaljenost + " km \n");

        for (Vozilo v : vozila) {
            v.info();
            double vrijeme = v.izracunajVrijemeDostave(udaljenost);

            System.out.println("Vrijeme dostave: " + vrijeme + " h");

            if (v instanceof Ekonomican) {
                Ekonomican e = (Ekonomican) v;
                double potrosnja = e.potrosnjaPoKm() * udaljenost;
                System.out.println("Potrošnja na " + udaljenost + " km: " + potrosnja + "\n");
            }


        }

    
        System.out.println("Bicikl je najsporiji, ali bez potrošnje.");
        System.out.println("Motor je brži od bicikla, mala potrošnja.");
        System.out.println("Automobil je najbrži, ali troši više i nije ekonomičan.");
    }
}
