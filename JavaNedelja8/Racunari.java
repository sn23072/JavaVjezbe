
public class Racunari extends EProizvod {
	
	private String procesor;
	private int memorija;
	public Racunari(String opisProizvoda, String sifreProizvoda, double uvoznaCijenaProizvoda, String procesor,
			int memorija) {
		super(opisProizvoda, sifreProizvoda, uvoznaCijenaProizvoda);
		this.procesor = procesor;
		this.memorija = memorija;
	}
	public String getProcesor() {
		return procesor;
	}
	public void setProcesor(String procesor) {
		this.procesor = procesor;
	}
	public int getMemorija() {
		return memorija;
	}
	public void setMemorija(int memorija) {
		this.memorija = memorija;
	}
	
    @Override
    public double maloprodajnaCijena() {
        double mpc = super.maloprodajnaCijena(); 
        mpc *= 1.05; // dodatnih 5%
        return mpc;
    }
	@Override
	public String toString() {
		return "Racunari [procesor=" + procesor + ", memorija=" + memorija + "]";
	}
    
    

	

}
