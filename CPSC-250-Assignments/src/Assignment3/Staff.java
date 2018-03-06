package Assignment3;

public class Staff extends Weapon implements Magic {//extends Weapon to get all of its methods, implements magic to have the compareTo and getMagicForce methods

	private int magicForce;// field to store the incoming magicForce integer
	
	public Staff(int strength, int force) {//constructor that uses the super constructor to set the strength and sets the magicForce field equal to the incoming force
		super(strength);
		
		magicForce = force;
		
	}

	@Override
	public int getMagicalForce() {//overrides interface's getMagicForce method to return the magicForce field
		return magicForce;
	}
	
	@Override
	public boolean equals(Object o){//method to check if two Staffs are the same
		if(o instanceof Staff){//checks if both are of type staff
			if(((Staff) o).getMagicalForce() == magicForce && super.equals(o)){//checks if their strength and magicForce are the same
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Magic o){//method that overrides the compareTo method from the interface
		return magicForce - o.getMagicalForce();//returns the difference between the two magicForces
	}

	

	

}
