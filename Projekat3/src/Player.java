public class Player extends GameObject {
    private String name;
    private int health;

    public Player(int x, int y, int width, int height, String name, int health) {
        super(x, y, width, height);
        setName(name);
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    // Ime ne smije biti prazno + uklanjanje višestrukih razmaka + veliko početno slovo svake riječi
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ime igrača ne smije biti prazno!");
        }

        // Ukloni višestruke razmake i pretvori u mala slova
        String[] rijeci = name.trim().toLowerCase().split("\\s+");
        StringBuilder ispravljenoIme = new StringBuilder();

        for (String rijec : rijeci) {
            if (!rijec.isEmpty()) {
                // Svaku riječ počinjemo velikim slovom
                ispravljenoIme.append(Character.toUpperCase(rijec.charAt(0)))
                              .append(rijec.substring(1))
                              .append(" ");
            }
        }

        // Trim na kraju da uklonimo eventualni razmak
        this.name = ispravljenoIme.toString().trim();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) health = 0;
        if (health > 100) health = 100;
        this.health = health;
    }

	@Override
	public String toString() {
		return "Player [name=" + name + ", health=" + health + ", getName()=" + getName() + ", getHealth()="
				+ getHealth() + ", getX()=" + getX() + ", getY()=" + getY() + ", getWidth()=" + getWidth()
				+ ", getHeight()=" + getHeight() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}


}
