package Assignment3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class HumanoidArmyTest {

	@Test
	public void testConstructor() {
		HumanoidArmy army = new HumanoidArmy();
		assertTrue(army instanceof HumanoidArmy);

	}

	@Test
	public void testAddOneHumanoidSoldier() {
		int expected, actual;
		boolean actualBool;

		HumanoidArmy army = new HumanoidArmy();
		army.addSoldier(new Humanoid("Gimli"));

		ArrayList<Humanoid> armyList = army.getArmy();

		actual = armyList.size();
		expected = 1;
		assertEquals("Incorrect result", expected, actual);

		actualBool = armyList.contains(new Humanoid("Gimli"));
		assertTrue("Incorrect result", actualBool);

	}

	@Test
	public void testAddManyHumanoidSoldier() {
		Wizard wizard1, wizard2;
		Hobbit hobbit;
		Elf elf;
		HumanoidArmy army;
		ArrayList<Humanoid> armyList;
		int expected, actual;
		boolean actualBool;

		wizard1 = new Wizard("Dumbledore", new Staff(85, 23));
		wizard2 = new Wizard("Gandalf", new Staff(27, 42));
		hobbit = new Hobbit("Frodo", new Sword(34, 81));
		elf = new Elf("Legolas", new Bow(67));

		army = new HumanoidArmy();
		army.addSoldier(wizard1);
		army.addSoldier(wizard2);
		army.addSoldier(hobbit);
		army.addSoldier(elf);

		armyList = army.getArmy();

		actual = armyList.size();
		expected = 4;

		assertEquals("Incorrect result", expected, actual);

		actualBool = armyList.contains(wizard1);
		assertTrue("Incorrect result", actualBool);

		actualBool = armyList.contains(wizard2);
		assertTrue("Incorrect result", actualBool);

		actualBool = armyList.contains(hobbit);
		assertTrue("Incorrect result", actualBool);

		actualBool = armyList.contains(elf);
		assertTrue("Incorrect result", actualBool);

	}


}
