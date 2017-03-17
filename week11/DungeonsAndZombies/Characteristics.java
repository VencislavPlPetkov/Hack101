package dungeonsAndZombies;

public abstract class Characteristics {

	private int health;
	private int mana;
	private int currentHealth;
	private int currentMana;

	public Characteristics(int health, int mana) {

		this.health = health;
		this.mana = mana;
		this.currentHealth = currentHealth;
		this.currentMana = currentMana;

	}

	public int getCurrentHealth() {

		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {

		this.currentHealth = currentHealth;
	}

	public int getCurrentMana() {

		return currentMana;

	}

	public void setCurrentMana(int currentMana) {

		this.currentMana = currentMana;
	}

	public int getHealth() {

		return health;
	}

	public void setHealth(int health) {

		this.health = health;
	}

	public int getMana() {

		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public boolean isAlive() {
		return this.getCurrentHealth() > 0;
	}

	public abstract boolean canCast(Spell s);

	public abstract int attack(String type);

	public void takeDamage(int damagePoints) {

		if (this.getCurrentHealth() - damagePoints <= 0) {

			this.setCurrentHealth(0);

		} else {

			this.setCurrentHealth(getCurrentHealth() - damagePoints);

		}
	}

	public void takeHealing(int healingPoints) {

		if (this.getCurrentHealth() + healingPoints > this.getHealth()) {

			this.setCurrentHealth(this.getHealth());

		} else {

			this.setCurrentHealth(this.getCurrentHealth() + healingPoints);

		}

	}

	public void takeMana(int manaPoints) {

		if (this.getCurrentMana() + manaPoints > this.getMana()) {

			this.setCurrentMana(this.getMana());

		} else {

			this.setCurrentMana(this.getCurrentMana() + manaPoints);

		}
	}

}
