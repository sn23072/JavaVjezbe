public class Enemy extends GameObject implements Attacker {

    private String type;
    private int damage; // 0–100
    private int health; // 0–100

    public Enemy(String type, int x, int y, Collidable collider,
                 int damage, int health) {
        super(x, y, collider);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }

    public String getType() {
        return type;
    }

    public final void setType(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null.");
        }
        String t = type.trim();
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Type cannot be empty.");
        }
        this.type = t;
    }

    public int getDamage() {
        return damage;
    }

    public final void setDamage(int damage) {
        if (damage < 0 || damage > 100) {
            throw new IllegalArgumentException("Damage must be in range [0, 100].");
        }
        this.damage = damage;
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
    public int getEffectiveDamage() {
        return damage;
    }

    @Override
    public String getDisplayName() {
        return type;
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

        return "Enemy (" + type + ") @ (" + getX() + "," + getY() + ") " +
                sizeInfo + " DMG=" + damage + " HP=" + health;
    }
}
