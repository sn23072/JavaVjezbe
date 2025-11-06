public class Konobar extends Zaposleni {
    private int prekovremeniSatiNedeljno; 

    public Konobar(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati,
                   int prekovremeniSatiNedeljno) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.prekovremeniSatiNedeljno = prekovremeniSatiNedeljno;
    }

    public int getPrekovremeniSatiNedeljno() { return prekovremeniSatiNedeljno; }
    public void setPrekovremeniSatiNedeljno(int s) { this.prekovremeniSatiNedeljno = s; }

    @Override
    public double mjesecnaPlata() {
        double osnovno = super.mjesecnaPlata();
        double prekovremeno = 4 * getPlataPoSatu() * prekovremeniSatiNedeljno * 1.2;
        return osnovno + prekovremeno;
    }

    @Override
    public String tipZaposlenog() {
        return "Konobar";
    }
}
