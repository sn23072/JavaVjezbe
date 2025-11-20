public class Player extends GameObject {

    private String name;
    private int health; // 0–100

    public Player(String name, int x, int y, Collidable collider, int health) {
        super(x, y, collider);
        setName(name);
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        String trimmed = name.trim().replaceAll("\\s+", " ");
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        String[] parts = trimmed.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String w = parts[i].toLowerCase();
            if (w.isEmpty()) continue;
            String formatted = Character.toUpperCase(w.charAt(0)) + w.substring(1);
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(formatted);
        }

        String finalName = sb.toString().trim();
        if (finalName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty after formatting.");
        }

        this.name = finalName;
    }

    public int getHealth() {
        return health;
    }

    public final void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health must be in range [0, 100].");
        }
        this.health = health;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        String sizeInfo = "";
        Collidable c = getCollider();
        if (c instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) c;
            sizeInfo = r.getWidth() + "x" + r.getHeight();
        } else if (c instanceof CircleCollider) {
            CircleCollider circle = (CircleCollider) c;
            sizeInfo = "r=" + circle.getRadius();
        }

        return "Player (" + name + ") @ (" + getX() + "," + getY() + ") " +
                sizeInfo + " HP=" + health;
    }
}
