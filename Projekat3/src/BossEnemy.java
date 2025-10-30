
public class BossEnemy extends Enemy {
    private String specialAttack;


    public BossEnemy(int x, int y, int width, int height, String type, int damage, String specialAttack) {
		super(x, y, width, height, type, damage);
		this.specialAttack = specialAttack;
	}

	public String getSpecialAttack() {
        return specialAttack;
    }

    // Specijalni napad ne smije biti prazan
    public void setSpecialAttack(String specialAttack) {
        if (specialAttack == null || specialAttack.trim().isEmpty()) {
            throw new IllegalArgumentException("Specijalni napad ne smije biti prazan!");
        }
        this.specialAttack = specialAttack.trim();
    }

    
    public void performSpecialAttack() {
        System.out.println("Boss tipa '" + getType() + "' koristi specijalni napad: " + specialAttack + "!");
        System.out.println("Šteta napada: " + getDamage());
    }

    @Override
    public String toString() {
        return "BossEnemy [type=" + getType() +
               ", damage=" + getDamage() +
               ", specialAttack=" + specialAttack +
               ", x=" + getX() +
               ", y=" + getY() +
               ", width=" + getWidth() +
               ", height=" + getHeight() + "]";
    }
}
