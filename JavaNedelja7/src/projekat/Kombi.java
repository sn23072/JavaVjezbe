package projekat;

public class Kombi extends Vozilo{
	private int kapacitetPutika;

	public Kombi(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int kapacitetPutika) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.kapacitetPutika = kapacitetPutika;
	}

	public int getKapacitetPutika() {
		return kapacitetPutika;
	}

	public void setKapacitetPutika(int kapacitetPutika) {
		this.kapacitetPutika = kapacitetPutika;
	}
	
	@Override
	public double cijenaRegistracije() {
		double cijena = super.cijenaRegistracije();
		if(kapacitetPutika > 8)
			cijena = cijena + 30;
		return cijena;
	}

	@Override
	public void prikaziInfo() {
		super.prikaziInfo();
		System.out.println("Broj putnika je: " + kapacitetPutika);
		System.out.println("Cijena registracije: " + cijenaRegistracije());
	}
}
