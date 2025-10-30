
public class MeleeEnemy extends Enemy{
	
	
	    private int napad; 
	    

	    public MeleeEnemy(int x, int y, int width, int height, String type, int damage, int napad) {
			super(x, y, width, height, type, damage);
			this.napad = napad;
		}

		public int getNapad() {
	        return napad;
	    }

	    public void setNapad(int napad) {
	        if (napad < 0) napad = 0;
	        this.napad = napad;
	    }

	    // Specifična metoda za MeleeEnemy
	    public void attack(Player player) {
	        if (player == null) return;

	        
			if (this.intersect(player)) {
	            System.out.println("💥 " + name + " je udario igrača " + player.getName() +
	                               " i nanio " + damage + " štete!");
	        } else {
	            System.out.println(name + " nije dovoljno blizu da napadne " + player.getName() + ".");
	        }
	    }

	    @Override
	    public String toString() {
	        return "MeleeEnemy{name='" + name + "', damage=" + damage +
	               ", napad=" + napad +
	               ", position=(" + x + "," + y + "), size=" + width + "x" + height + "}";
	    }
	}


