package Assignment3;

public class Wizard extends Humanoid {//extends Humanoid to get all of its methods and fields

	private Staff staff;// field to contain the staff
	
	public Wizard(String name, Staff staff){//constructor that uses super constructor to assign the name, and set the staff field to the input staff
		super(name);
		
		this.staff = staff;
	}
	
	public Staff getStaff(){//returns the staff field
		return staff;
	}
	
	@Override
	public boolean equals(Object o){//Overridden method to check if a Wizard equals another wizard
		if(o instanceof Wizard){//checks if both are of type wizard
			if(((Wizard) o).getStaff().equals(staff) && super.equals(o)){//checks if the name is the same and if the staff are the same
				return true;
			}
		}
		return false;
	}
	
}
