import java.time.*;
import java.util.*;

public class TestZaposleni {
    public static void main(String[] args) {
        Restoran r = new Restoran("Bistro Kod Nasa", "Ulica 1, Podgorica", "12345678");

        Konobar k1 = new Konobar(1, "Marko", "Peric", 6.5, 40, 5);   // 40h/7d + 5h prekovremeno/7d
        Konobar k2 = new Konobar(2, "Ana", "Jovanovic", 6.0, 38, 0);
        Kuvar  ku1 = new Kuvar(3, "Ivana", "Nikolic", 8.5, 42);
        Menadzer m1 = new Menadzer(4, "Stefan", "Popovic", 10.0, 35, 200.0);
        Kuvar  ku2 = new Kuvar(5, "Milan", "Savic", 9.0, 40);

        r.dodajZaposlenog(k1);
        r.dodajZaposlenog(k2);
        r.dodajZaposlenog(ku1);
        r.dodajZaposlenog(m1);
        r.dodajZaposlenog(ku2);

        List<Smjena> smjene = new ArrayList<>();
        Smjena s1 = new Smjena(LocalDate.of(2025,1,3), LocalTime.of(8,0),  LocalTime.of(16,0), TipSmjene.JUTARNJA);
        s1.dodajZaposlenog(1); s1.dodajZaposlenog(3);

        Smjena s2 = new Smjena(LocalDate.of(2025,1,3), LocalTime.of(16,0), LocalTime.of(0,0),  TipSmjene.POPOPODNEVNA);
        s2.dodajZaposlenog(2); s2.dodajZaposlenog(5);

        Smjena s3 = new Smjena(LocalDate.of(2025,1,4), LocalTime.of(0,0),  LocalTime.of(8,0),  TipSmjene.NOCNA);
        s3.dodajZaposlenog(4);

        Smjena s4 = new Smjena(LocalDate.of(2025,1,10), LocalTime.of(8,0), LocalTime.of(16,0), TipSmjene.JUTARNJA);
        s4.dodajZaposlenog(1); s4.dodajZaposlenog(3);

        Smjena s5 = new Smjena(LocalDate.of(2025,1,17), LocalTime.of(16,0), LocalTime.of(0,0), TipSmjene.POPOPODNEVNA);
        s5.dodajZaposlenog(2); s5.dodajZaposlenog(5);

        smjene.addAll(Arrays.asList(s1,s2,s3,s4,s5));

        r.postaviSateIzSmjenaKaoNedeljne(smjene);

        int mjesec = 1, godina = 2025;
        List<ObracunPlate> obracuni = r.generisiObracun(mjesec, godina);

        System.out.println("\nOBRAČUN PLATA - " + String.format("%02d/%d", mjesec, godina));
        r.stampajTabeluObracuna(obracuni);

        // Ukupan trošak
        double total = r.ukupniTrosak(obracuni);
        System.out.printf("%nUkupni trošak plata: %.2f EUR%n", total);

        System.out.println("\nPretraga ID 3: " + r.pronadjiPoId(3));
        boolean uklonjen = r.ukloniZaposlenog(2);
        System.out.println("Uklonjen ID 2? " + uklonjen);
    }
}
