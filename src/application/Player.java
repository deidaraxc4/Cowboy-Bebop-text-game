package application;

public class Player extends Entity{
	//weapon attribute here
	Weapon weapon;
	boolean rope;
	boolean drink1;
	boolean drink2;
	boolean drink3;
	boolean coffee;

	public Player(String name, int health) {
		super(name, health);
		rope = false;
		drink1 = false;
		drink2 = false;
		drink3 = false;
		coffee = false;
	}
	
	//takes weapon paramter to return dmg dealt
	public int attack() {
		return Damage.rollDamage(weapon.getMin(), weapon.getMax());
	}
	
	public void assignWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void eat(int x) {
		health = health+x;
	}
	
	
	public boolean hasWeapon() {
		if(weapon!=null) {
			return true;
		} else {
			return false;
		}
	}

	

}
