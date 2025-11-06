
public class Telefoni extends EProizvod{

	private String operativniSistem;
	private double velicinaEkrana;
	public Telefoni(String opisProizvoda, String sifreProizvoda, double uvoznaCijenaProizvoda, String operativniSistem,
			double velicinaEkrana) {
		super(opisProizvoda, sifreProizvoda, uvoznaCijenaProizvoda);
		this.operativniSistem = operativniSistem;
		this.velicinaEkrana = velicinaEkrana;
	}
	public String getOperativniSistem() {
		return operativniSistem;
	}
	public void setOperativniSistem(String operativniSistem) {
		this.operativniSistem = operativniSistem;
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
        if (velicinaEkrana > 6.0) {
            mpc *= 1.03;
        }
        return mpc;
    }
	@Override
	public String toString() {
		return "Telefoni [operativniSistem=" + operativniSistem + ", velicinaEkrana=" + velicinaEkrana + "]";
	}
    
    
}
