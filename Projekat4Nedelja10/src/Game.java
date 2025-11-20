import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player;
    private List<Enemy> enemies;
    private List<String> eventLog;

    public Game(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null.");
        }
        this.player = player;
        this.enemies = new ArrayList<>();
        this.eventLog = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<String> getEventLog() {
        return eventLog;
    }

    public boolean checkCollision(Player p, Enemy e) {
        if (p == null || e == null) {
            throw new IllegalArgumentException("Player and Enemy cannot be null.");
        }
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        if (p == null || e == null) {
            throw new IllegalArgumentException("Player and Enemy cannot be null.");
        }
        int oldHP = p.getHealth();
        int damage = e.getEffectiveDamage();
        int newHP = oldHP - damage;
        if (newHP < 0) newHP = 0;

        p.setHealth(newHP);

        String logEntry = "HIT: " + p.getDisplayName() + " by " + e.getDisplayName() +
                " for " + damage + " -> HP " + oldHP + " -> " + newHP;
        eventLog.add(logEntry);
    }

    public void addEnemy(Enemy e) {
        if (e == null) {
            throw new IllegalArgumentException("Enemy cannot be null.");
        }
        enemies.add(e);
        eventLog.add("SPAWN: " + e.toString());
    }

    public List<Enemy> findByType(String query) {
        List<Enemy> result = new ArrayList<>();
        if (query == null) return result;

        String q = query.toLowerCase();
        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(q)) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Enemy> collidingWithPlayer() {
        List<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                result.add(e);
            }
        }
        return result;
    }

    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }


    public static Enemy parseEnemy(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Line cannot be null.");
        }

        try {
            String[] parts = line.split(";");
            if (parts.length != 4) {
                throw new IllegalArgumentException("Invalid enemy format: expected 4 parts separated by ';'.");
            }

            String type = parts[0].trim();
            if (type.isEmpty()) {
                throw new IllegalArgumentException("Enemy type cannot be empty.");
            }

            // pozicija
            String posPart = parts[1].trim();
            String[] xy = posPart.split(",");
            if (xy.length != 2) {
                throw new IllegalArgumentException("Invalid position format, expected 'x,y'.");
            }

            int x = Integer.parseInt(xy[0].trim());
            int y = Integer.parseInt(xy[1].trim());

            // veličina (pravougaonik)
            String sizePart = parts[2].trim();
            String[] wh = sizePart.toLowerCase().split("x");
            if (wh.length != 2) {
                throw new IllegalArgumentException("Invalid size format, expected 'WxH'.");
            }

            int w = Integer.parseInt(wh[0].trim());
            int h = Integer.parseInt(wh[1].trim());

            Collidable collider = new RectangleCollider(x, y, w, h);

            // damage i (opciono) boss flag
            String damagePart = parts[3].trim();
            String[] dmgAndFlag = damagePart.split(",");
            int damage = Integer.parseInt(dmgAndFlag[0].trim());
            String flag = (dmgAndFlag.length > 1) ? dmgAndFlag[1].trim().toLowerCase() : "";

            int health = 100; // neka default vrijednost za parsirane neprijatelje

            if ("boss".equals(flag)) {
                return new BossEnemy(type, x, y, collider, damage, health);
            } else {
                return new MeleeEnemy(type, x, y, collider, damage, health);
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid number format in enemy string: " + ex.getMessage());
        }
    }

    // main – testiranje sistema
    public static void main(String[] args) {
        // Player: pravougaoni 32x32 na poziciji (10,5)
        Player player = new Player(
                " peTar   petrović ",
                10, 5,
                new RectangleCollider(10, 5, 32, 32),
                85
        );

        Game game = new Game(player);

        // 1. neprijatelj ručno (pravougaonik)
        Enemy e1 = new MeleeEnemy(
                "Goblin",
                12, 5,
                new RectangleCollider(12, 5, 16, 16),
                20,
                60
        );
        game.addEnemy(e1);

        // 2. neprijatelj preko parsiranja stringa
        // Napomena: format: "type; x,y; WxH; damage,bossFlag"
        Enemy e2 = Game.parseEnemy("Goblin King; 20,5; 32x32; 25,boss");
        game.addEnemy(e2);

        System.out.println("Svi neprijatelji");
        for (Enemy e : game.getEnemies()) {
            System.out.println(e);
        }

        System.out.println("\n Neprijatelji ciji type sadrzi 'gob' ");
        for (Enemy e : game.findByType("gob")) {
            System.out.println(e);
        }

        System.out.println("\n Stanje igraca prije kolizije");
        System.out.println(player);

        System.out.println("\n Neprijatelji koji se sudaraju sa igracem");
        for (Enemy e : game.collidingWithPlayer()) {
            System.out.println(e);
        }

        game.resolveCollisions();

        System.out.println("\n Stanje igraca poslije resolveCollisions() ===");
        System.out.println(player);

   
        
    }
}
