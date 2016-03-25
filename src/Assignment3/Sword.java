package Assignment3;

public class Sword extends Weapon implements Magic {//extends Weapon to get all of its methods, implements magic to have the compareTo and getMagicForce methods

	private int magicForce;// field that contains the integer for the magicForce
	
	public Sword(int strength, int force){// constructor that uses the super constructor to set the strength and sets the magicForce field equal to the incoming magic force
		super(strength);
		
		magicForce = force;
	}
	

	@Override
	public int compareTo(Magic o) {//overrides the interfaces compareTo method and returns the difference between the magicForce fields
		return magicForce - o.getMagicalForce();
	}

	@Override
	public int getMagicalForce() {//overrides the getMagicForce method from the interface, return the magicForce field
		return magicForce;
	}
	
	@Override
	public boolean equals(Object o){//method that overrides the superclass's equals method
		if(o instanceof Sword){//checks if both are of type Sword
			if(((Sword) o).getMagicalForce() == magicForce && super.equals(o)){//checks if the swords have the same strength and magicForce
				return true;
			}
		}
		return false;
	}

}
