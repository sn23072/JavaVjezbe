import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Smjena {
    private LocalDate datum;
    private LocalTime pocetak;
    private LocalTime kraj;
    private TipSmjene tip;
    private List<Integer> zaposleniIds = new ArrayList<>();

    public Smjena(LocalDate datum, LocalTime pocetak, LocalTime kraj, TipSmjene tip) {
        this.datum = datum;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.tip = tip;
    }

    public LocalDate getDatum() { return datum; }
    public LocalTime getPocetak() { return pocetak; }
    public LocalTime getKraj() { return kraj; }
    public TipSmjene getTip() { return tip; }

    public void dodajZaposlenog(int zaposleniId) {
        if (!zaposleniIds.contains(zaposleniId)) {
            zaposleniIds.add(zaposleniId);
        }
    }

    public List<Integer> getZaposleniIds() {
        return zaposleniIds;
    }

    public int trajanjeUSatima() {
        long minute = Duration.between(pocetak, kraj).toMinutes();
        if (minute < 0) { 
            minute = Duration.between(pocetak, LocalTime.MIDNIGHT).toMinutes()
                    + Duration.between(LocalTime.MIN, kraj).toMinutes();
        }
        return (int)(minute / 60);
    }

    @Override
    public String toString() {
        return datum + " " + tip + " (" + pocetak + "-" + kraj + ")";
    }
}
