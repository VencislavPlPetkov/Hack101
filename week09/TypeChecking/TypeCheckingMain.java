package TypeSignatures;

import java.util.Scanner;

/**
 * 2 f :: A -> B g :: B -> A
 * 
 * f . f
 * 
 * 
 *
 */

public class TypeCheckingMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		TypeCompositionManager allTypes = new TypeCompositionManager();

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {

			String nextFunction = scanner.nextLine();
			Types types = new Types(nextFunction);
			allTypes.add(types);

		}

		scanner.nextLine();

		String functionComposition = scanner.nextLine();

		String[] newOrder = functionComposition.split(" ");
		String[] orderOfExec = new String[newOrder.length / 2 + 1];

		int counter = 0;

		for (int i = newOrder.length - 1; i > -1; i -= 2) {

			orderOfExec[counter] = newOrder[i];
			counter++;
		}

		boolean result = true;
		String inputForNext = null;

		for (int i = 0; i < orderOfExec.length; i++) {

			Types current = allTypes.findByName(orderOfExec[i]);
			if (inputForNext == null || current.getInputType().equals(inputForNext)) {

				inputForNext = current.getOutputType();
			} else {

				result = false;
				break;
			}

		}
		System.out.println(result);

	}

}
