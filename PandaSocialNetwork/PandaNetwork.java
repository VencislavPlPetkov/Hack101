package PandaSocialNetwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PandaNetwork implements PandaNetworkInterface {

	private HashMap<Panda, HashSet<Panda>> pandasNetwork = new HashMap<>();

	@Override
	public void addPanda(Panda p) {
		try {
			if (!pandasNetwork.containsKey(p)) {

				pandasNetwork.put(p, new HashSet<Panda>());
			}

		} catch (Exception e) {
			System.out.println("There is no such a panda!");
		}

	}

	@Override
	public boolean hasPanda(Panda p) {

		return pandasNetwork.containsKey(p);
	}

	@Override
	public void makeFriends(Panda p1, Panda p2) {
		try {

			if (!hasPanda(p1)) {

				addPanda(p1);
			}
			if (!hasPanda(p2)) {

				addPanda(p2);
			}

			pandasNetwork.get(p1).add(p2);
			pandasNetwork.get(p2).add(p1);

		} catch (Exception e) {
			System.out.println("Imposible relationship!");
		}

	}

	@Override
	public boolean areFriends(Panda p1, Panda p2) {

		return pandasNetwork.get(p1).contains(p2);
	}

	@Override
	public HashSet<Panda> friendsOf(Panda p) {

		try {

			pandasNetwork.get(p);

		} catch (Exception e) {

			System.out.println("This panda is not in your friends list!");
		}

		return null;
	}

	@Override
	public int connectionLevel(Panda p1, Panda p2) {

		Queue<Panda> mustChecked = new LinkedList<>(pandasNetwork.get(p1));

		Set<Panda> visited = new HashSet<>();
		visited.add(p1);
		int level = 1;

		while (!mustChecked.isEmpty()) {

			Panda currentPanda = mustChecked.poll();

			if (currentPanda.equals(p2)) {

				return level;

			} else {

				visited.add(currentPanda);

				for (Panda panda : pandasNetwork.get(currentPanda)) {

					if (!visited.contains(panda)) {

						mustChecked.add(panda);
						level++;
					}
				}
			}

		}

		return -1;
	}

	@Override
	public boolean areConnected(Panda p1, Panda p2) {

		if (connectionLevel(p1, p2) == -1) {

			return false;

		}

		return true;
	}

	// TODO

	@Override
	public int howManyGenderInNetwork(int level, Panda p, String gender) {

		return 0;
	}

}