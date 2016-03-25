package Assignment3;

public abstract class Weapon {//class is abstract, its going to be extended by all the weapon sub-classes

	private int strength;//field that contains the strength of the weapon
	
	public Weapon(int strength){//constructor that sets the strength field equal to the incoming strength
		this.strength = strength;
	}
	
	public int getStrength(){//return the strength field
		return strength;
	}
	
	public void changeStrength(int change){//method that adds the change variable to the strength field 
		strength += change;// adds the change variable to the strength field
		
		if(strength < 0){//if the strength field is less than 0, we set it to 0 because we dont want the strength be negative
			strength = 0;
		}
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Weapon){
			if(((Weapon) o).getStrength() == strength){//checks if both weapons have the same strength
				return true;
			}
		}
		
		return false;
	}
}
