import java.util.ArrayList;

class Auto {
	private String markaAuta;
	private int godisteAuta;
	private float snagaMotora;
	private boolean prodato;
	private float kubikazaMotora;
	private boolean registrovan;
	private static int brojProdatih = 0;
	
	
	public Auto(String markaAuta, int godisteAuta, float snagaMotora, boolean prodato, float kubikazaMotora,
			boolean registrovan) {
		super();
		this.markaAuta = markaAuta;
		this.godisteAuta = godisteAuta;
		this.snagaMotora = snagaMotora;
		this.prodato = prodato;
		if(prodato) brojProdatih++;
		this.kubikazaMotora = kubikazaMotora;
		this.registrovan = godisteAuta < 1985 ? false : registrovan;
		
	}


	public String getMarkaAuta() {
		return markaAuta;
	}


	public void setMarkaAuta(String markaAuta) {
		this.markaAuta = markaAuta;
	}


	public int getGodisteAuta() {
		return godisteAuta;
	}


	public void setGodisteAuta(int godisteAuta) {
		if(godisteAuta >= 2025) {
			System.out.println("Jos nijesmo stigli do te godine");
			return;
		}
		this.godisteAuta = godisteAuta;
		if(godisteAuta < 1985) this.registrovan = false;
	}


	public float getSnagaMotora() {

		return snagaMotora;
	}


	public void setSnagaMotora(float snagaMotora) {
		this.snagaMotora = snagaMotora;
	}


	public boolean jeProdato() {
		return prodato;
	}


	public void setProdato(boolean prodato) {
		if(this.prodato != prodato && prodato) brojProdatih++;
		this.prodato = prodato;
	}


	public float getKubikazaMotora() {
		return kubikazaMotora;
	}


	public void setKubikazaMotora(float kubikazaMotora) {
		this.kubikazaMotora = kubikazaMotora;
	}


	public boolean jeRegistrovan() {
		return registrovan;
	}


	public void setRegistrovan(boolean registrovan) {
		if(this.godisteAuta >= 1985) this.registrovan = registrovan;
	}


	public static int getBrojProdatih() {
		return brojProdatih;
	}


	public static void setBrojProdatih(int brojProdatih) {
		Auto.brojProdatih = brojProdatih;
	}
	
	public boolean mozeSeRegistrovati() {
		return godisteAuta >= 1985;
	}
	
	
	   public static double koeficijentZaGodiste(int godiste) {
		   if(godiste < 1985) return 0.0;
		   if(godiste <= 2000) return 3.0;
		   if(godiste <= 2010) return 2.0;
		   return 1.5;
	        
	    }
	   
	   public double cijenaRegistracije() {
		   if(!mozeSeRegistrovati()) return 0.0;
		   return koeficijentZaGodiste(godisteAuta)* kubikazaMotora * snagaMotora;
	       
	    }


	@Override
	public String toString() {
		return "Auto [markaAuta =" + markaAuta + ", godisteAuta =" + godisteAuta + ", snagaMotora =" + snagaMotora
				+ ", prodato =" + prodato + ", kubikazaMotora =" + kubikazaMotora + ", registrovan =" + registrovan
				+ ", cijenaRegistracije =" + cijenaRegistracije() + "]";
	}


/*	@Override
	public String toString() {
		return String.format("Auto [markaAuta=%s, godisteAuta=%d, snagaMotora=%.1f, prodato=%s, kubikazaMotora=%.1f, registrovan=%.2f, cijenaReg=%2.f]"
				,markaAuta , godisteAuta, snagaMotora, prodato? "da" : "ne",kubikazaMotora, registrovan ? "da" : "ne",cijenaRegistracije());
	}
	*/
}
	class AutoServis{
		public static ArrayList<Auto>neregistrovaniKojiSeMoguRegistrovati(ArrayList<Auto>auta){
			ArrayList<Auto> lista = new ArrayList<>();
			for(Auto a: auta) {
				if(a.mozeSeRegistrovati() && !a.jeRegistrovan()) {
					lista.add(a);
				}
				
			}
			return lista;
			
		}
		
		public static double ukupnaRegistracija(ArrayList<Auto> auta) {
			double suma = 0;
			for(Auto a : auta) {
				suma += a.cijenaRegistracije();
			}
			
			return suma;
		}
	}
	
	

public class TestAuto {

	public static void main(String[] args) {
		ArrayList<Auto> auta = new ArrayList<Auto>();
		Auto a1 = new Auto("VW Golf 3", 1995,55,true,1200,true);
		auta.add(a1);
		Auto a2 = new Auto("VW Golf 3", 2020,55,true,1200,false);
		auta.add(a2);
		for(Auto a: AutoServis.neregistrovaniKojiSeMoguRegistrovati(auta)) {
			
			System.out.println(a);
		}
		
		System.out.println(auta.get(0));
		

		
	}

}
