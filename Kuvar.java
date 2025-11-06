
public class Kuvar extends Zaposleni {
    private static final double FiksniDodatak = 1500.0;

    public Kuvar(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSati);
    }

    @Override
    public double mjesecnaPlata() {
        return FiksniDodatak + super.mjesecnaPlata();
    }

    @Override
    public String tipZaposlenog() {
        return "Kuvar";
    }
}
