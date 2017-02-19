
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.nextLine();
		String b = sc.nextLine();

		if (areAnagrams(a, b)) {
			System.out.println("Anagrams!");
		} else {
			System.out.println("Not Anagrams!");
		}
		sc.close();
	}

	public static boolean areAnagrams(String a, String b) {
		a = a.replaceAll("\\s+", "").toLowerCase();
		b = b.replaceAll("\\s+", "").toLowerCase();

		if (a.length() != b.length()) {
			return false;
		}

		for (int i = 0; i < a.length(); i++) {
			int index = b.indexOf(a.charAt(i));
			if (index < 0) {
				return false;
			} else {

				return areAnagrams(a.substring(1), b.substring(0, index) + b.substring(index + 1));
			}
		}
		return true;

	}

}