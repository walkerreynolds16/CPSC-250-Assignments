package Assignment3;

public class Elf extends Humanoid {//extends Humanoid to get all of its methods and fields
	
	private Bow bow;// field the holds the incoming bow
	
	public Elf(String name, Bow bow){//constructor that uses the super constructor to set the name and sets the bow field equal to the incoming bow
		super(name);
		
		this.bow = bow;
	}
	
	public Bow getBow(){// return the bow field
		return bow;
	}
	
	public boolean equals(Object o){//method to check if 2 elfs are the same
		if(o instanceof Elf){//checks if both are of type elf
			if(((Elf) o).getBow().equals(bow) && super.equals(o)){//checks if their names are the same and if their bows are the same
				return true;
			}
		}
		
		return false;
	}

}
