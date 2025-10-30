package projekat;

public class Vozilo {

    private String proizvodjac;
    private int godinaProizvodnje;
    private int kubikaza;
    private String boja;
	public Vozilo(String proizvodjac, int godinaProizvodnje, int kubikaza, String boja) {
		super();
		this.proizvodjac = proizvodjac;
		this.godinaProizvodnje = godinaProizvodnje;
		this.kubikaza = kubikaza;
		this.boja = boja;
	}
	public String getProizvodjac() {
		return proizvodjac;
	}
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	public int getKubikaza() {
		return kubikaza;
	}
	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}
	public String getBoja() {
		return boja;
	}
	public void setBoja(String boja) {
		this.boja = boja;
	}
    
    public double cijenaRegistracije() {
        double cijena = 100;

        if (godinaProizvodnje < 2010)
            cijena += 30;
        if (kubikaza > 2000)
            cijena += 50;

        return cijena;
    }
    public void prikaziInfo() {
        System.out.println("Proizvođač: " + proizvodjac);
        System.out.println("Godina: " + godinaProizvodnje);
        System.out.println("Kubikaža: " + kubikaza);
        System.out.println("Boja: " + boja);
    }
}

