package dungeonsAndZombies;

public class Hero extends Characteristics{
	
	private String name;
	private String title;
	private int manaRegen;
	private Weapon weapon;
	private Spell spell;
	
	public Hero(String name, String title,int health,int mana, int manaRegen){
		super(health, mana);
		
		this.name = name;
		this.title = title;
		this.manaRegen = manaRegen;
		
	}
	
	public String getName(){
		
		return name;
	}
	
	public void setName(String name){
		
		this.name = name;
	}
	
	public String getTitle(){
		
		return title;
	}
	
	public void setTitle(String title){
		
		this.title = title;
	}
	
	public int getManaRegen(){
		
		return manaRegen;
	}
	
	public void setManaRegen(int manaRegen){
		
		this.manaRegen = manaRegen;
	}
	
	public String knownAs(){
		
		return this.getName() + "the" + this.getTitle();
	}
	
	
	public void equip(Weapon w){
		
		this.weapon = w;
		
	}
	
	public void learn(Spell s){
		
		this.spell = s;
	}
	

	@Override
	public boolean canCast(Spell s) {
		
		return this.getCurrentMana() > s.getManaCost();
	}
	
	

	@Override
	public int attack(String type) {
		
		if (type == "weapon") {
			
			return this.weapon.getDamage();
			
		}
		
		if (type == "spell" && this.canCast(this.spell)) {
			
			return this.spell.getDamage();
			
		}
		
		return 0;
	}
	
	
	

}
