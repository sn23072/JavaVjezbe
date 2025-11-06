
public class EProizvod {

	private String opisProizvoda;
	private String sifreProizvoda;
	private double uvoznaCijenaProizvoda;
	public EProizvod(String opisProizvoda, String sifreProizvoda, double uvoznaCijenaProizvoda) {
		super();
		this.opisProizvoda = opisProizvoda;
		this.sifreProizvoda = sifreProizvoda;
		this.uvoznaCijenaProizvoda = uvoznaCijenaProizvoda;
	}
	public String getOpisProizvoda() {
		return opisProizvoda;
	}
	public void setOpisProizvoda(String opisProizvoda) {
		this.opisProizvoda = opisProizvoda;
	}
	public String getSifreProizvoda() {
		return sifreProizvoda;
	}
	public void setSifreProizvoda(String sifreProizvoda) {
		this.sifreProizvoda = sifreProizvoda;
	}
	public double getUvoznaCijenaProizvoda() {
		return uvoznaCijenaProizvoda;
	}
	public void setUvoznaCijenaProizvoda(double uvoznaCijenaProizvoda) {
		this.uvoznaCijenaProizvoda = uvoznaCijenaProizvoda;
	}
	@Override
	public String toString() {
		return "EProizvod [opisProizvoda=" + opisProizvoda + ", sifreProizvoda=" + sifreProizvoda
				+ ", uvoznaCijenaProizvoda=" + uvoznaCijenaProizvoda + "]";
	}
	
    public double maloprodajnaCijena() {
        return uvoznaCijenaProizvoda * 1.05;
    }
    
    public String tipIzSifre() {
        if (sifreProizvoda == null || sifreProizvoda.length() < 2) return "";
        return sifreProizvoda.substring(0, 2).toUpperCase();
    }
    
    public static EProizvod[] filtrirajPoTipu(EProizvod[] niz, String tipUnos) {
        if (niz == null || tipUnos == null) return new EProizvod[0];
        String tip = tipUnos.trim().toUpperCase();

        if (tip.startsWith("RAČ") || tip.startsWith("RAC")) tip = "RA";
        else if (tip.startsWith("TEL")) tip = "TE";
        else if (tip.startsWith("TV")) tip = "TV";
        else if (tip.length() >= 2) tip = tip.substring(0, 2);

        java.util.List<EProizvod> out = new java.util.ArrayList<>();
        for (EProizvod p : niz) {
            if (p == null) continue;
            if (tip.equalsIgnoreCase(p.tipIzSifre())) out.add(p);
        }
        return out.toArray(new EProizvod[0]);
    }
}
	

