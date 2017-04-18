package application;

public class Entity {
	protected String name;
	protected int health;

	public Entity(String name,int health) {
		this.name = name;
		this.health = health;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void takeDmg(int dmg) {
		health = health - dmg;
	}
	
	public boolean checkHealth() {
		if(health<=0) {
			return true;
		} else {
			return false;
		}
	}
	

}
