package Assignment3;

public class Humanoid {
	
	String name;// field that contains the humanoids name
	
	public Humanoid(){//constructor that assigns the field name to the default name "Human"
		name = "Human";
	}
	
	public Humanoid(String name){//constructor that assigns the field name to the input name
		this.name = name;
	}
	
	public String getName(){//returns the field name
		return name;
	}
	
	@Override
	public boolean equals(Object o){//Overridden method to check if a Humanoid equals another humanoid
		if(o instanceof Humanoid){//checks if both are of type Humanoid
			if(((Humanoid) o).getName().equals(name)){//checks if their names are equal
				return true;
			}
		}
		
		return false;
	}
}
