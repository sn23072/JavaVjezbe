public class Zaposleni {
    private int id;
    private String ime;
    private String prezime;
    private double plataPoSatu;
    private int ukupanBrojSati; 

    public Zaposleni(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.plataPoSatu = plataPoSatu;
        this.ukupanBrojSati = ukupanBrojSati;
    }

    public int getId() { return id; }
    public String getIme() { return ime; }
    public String getPrezime() { return prezime; }
    public double getPlataPoSatu() { return plataPoSatu; }
    public int getUkupanBrojSati() { return ukupanBrojSati; }
    public void setUkupanBrojSati(int s) { this.ukupanBrojSati = s; }

    public double mjesecnaPlata() {
        return 4 * ukupanBrojSati * plataPoSatu;
    }

    public String tipZaposlenog() {
        return "Zaposleni";
    }

    @Override
    public String toString() {
        return id + " " + ime + " " + prezime + " (" + tipZaposlenog() + ")";
    }
}
