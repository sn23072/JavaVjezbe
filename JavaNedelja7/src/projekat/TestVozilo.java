package projekat;

public class TestVozilo {

	public static void main(String[] args) {

		Automobil a = new Automobil("Audi", 2015, 5000, "crvena", 4, "dizel");
		Kamion k = new Kamion("WV", 2000, 6000, "plava", 8000, false);
		Kombi k1 = new Kombi("WV", 2012, 10000, "plava", 8);
		
		a.prikaziInfo();
		a.cijenaRegistracije();
		k.prikaziInfo();
		k.cijenaRegistracije();
		k1.prikaziInfo();
		k1.cijenaRegistracije();
	}

}
