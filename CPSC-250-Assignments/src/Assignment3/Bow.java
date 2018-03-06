package Assignment3;

public class Bow extends Weapon {//extends the weapon class to inherit all it's methods

	public Bow(int strength) {//constructor uses the super constructor to set the weapon's strength
		super(strength);
		
	}
	
	public boolean equals(Object o){//uses the super method the checks if the two bows are the same
		return super.equals(o);
	}

}
