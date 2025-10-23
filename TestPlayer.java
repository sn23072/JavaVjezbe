import java.util.ArrayList;
//Sara Nikcevic 23/072
//Andrea Markovic 23/073
//Stevan Perovic 24/124


class Player {
	private String name;
	private int x, y;
	private int width, height;
	private int health;

	public Player(String name, int x, int y, int width, int height, int health) {
		setName(name);
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		setHealth(health);
	}

	public String getName() {
		return name;
	}

//ime ne smije biti prazno , uklanjanje visestrukih razmaka
	public void setName(String name) {
		if (name == null || name.trim().isEmpty())
			throw new IllegalArgumentException("Ime igraca ne smije biti prazno!");
		this.name = name.trim();
		// Ukloni višestruke razmake i podijeli ime na riječi
		// trim uklanja razmake sa pocetka i kraja
		// toLowerCase pretvara u mala slova a split razdvaja string u niz rijeci na
		// osnovu razmaka
		String[] rijeci = name.trim().toLowerCase().split("\\s+");
		StringBuilder ispravljenoIme = new StringBuilder();

		for (String rijec : rijeci) {
			if (rijec.length() > 0) {
				// Svaku riječ počinjemo velikim slovom
				ispravljenoIme.append(Character.toUpperCase(rijec.charAt(0))).append(rijec.substring(1)).append(" ");
			}
		}

		// Ukloni posljednji razmak
		this.name = ispravljenoIme.toString().trim();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

//zivotni bodovi moraju biti moraju biti izmedju 0 i 100 
	public void setHealth(int health) {
		if (health < 0 || health > 100)
			throw new IllegalArgumentException("Health mora biti izmedju 0 i 100!");
		this.health = health;
	}

	@Override
	public String toString() {
		return String.format("Player[%s] @ (%d,%d) %dx%d HP=%d", name, x, y, width, height, health);
	}

	class Enemy {
		private String type;
		private int x, y;
		private int width, height;
		private int damage;

		public Enemy(String type, int x, int y, int width, int height, int damage) {
			setType(type);
			setX(x);
			setY(y);
			setWidth(width);
			setHeight(height);
			setDamage(damage);
		}

		public String getType() {
			return type;
		}

//tip neprijatelja ne smije biti prazan
		public void setType(String type) {
			if (type == null || type.trim().isEmpty())
				throw new IllegalArgumentException("Tip neprijatelja ne smije biti prazan!");
			this.type = type.trim();
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getDamage() {
			return damage;
		}

//Vrijednost napada mora biti izmedju 0 i 100
		public void setDamage(int damage) {
			if (damage < 0 && damage > 100)
				throw new IllegalArgumentException("Damage mora biti izmedju 0 i 100!");
			this.damage = damage;
		}

		@Override
		public String toString() {
			return String.format("Enemy[%s] @ (%d,%d) %dx%d DMG=%d", type, x, y, width, height, damage);
		}
		
		
		
	}

	class Game {
	    private Player player;
	    private ArrayList<Enemy> enemies;
	    private ArrayList<String> eventLog;

	    public Game(Player player) {
	        this.player = player;
	        this.enemies = new ArrayList<>();
	        this.eventLog = new ArrayList<>();
	    }

	    
	    // provjerava da li se igrač i neprijatelj preklapaju (sudar)
	    public boolean checkCollision(Player p, Enemy e) {
	        boolean sudarX = p.getX() < e.getX() + e.getWidth() &&
	                         p.getX() + p.getWidth() > e.getX();
	        boolean sudarY = p.getY() < e.getY() + e.getHeight() &&
	                         p.getY() + p.getHeight() > e.getY();
	        return sudarX && sudarY;
	    }

	  
	    // smanjuje health igrača za damage vrijednost neprijatelja (ne ispod 0)
	    // upisuje poruku u eventLog
	    public void decreaseHealth(Player p, Enemy e) {
	        int oldHP = p.getHealth();
	        int newHP = Math.max(0, oldHP - e.getDamage());
	        p.setHealth(newHP);
	        String log = String.format("HIT: Player by %s for %d -> HP %d -> %d",
	                                    e.getType(), e.getDamage(), oldHP, newHP);
	        eventLog.add(log);
	    }

	    
	    // dodaje neprijatelja u listu i upisuje događaj u eventLog
	    public void addEnemy(Enemy e) {
	        enemies.add(e);
	        eventLog.add("Enemy added: " + e.getType());
	    }

	    
	    // vraća sve neprijatelje čiji tip sadrži zadati tekst 
	    public ArrayList<Enemy> findByType(String query) {
	        ArrayList<Enemy> result = new ArrayList<>();
	        for (Enemy e : enemies) {
	            if (e.getType().toLowerCase().contains(query.toLowerCase())) {
	                result.add(e);
	            }
	        }
	        return result;
	    }

	    
	    // vraća listu svih neprijatelja koji se trenutno sudaraju sa igračem
	    public ArrayList<Enemy> collidingWithPlayer() {
	        ArrayList<Enemy> result = new ArrayList<>();
	        for (Enemy e : enemies) {
	            if (checkCollision(player, e)) {
	                result.add(e);
	            }
	        }
	        return result;
	    }

	    
	    // za svakog neprijatelja koji se sudara sa igračem, poziva decreaseHealth
	    public void resolveCollisions() {
	        for (Enemy e : collidingWithPlayer()) {
	            decreaseHealth(player, e);
	        }
	    }

	    // Metoda za prikaz eventLog-a
	    public void printEventLog() {
	        System.out.println("\n--- EVENT LOG ---");
	        for (String log : eventLog) {
	            System.out.println(log);
	        }
	    }
 
	}
	public class TestGame {
	    public static void main(String[] args) {
	    	Player p = new Player("Hero", 10, 10, 30, 30, 100);
	   // 	Game game = new Game(p);

	    }
	    }
	}

	
