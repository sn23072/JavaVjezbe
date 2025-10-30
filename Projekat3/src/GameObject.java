
public class GameObject {

	protected String name;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	public GameObject(int x, int y, int width, int height) {
		super();
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	
	/*
	public void setName(String name) {
		if (name == null || name.trim().isEmpty())
			throw new IllegalArgumentException("Ime igraca ne smije biti prazno!");
		this.name = name.trim();
	}
	*/
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
		if (width < 0) width = 0;
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		if(height < 0)height = 0;
		this.height = height;
	}
	@Override
	public String toString() {
		return "GameObject [name=" + name + ", x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}
	
	//metoda za preklapanje
	
    public boolean intersect(GameObject other) {
        if (other == null) return false;

        boolean horizontalnoPreklapanje = this.x < other.x + other.width &&
                                    this.x + this.width > other.x;

        boolean verticalnoPreklapanje = this.y < other.y + other.height &&
                                  this.y + this.height > other.y;

        return horizontalnoPreklapanje && verticalnoPreklapanje;
    }
}
