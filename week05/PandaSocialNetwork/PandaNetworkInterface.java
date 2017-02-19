package PandaSocialNetwork;

import java.util.HashSet;

public interface PandaNetworkInterface {
	
	public void addPanda(Panda p);
	
	public boolean hasPanda(Panda p);
	
	public void makeFriends(Panda p1, Panda p2);
	
	public boolean areFriends(Panda p1, Panda p2)throws Exception;
	
	public HashSet<Panda> friendsOf(Panda p)throws Exception;
	
	public int connectionLevel(Panda p1, Panda p2);
	
	public boolean areConnected(Panda p1, Panda p2);
	
	public int howManyGenderInNetwork(int level, Panda p, String gender);

}