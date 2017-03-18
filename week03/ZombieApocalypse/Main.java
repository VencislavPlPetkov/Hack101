
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int zombiesCount = input.nextInt();
		int zombieHealth = input.nextInt();

		int count = 0;

		Axe weapon = new Axe();

		HashMap<String, Weapon> weapons = new HashMap<>();

		weapons.put("axe", new Axe());
		// weapons.put("shotgun", new Shotgun());
		weapons.put("sword", new Sword());
		weapons.put("revolver", new Revolver());

		Weapon weapon2 = weapons.get(input.next());

		for (int i = 0; i < zombiesCount; i++) {

			int oneZombieHealth = zombieHealth;
			while (oneZombieHealth > 0) {
				zombieHealth -= weapon.hit();
				count++;
			}
		}
		System.out.println(count);

	}

}
