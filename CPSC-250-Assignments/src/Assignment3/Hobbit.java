package Assignment3;

public class Hobbit extends Humanoid{//extends humanoid  get all of its methods and fields

	private Sword sword;// field that stores inputed sword
	
	public Hobbit(String name, Sword sword){//constructor that uses super constructor to assign the name, and set the sword field to the input sword
		super(name);
		
		this.sword = sword;
	}
	
	public Sword getSword(){//returns the sword field
		return sword;
	}
	
	public boolean equals(Object o){//Overridden method to check if a Hobbit equals another hobbit
		if(o instanceof Hobbit){//checks if both are of type hobbit
			if(((Hobbit) o).getSword().equals(sword) && super.equals(o)){//checks if the name and the sword are the same for both hobbits
				return true;
			}
		}
		
		return false;
	}
}
