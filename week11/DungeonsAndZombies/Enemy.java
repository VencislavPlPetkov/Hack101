package dungeonsAndZombies;

public class Enemy extends Characteristics {

	private int damage;

	public Enemy(int health, int mana, int damage) {
		super(health, mana);

		this.damage = damage;
	}

	public int getDamage() {

		return damage;
	}

	public void setDamage(int damage) {

		this.damage = damage;
	}

	@Override
	public boolean canCast(Spell s) {
		return false;
	}

	@Override
	public int attack(String type) {
		return 0;
	}

}
