
public class Televizor {

	public int brojKanala;
	public int jacinaTona;
	public String nazivKanala;

		public Televizor(int brojKanala, int jacinaTona, String nazivKanala) {
		if( brojKanala >= 1 ) {
		this.brojKanala = brojKanala;
		}else {
			brojKanala = 1;
		}

		if(jacinaTona >= 0 && jacinaTona <= 10) {
			this.jacinaTona = jacinaTona;
		}else {
			jacinaTona = 5;
		}
		
		this.nazivKanala = nazivKanala;
	}

		public int getBrojKanala() {
		return brojKanala;
	}

	public void setBrojKanala(int brojKanala) {
		if(brojKanala > 0) {
		this.brojKanala = brojKanala;
		}else {
			System.out.println("Nijeste dobro unijeli broj kanala (>0)");
		}
	}

	public int getJacinaTona() {
		return jacinaTona;
	}

	public void setJacinaTona(int jacinaTona) {
		if(jacinaTona >= 0 && jacinaTona <= 10) {
			this.jacinaTona = jacinaTona;
		}else {
			System.out.println("Potrebno je unijeti neku od vrijednosti od 0 do 10: ");
		}
	}

	public String getNazivKanala() {
		return nazivKanala;
	}

	public void setNazivKanala(String nazivKanala) {
		this.nazivKanala = nazivKanala;
	}

	public void pojacajTon() {
		if(this.jacinaTona < 10) {
		this.jacinaTona ++;
		}else {
			System.out.println("Jacina tona vec je na maksimumu.");
		}
		
	}
	public void ispisi() {
		System.out.println("Broj kanala: " + this.brojKanala + " " +
							"Jacina tona: " + this.jacinaTona + " " + 
							"Naziv kanala: " + this.nazivKanala);
	}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Televizor televizor1 = new Televizor(10, 6, "Kanal 1");
			Televizor televizor2 = new Televizor(15, 4, "Kanal 10");
			System.out.println("Jacina tona kanala: " + televizor1.jacinaTona);
			System.out.println("Broj kanala: "  + televizor2.brojKanala);
			televizor1.pojacajTon();
			televizor1.pojacajTon();
			televizor1.ispisi();
		}

}
