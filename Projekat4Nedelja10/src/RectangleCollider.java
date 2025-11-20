public class RectangleCollider implements Collidable {

    private int x;
    private int y;
    private int width;
    private int height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Rectangle dimenzije moraju biti vece od 0.");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other == null) {
            throw new IllegalArgumentException("Other collider cannot be null.");
        }

        if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;

            boolean noOverlap =
                    this.x + this.width <= r.x ||
                    r.x + r.width <= this.x ||
                    this.y + this.height <= r.y ||
                    r.y + r.height <= this.y;
            return !noOverlap;
        } else if (other instanceof CircleCollider) {
        	
            return other.intersects(this);
        } else {
        	
        	
            return false;
        }
    }

    @Override
    public String toString() {
        return "Rect[" + x + "," + y + "," + width + "x" + height + "]";
    }
}
