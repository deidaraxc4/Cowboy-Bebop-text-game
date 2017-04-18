package application;

public class Monster extends Entity {
	private int minHit;
	private int maxHit;

	public Monster(String name, int health,int minHit,int maxHit) {
		super(name, health);
		this.minHit = minHit;
		this.maxHit = maxHit;
	}

}
