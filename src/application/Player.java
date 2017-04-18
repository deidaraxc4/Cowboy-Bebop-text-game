package application;

public class Player extends Entity{
	//weapon attribute here
	Weapon weapon;

	public Player(String name, int health) {
		super(name, health);
	}
	
	//takes weapon paramter to return dmg dealt
	public int attack() {
		return 0;
	}
	
	public void assignWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public boolean hasWeapon() {
		if(weapon!=null) {
			return true;
		} else {
			return false;
		}
	}

	

}
