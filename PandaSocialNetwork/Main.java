package PandaSocialNetwork;

public class Main {

	public static void main(String[] args) {

		Panda marieta = new Panda("Marieta", "marietka@abv.bg", "female");

		Panda konstantin = new Panda("Konstantin", "koceto@gmail.com", "male");

		Panda pepi = new Panda("Pepi", "pepi@yahoo.com", "male");

		Panda sisi = new Panda("Sisi", "silvia@yahoo.com", "female");

		Panda krasi = new Panda("Krasi", "krasi_t@gmail.com", "male");

		PandaNetwork network = new PandaNetwork();
		network.addPanda(marieta);
		network.addPanda(konstantin);
		network.addPanda(pepi);
		network.addPanda(sisi);

		network.makeFriends(marieta, konstantin);
		network.makeFriends(konstantin, pepi);
		network.areFriends(pepi, krasi);

		System.out.println(network.areFriends(konstantin, marieta));
		System.out.println(network.areFriends(marieta, pepi));

		System.out.println(network.areConnected(marieta, krasi));
		System.out.println(network.connectionLevel(konstantin, pepi));
		System.out.println(network.connectionLevel(marieta, pepi));

		System.out.println(network.areConnected(marieta, sisi));
		System.out.println(network.areConnected(marieta, konstantin));

	}

}