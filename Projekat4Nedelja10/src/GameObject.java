public abstract class GameObject {

    private int x;
    private int y;
    private Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        if (collider == null) {
            throw new IllegalArgumentException("Collider ne moze biti prazno");
        }
        this.x = x;
        this.y = y;
        this.collider = collider;
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

    public Collidable getCollider() {
        return collider;
    }

    public void setCollider(Collidable collider) {
        if (collider == null) {
            throw new IllegalArgumentException("Collider ne moze biti prazno");
        }
        this.collider = collider;
    }

    public boolean intersects(GameObject other) {
        if (other == null) {
            throw new IllegalArgumentException("Other GameObject ne moze biti prazno");
        }
        if (this.collider == null || other.collider == null) {
            throw new IllegalStateException("Collider nije setovan.");
        }
        return this.collider.intersects(other.collider);
    }

    public abstract String getDisplayName();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " @ (" + x + "," + y + ")";
    }
}
