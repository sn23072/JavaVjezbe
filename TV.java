
public class TV extends EProizvod{

	private double velicinaEkrana;

	public TV(String opisProizvoda, String sifreProizvoda, double uvoznaCijenaProizvoda, double velicinaEkrana) {
		super(opisProizvoda, sifreProizvoda, uvoznaCijenaProizvoda);
		this.velicinaEkrana = velicinaEkrana;
	}

	public double getVelicinaEkrana() {
		return velicinaEkrana;
	}

	public void setVelicinaEkrana(double velicinaEkrana) {
		this.velicinaEkrana = velicinaEkrana;
	}
	
	
    @Override
    public double maloprodajnaCijena() {
        double mpc = super.maloprodajnaCijena();
        if (velicinaEkrana > 65.0) {
            mpc *= 1.10;
        }
        return mpc;
    }

	@Override
	public String toString() {
		return "TV [velicinaEkrana=" + velicinaEkrana + "]";
	}
    
    
	
}
