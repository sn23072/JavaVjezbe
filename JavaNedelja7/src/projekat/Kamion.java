package projekat;

public class Kamion extends Vozilo{
	private int kapacitetTereta;
	private boolean prikolica;
	public Kamion(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja, int kapacitetTereta,
			boolean prikolica) {
		super(proizvodjac, godinaProizvodnje, kubikaza, boja);
		this.kapacitetTereta = kapacitetTereta;
		this.prikolica = prikolica;
	}
	public int getKapacitetTereta() {
		return kapacitetTereta;
	}
	public void setKapacitetTereta(int kapacitetTereta) {
		this.kapacitetTereta = kapacitetTereta;
	}
	public boolean isPrikolica() {
		return prikolica;
	}
	public void setPrikolica(boolean prikolica) {
		this.prikolica = prikolica;
	}
	
	@Override
	public double cijenaRegistracije() {
	
		double cijena = super.cijenaRegistracije();
		if(prikolica==true)
			cijena = cijena + 50;
		return cijena;
	}

	@Override
	public void prikaziInfo() {
		super.prikaziInfo();
		System.out.println("Kapacitet tereta: " + kapacitetTereta);
		System.out.println("Prikolica: " + prikolica);
		System.out.println("Cijena registracije je: " + cijenaRegistracije());
		
	}
}
