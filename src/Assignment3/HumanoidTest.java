package Assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HumanoidTest {

	/****************
	 * Test Wizards *
	 ****************/

	@Test
	public void testWizardsAreHumanoids() {
		Staff staff = new Staff(25, 40);
		Wizard wizard = new Wizard("Gandalf", staff);
		assertTrue(wizard instanceof Humanoid);

	}

	@Test
	public void testWizardEquals() {
		Staff staff1, staff2;
		Wizard wizard1, wizard2;
		boolean actual;

		// equal to self
		staff1 = new Staff(84, 67);
		wizard1 = new Wizard("Dumbledore", staff1);
		actual = wizard1.equals(wizard1);
		assertTrue("Incorrect result", actual);

		// equal to Wizard with same staff, name
		staff1 = new Staff(35, 47);
		staff2 = new Staff(35, 47);
		wizard1 = new Wizard("Dumbledore", staff1);
		wizard2 = new Wizard("Dumbledore", staff2);
		actual = wizard1.equals(wizard2);
		assertTrue("Incorrect result", actual);

	}

	@Test
	public void testWizardNotEqual() {
		Staff staff1, staff2;
		Wizard wizard1, wizard2;
		boolean actual;

		// not equal to Wizard with different name
		staff1 = new Staff(74, 47);
		staff2 = new Staff(74, 47);
		wizard1 = new Wizard("Voldemort", staff1);
		wizard2 = new Wizard("Sirius", staff2);
		actual = wizard1.equals(wizard2);
		assertFalse("Incorrect result", actual);

		// not equal to Wizard with different Staff
		staff1 = new Staff(74, 47);
		staff2 = new Staff(73, 57);
		wizard1 = new Wizard("Voldemort", staff1);
		wizard2 = new Wizard("Voldemort", staff2);
		actual = wizard1.equals(wizard2);
		assertFalse("Incorrect result", actual);

		// not equal to wizard with different name + Staff
		staff1 = new Staff(74, 47);
		staff2 = new Staff(73, 57);
		wizard1 = new Wizard("Voldemort", staff1);
		wizard2 = new Wizard("Bellatrix", staff2);
		actual = wizard1.equals(wizard2);
		assertFalse("Incorrect result", actual);

		// not equal to null
		staff1 = new Staff(74, 47);
		wizard1 = new Wizard("Voldemort", staff1);
		actual = wizard1.equals(null);
		assertFalse("Incorrect result", actual);

		// not equal to some other object
		staff1 = new Staff(74, 47);
		wizard1 = new Wizard("Voldemort", staff1);
		actual = wizard1.equals("A Wizard");
		assertFalse("Incorrect result", actual);

	}

	@Test
	public void testWizardGetStaff() {
		Staff staff1, staff2;
		Wizard wizard;
		int expected, actual;

		staff1 = new Staff(29, 62);
		wizard = new Wizard("Harry", staff1);

		staff2 = wizard.getStaff();

		actual = staff2.getMagicalForce();
		expected = 62;
		assertEquals("Incorrect result", expected, actual);

		actual = staff2.getStrength();
		expected = 29;
		assertEquals("Incorrect result", expected, actual);

	}

	/****************
	 * Test Hobbits *
	 ****************/

	@Test
	public void testHobbitsAreHumanoids() {
		Sword sword = new Sword(25, 40);
		Hobbit hobbit = new Hobbit("Pippin", sword);
		assertTrue(hobbit instanceof Humanoid);

	}

	@Test
	public void testHobbitEquals() {
		Sword sword1, sword2;
		Hobbit hobbit1, hobbit2;
		boolean actual;

		// equal to self
		sword1 = new Sword(84, 67);
		hobbit1 = new Hobbit("Frodo", sword1);
		actual = hobbit1.equals(hobbit1);
		assertTrue("Incorrect result", actual);

		// equal to Hobbit with same sword, name
		sword1 = new Sword(35, 47);
		sword2 = new Sword(35, 47);
		hobbit1 = new Hobbit("Frodo", sword1);
		hobbit2 = new Hobbit("Frodo", sword2);
		actual = hobbit1.equals(hobbit2);
		assertTrue("Incorrect result", actual);

	}

	@Test
	public void testHobbitNotEqual() {
		Sword sword1, sword2;
		Hobbit hobbit1, hobbit2;
		boolean actual;

		// not equal to Hobbit with different name
		sword1 = new Sword(74, 47);
		sword2 = new Sword(74, 47);
		hobbit1 = new Hobbit("Samwise", sword1);
		hobbit2 = new Hobbit("Bilbo", sword2);
		actual = hobbit1.equals(hobbit2);
		assertFalse("Incorrect result", actual);

		// not equal to Hobbit with different Sword
		sword1 = new Sword(74, 47);
		sword2 = new Sword(73, 57);
		hobbit1 = new Hobbit("Samwise", sword1);
		hobbit2 = new Hobbit("Samwise", sword2);
		actual = hobbit1.equals(hobbit2);
		assertFalse("Incorrect result", actual);

		// not equal to hobbit with different name + Sword
		sword1 = new Sword(74, 47);
		sword2 = new Sword(73, 57);
		hobbit1 = new Hobbit("Samwise", sword1);
		hobbit2 = new Hobbit("Rosie", sword2);
		actual = hobbit1.equals(hobbit2);
		assertFalse("Incorrect result", actual);

		// not equal to null
		sword1 = new Sword(74, 47);
		hobbit1 = new Hobbit("Samwise", sword1);
		actual = hobbit1.equals(null);
		assertFalse("Incorrect result", actual);

		// not equal to some other object
		sword1 = new Sword(74, 47);
		hobbit1 = new Hobbit("Samwise", sword1);
		actual = hobbit1.equals("A Hobbit");
		assertFalse("Incorrect result", actual);

	}

	@Test
	public void testHobbitGetSword() {
		Sword sword1, sword2;
		Hobbit hobbit;
		int expected, actual;

		sword1 = new Sword(29, 62);
		hobbit = new Hobbit("Hamfast", sword1);

		sword2 = hobbit.getSword();

		actual = sword2.getMagicalForce();
		expected = 62;
		assertEquals("Incorrect result", expected, actual);

		actual = sword2.getStrength();
		expected = 29;
		assertEquals("Incorrect result", expected, actual);

	}

	/**************
	 * Test Elves *
	 **************/

	@Test
	public void testElfsAreHumanoids() {
		Bow bow = new Bow(20);
		Elf elf = new Elf("Celeborn", bow);
		assertTrue(elf instanceof Humanoid);

	}

	@Test
	public void testElfEquals() {
		Bow bow1, bow2;
		Elf elf1, elf2;
		boolean actual;

		// equal to self
		bow1 = new Bow(87);
		elf1 = new Elf("Legolas", bow1);
		actual = elf1.equals(elf1);
		assertTrue("Incorrect result", actual);

		// equal to Elf with same bow, name
		bow1 = new Bow(37);
		bow2 = new Bow(37);
		elf1 = new Elf("Legolas", bow1);
		elf2 = new Elf("Legolas", bow2);
		actual = elf1.equals(elf2);
		assertTrue("Incorrect result", actual);

	}

	@Test
	public void testElfNotEqual() {
		Bow bow1, bow2;
		Elf elf1, elf2;
		boolean actual;

		// not equal to Elf with different name
		bow1 = new Bow(77);
		bow2 = new Bow(77);
		elf1 = new Elf("Galdriel", bow1);
		elf2 = new Elf("Gil-galad", bow2);
		actual = elf1.equals(elf2);
		assertFalse("Incorrect result", actual);

		// not equal to Elf with different Bow
		bow1 = new Bow(74);
		bow2 = new Bow(57);
		elf1 = new Elf("Galdriel", bow1);
		elf2 = new Elf("Galdriel", bow2);
		actual = elf1.equals(elf2);
		assertFalse("Incorrect result", actual);

		// not equal to elf with different name + Bow
		bow1 = new Bow(74);
		bow2 = new Bow(57);
		elf1 = new Elf("Galdriel", bow1);
		elf2 = new Elf("Haldir", bow2);
		actual = elf1.equals(elf2);
		assertFalse("Incorrect result", actual);

		// not equal to null
		bow1 = new Bow(77);
		elf1 = new Elf("Galdriel", bow1);
		actual = elf1.equals(null);
		assertFalse("Incorrect result", actual);

		// not equal to some other object
		bow1 = new Bow(77);
		elf1 = new Elf("Galdriel", bow1);
		actual = elf1.equals("A Elf");
		assertFalse("Incorrect result", actual);

	}

	@Test
	public void testElfGetBow() {
		Bow bow1, bow2;
		Elf elf;
		int expected, actual;

		bow1 = new Bow(29);
		elf = new Elf("Hamfast", bow1);

		bow2 = elf.getBow();

		actual = bow2.getStrength();
		expected = 29;
		assertEquals("Incorrect result", expected, actual);

	}

	/******************
	 * Test Humanoids *
	 ******************/

	@Test
	public void testHumanoidDefaultConstructor() {
		Humanoid human = new Humanoid();
		assertTrue(human instanceof Humanoid);

	}

	@Test
	public void testHumanoidEquals() {
		Humanoid human1, human2;
		boolean actual;

		// test equal to self
		human1 = new Humanoid("Dumbledore");
		actual = human1.equals(human1);
		assertTrue("Incorrect result", actual);

		// test equal to equivalent Humaniod
		human1 = new Humanoid("Frodo");
		human2 = new Humanoid("Frodo");
		actual = human1.equals(human2);
		assertTrue("Incorrect result", actual);
	}

	@Test
	public void testHumanoidNotEquals() {
		Humanoid human1, human2;
		boolean actual;

		// not equal to Humanoid with different name
		human1 = new Humanoid("Atreyu");
		human2 = new Humanoid("Artax");
		actual = human1.equals(human2);
		assertFalse("Incorrect result", actual);

		// not equal to null
		human1 = new Humanoid("Atreyu");
		actual = human1.equals(null);
		assertFalse("Incorrect result", actual);

		// not equal to some other object
		human1 = new Humanoid("Atreyu");
		actual = human1.equals("A Humanoid");
		assertFalse("Incorrect result", actual);

	}

	@Test
	public void testHumanoidGetName() {
		Humanoid[] humans = new Humanoid[5];
		Staff staff = new Staff(5, 10);
		Sword sword = new Sword(15, 20);
		Bow bow = new Bow(25);
		String expected, actual;

		humans[0] = new Wizard("Sarumon", staff);
		humans[1] = new Hobbit("Bilbo", sword);
		humans[2] = new Elf("Legolas", bow);
		humans[3] = new Humanoid("Gimli");
		humans[4] = new Humanoid();

		actual = humans[0].getName();
		expected = "Sarumon";
		assertEquals("Incorrect result", expected, actual);

		actual = humans[1].getName();
		expected = "Bilbo";
		assertEquals("Incorrect result", expected, actual);

		actual = humans[2].getName();
		expected = "Legolas";
		assertEquals("Incorrect result", expected, actual);

		actual = humans[3].getName();
		expected = "Gimli";
		assertEquals("Incorrect result", expected, actual);

		actual = humans[4].getName();
		expected = "Human";
		assertEquals("Incorrect result", expected, actual);

	}

}
