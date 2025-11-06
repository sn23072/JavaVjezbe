public class Menadzer extends Zaposleni {
    private static final double osnovica = 1300.0;
    private double bonus; 

    public Menadzer(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati, double bonus) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    @Override
    public double mjesecnaPlata() {
        return osnovica + super.mjesecnaPlata() + bonus;
    }

    @Override
    public String tipZaposlenog() {
        return "Menadzer";
    }
}
