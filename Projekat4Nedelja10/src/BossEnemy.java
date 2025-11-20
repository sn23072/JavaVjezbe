public class BossEnemy extends Enemy {

    public BossEnemy(String type, int x, int y, Collidable collider,
                     int damage, int health) {
        super(type, x, y, collider, damage, health);
    }

    @Override
    public int getEffectiveDamage() {
        // dvostruki damage
        return getDamage() * 2;
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

        return "BossEnemy (" + getType() + ") @ (" + getX() + "," + getY() + ") " +
                sizeInfo + " DMG=" + getDamage() + "x2 HP=" + getHealth();
    }
}
