package Assignment3;

import java.util.ArrayList;

public class HumanoidArmy {

	ArrayList<Humanoid> humanoids; // create a list of Humanoids which contains everyone in the army
	
	public HumanoidArmy(){//constructor creates the army by initializing the arraylist
		humanoids = new ArrayList<Humanoid>();
	}
	
	
	public void addSoldier(Humanoid human){//method to add a humanoid to the army (arrayList)
		humanoids.add(human);
	}
	
	public ArrayList<Humanoid> getArmy(){// returns the list of humanoids in the army
		return humanoids;
	}
}
