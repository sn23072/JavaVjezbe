import java.util.*;
import java.util.stream.Collectors;

public class Restoran {
    private String naziv;
    private String adresa;
    private String pib;
    private List<Zaposleni> zaposleni = new ArrayList<>();

    public Restoran(String naziv, String adresa, String pib) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = pib;
    }

    public void dodajZaposlenog(Zaposleni z) {
        if (pronadjiPoId(z.getId()) != null) {
            System.out.println("Zaposleni sa ID " + z.getId() + " već postoji!");
            return;
        }
        zaposleni.add(z);
    }

    public boolean ukloniZaposlenog(int id) {
        return zaposleni.removeIf(z -> z.getId() == id);
    }

    public Zaposleni pronadjiPoId(int id) {
        for (Zaposleni z : zaposleni) {
            if (z.getId() == id) return z;
        }
        return null;
    }

    public List<ObracunPlate> generisiObracun(int mjesec, int godina) {
        List<ObracunPlate> list = new ArrayList<>();
        for (Zaposleni z : zaposleni) {
            double iznos = z.mjesecnaPlata();
            String napomena = "";

            if (z instanceof Konobar) {
                Konobar k = (Konobar) z;
                if (k.getPrekovremeniSatiNedeljno() > 0) {
                    napomena = "uračunat prekovremeni rad: +" + (k.getPrekovremeniSatiNedeljno()*4) + "h (20%)";
                }
            } else if (z instanceof Menadzer) {
                Menadzer m = (Menadzer) z;
                napomena = "bonus: " + String.format("%.2f EUR", m.getBonus());
            } else if (z instanceof Kuvar) {
                napomena = "fiksni dodatak: 1500 EUR";
            }

            list.add(new ObracunPlate(mjesec, godina, z, iznos, napomena));
        }
        return list;
    }

    public void stampajTabeluObracuna(List<ObracunPlate> obracuni) {
        String header = String.format("%-6s %-15s %-15s %-12s %-10s %-20s %-12s",
                "ID", "Ime", "Prezime", "Tip", "Sati/7d", "Dodaci", "Plata(EUR)");
        System.out.println(header);

        for (ObracunPlate o : obracuni) {
            Zaposleni z = o.getZaposleni();
            String dodaci = "";
            if (z instanceof Konobar) {
                Konobar k = (Konobar) z;
                dodaci = "Prekovrem.: " + (k.getPrekovremeniSatiNedeljno()*4) + "h (+20%)";
            } else if (z instanceof Menadzer) {
                Menadzer m = (Menadzer) z;
                dodaci = "Bonus: " + String.format("%.2f", m.getBonus());
            } else if (z instanceof Kuvar) {
                dodaci = "Fiksni: 1500";
            }

            System.out.printf("%-6d %-15s %-15s %-12s %-10d %-20s %-12.2f%n",
                    z.getId(), z.getIme(), z.getPrezime(), z.tipZaposlenog(),
                    z.getUkupanBrojSati(), dodaci, o.getIznos());
        }
    }

    public double ukupniTrosak(List<ObracunPlate> obracuni) {
        double sum = 0;
        for (ObracunPlate o : obracuni) sum += o.getIznos();
        return sum;
    }

    public List<Zaposleni> getZaposleni() {
        return zaposleni;
    }

    public static Map<Integer, Integer> satiIzSmjena(List<Smjena> smjene) {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (Smjena s : smjene) {
            int h = s.trajanjeUSatima();
            for (int id : s.getZaposleniIds()) {
                mapa.put(id, mapa.getOrDefault(id, 0) + h);
            }
        }
        return mapa;
    }

    public void postaviSateIzSmjenaKaoNedeljne(List<Smjena> smjene) {
        Map<Integer, Integer> mapa = satiIzSmjena(smjene);
        for (Zaposleni z : zaposleni) {
            if (mapa.containsKey(z.getId())) {
                int mjesecni = mapa.get(z.getId());
                int nedeljni = Math.max(0, mjesecni / 4);
                z.setUkupanBrojSati(nedeljni);
            }
        }
    }
}
