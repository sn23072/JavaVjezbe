
public class Enemy extends GameObject{
	        protected String type;
			protected int damage;

			

			

	public Enemy(int x, int y, int width, int height, String type, int damage) {
				super(x, y, width, height);
				this.type = type;
				this.damage = damage;
			}

	

	public String getType() {
		return type;
	}

	public int getDamage() {
		return damage;
	}
	//tip neprijatelja ne smije biti prazan
	public void setType(String type) {
		if (type == null || type.trim().isEmpty())
			throw new IllegalArgumentException("Tip neprijatelja ne smije biti prazan!");
		this.type = type.trim();
			}		

	//Vrijednost napada mora biti izmedju 0 i 100
			public void setDamage(int damage) {
				if (damage < 0 && damage > 100)
					throw new IllegalArgumentException("Damage mora biti izmedju 0 i 100!");
				this.damage = damage;
			}

			@Override
			public String toString() {
				return "Enemy [type=" + type + ", damage=" + damage + ", getType()=" + getType() + ", getDamage()="
						+ getDamage() + ", getX()=" + getX() + ", getY()=" + getY() + ", getWidth()=" + getWidth()
						+ ", getHeight()=" + getHeight() + ", toString()=" + super.toString() + ", getClass()="
						+ getClass() + ", hashCode()=" + hashCode() + "]";
			}

			
			
			
		}


