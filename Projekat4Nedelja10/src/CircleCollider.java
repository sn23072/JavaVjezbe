public class CircleCollider implements Collidable {

    private int centerX;
    private int centerY;
    private int radius;

    public CircleCollider(int centerX, int centerY, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Poluprecnik mora biti veci od nule.");
        }
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other == null) {
            throw new IllegalArgumentException("Other collider cannot be null.");
        }

        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            int dx = this.centerX - c.centerX;
            int dy = this.centerY - c.centerY;
            int distSq = dx * dx + dy * dy;
            int rSum = this.radius + c.radius;
            return distSq <= rSum * rSum;
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;

            int rectMinX = r.getX();
            int rectMaxX = r.getX() + r.getWidth();
            int rectMinY = r.getY();
            int rectMaxY = r.getY() + r.getHeight();

            int closestX = clamp(centerX, rectMinX, rectMaxX);
            int closestY = clamp(centerY, rectMinY, rectMaxY);

            int dx = centerX - closestX;
            int dy = centerY - closestY;
            int distSq = dx * dx + dy * dy;

            return distSq <= radius * radius;
        } else {
            return false;
        }
    }

    private int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    @Override
    public String toString() {
        return "Circle[" + centerX + "," + centerY + ",r=" + radius + "]";
    }
}
