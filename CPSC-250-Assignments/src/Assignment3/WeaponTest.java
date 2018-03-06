package Assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeaponTest {

	/***************
	 * Test Staffs *
	 ***************/

	@Test
	public void testStaffsAreWeapons() {
		Staff staff = new Staff(25, 40);
		assertTrue(staff instanceof Weapon);
	}

	@Test
	public void testStaffsAreMagic() {
		Staff staff = new Staff(25, 40);
		assertTrue(staff instanceof Magic);
	}

	@Test
	public void testStaffEquals() {
		Staff staff1, staff2;
		boolean actual;

		// equal to itself
		staff1 = new Staff(25, 40);
		actual = staff1.equals(staff1);
		assertTrue("Incorrect result", actual);

		// equal to another Staff same force and strength
		staff1 = new Staff(75, 60);
		staff2 = new Staff(75, 60);
		actual = staff1.equals(staff2);
		assertTrue("Incorrect result", actual);
	}

	@Test
	public void testStaffNotEquals() {
		Staff staff1, staff2;
		boolean actual;

		// not equal to Staff with different force
		staff1 = new Staff(25, 40);
		staff2 = new Staff(25, 86);
		actual = staff1.equals(staff2);
		assertFalse("Incorrect result", actual);

		// not equal to Staff with different strength
		staff1 = new Staff(25, 40);
		staff2 = new Staff(17, 40);
		actual = staff1.equals(staff2);
		assertFalse("Incorrect result", actual);

		// not equal to Staff with different strength + force
		staff1 = new Staff(25, 40);
		staff2 = new Staff(17, 56);
		actual = staff1.equals(staff2);
		assertFalse("Incorrect result", actual);

		// not equal to null
		staff1 = new Staff(25, 40);
		actual = staff1.equals(null);
		assertFalse("Incorrect result", actual);

		// not equal to some other object
		staff1 = new Staff(25, 40);
		actual = staff1.equals("A Staff");
		assertFalse("Incorrect result", actual);

	}

	@Test
	public void testStaffCompareToStaff() {
		Staff staff1, staff2;
		int expected, actual;

		// compare to same Staff
		staff1 = new Staff(25, 40);
		actual = staff1.compareTo(staff1);
		expected = 0;
		assertEquals("Incorrect result", expected, actual);

		// compare to Staff same force
		staff1 = new Staff(25, 40);
		staff2 = new Staff(46, 40);
		actual = staff1.compareTo(staff2);
		expected = 0;
		assertEquals("Incorrect result", expected, actual);

		// compare to equal Staff
		staff1 = new Staff(25, 40);
		staff2 = new Staff(25, 40);
		actual = staff1.compareTo(staff2);
		expected = 0;
		assertEquals("Incorrect result", expected, actual);

		// compare to weaker Staff
		staff1 = new Staff(25, 40);
		staff2 = new Staff(46, 17);
		actual = staff1.compareTo(staff2);
		expected = 23;
		assertEquals("Incorrect result", expected, actual);

		// compare to stronger Staff
		staff1 = new Staff(25, 40);
		staff2 = new Staff(46, 54);
		actual = staff1.compareTo(staff2);
		expected = -14;
		assertEquals("Incorrect result", expected, actual);

	}

	@Test
	public void testStaffCompareToSword() {
		Staff staff;
		Sword sword;
		int expected, actual;

		// compare to Sword with same force
		staff = new Staff(25, 40);
		sword = new Sword(30, 40);
		actual = staff.compareTo(sword);
		expected = 0;
		assertEquals("Incorrect result", expected, actual);

		// compare to weaker Sword
		staff = new Staff(25, 40);
		sword = new Sword(30, 16);
		actual = staff.compareTo(sword);
		expected = 24;
		assertEquals("Incorrect result", expected, actual);

		// compare to stronger Sword
		staff = new Staff(25, 40);
		sword = new Sword(30, 67);
		actual = staff.compareTo(sword);
		expected = -27;
		assertEquals("Incorrect result", expected, actual);

	}

	@Test
	public void testStaffGetMagicalForce() {
		Staff staff = new Staff(85, 67);
		int actual = staff.getMagicalForce();
		int expected = 67;
		assertEquals("Incorrect result", expected, actual);
	}

	/***************
	 * Test Swords *
	 ***************/

	@Test
	public void testSwordsAreWeapons() {
		Sword sword = new Sword(20, 45);
		assertTrue(sword instanceof Weapon);
	}

	@Test
	public void testSwordsAreMagic() {
		Sword sword = new Sword(20, 45);
		assertTrue(sword instanceof Magic);
	}

	@Test
	public void testSwordEquals() {
		Sword sword1, sword2;
		boolean actual;

		// equal to itself
		sword1 = new Sword(20, 45);
		actual = sword1.equals(sword1);
		assertTrue("Incorrect result", actual);

		// equal to another Sword same force and strength
		sword1 = new Sword(75, 60);
		sword2 = new Sword(75, 60);
		actual = sword1.equals(sword2);
		assertTrue("Incorrect result", actual);
	}

	@Test
	public void testSwordNotEquals() {
		Sword sword1, sword2;
		boolean actual;

		// not equal to Sword with different force
		sword1 = new Sword(20, 45);
		sword2 = new Sword(20, 86);
		actual = sword1.equals(sword2);
		assertFalse("Incorrect result", actual);

		// not equal to Sword with different strength
		sword1 = new Sword(20, 45);
		sword2 = new Sword(17, 45);
		actual = sword1.equals(sword2);
		assertFalse("Incorrect result", actual);

		// not equal to Sword with different strength + force
		sword1 = new Sword(20, 45);
		sword2 = new Sword(17, 56);
		actual = sword1.equals(sword2);
		assertFalse("Incorrect result", actual);

		// not equal to null
		sword1 = new Sword(20, 45);
		actual = sword1.equals(null);
		assertFalse("Incorrect result", actual);

		// not equal to some other object
		sword1 = new Sword(20, 45);
		actual = sword1.equals("A Sword");
		assertFalse("Incorrect result", actual);

	}

	@Test
	public void testSwordCompareToSword() {
		Sword sword1, sword2;
		int expected, actual;

		// compare to same Sword
		sword1 = new Sword(20, 45);
		actual = sword1.compareTo(sword1);
		expected = 0;
		assertEquals("Incorrect result", expected, actual);

		// compare to Sword same force
		sword1 = new Sword(20, 45);
		sword2 = new Sword(46, 45);
		actual = sword1.compareTo(sword2);
		expected = 0;
		assertEquals("Incorrect result", expected, actual);

		// compare to equal Sword
		sword1 = new Sword(20, 45);
		sword2 = new Sword(20, 45);
		actual = sword1.compareTo(sword2);
		expected = 0;
		assertEquals("Incorrect result", expected, actual);

		// compare to weaker Sword
		sword1 = new Sword(20, 45);
		sword2 = new Sword(46, 17);
		actual = sword1.compareTo(sword2);
		expected = 28;
		assertEquals("Incorrect result", expected, actual);

		// compare to stronger Sword
		sword1 = new Sword(20, 45);
		sword2 = new Sword(46, 54);
		actual = sword1.compareTo(sword2);
		expected = -9;
		assertEquals("Incorrect result", expected, actual);

	}

	@Test
	public void testSwordGetMagicalForce() {
		Sword sword = new Sword(83, 27);
		int actual = sword.getMagicalForce();
		int expected = 27;
		assertEquals("Incorrect result", expected, actual);
	}

	@Test
	public void testSwordCompareToStaff() {
		Sword sword;
		Staff staff;
		int expected, actual;

		// compare to Staff with same force
		sword = new Sword(20, 45);
		staff = new Staff(30, 45);
		actual = sword.compareTo(staff);
		expected = 0;
		assertEquals("Incorrect result", expected, actual);

		// compare to weaker Staff
		sword = new Sword(20, 45);
		staff = new Staff(30, 16);
		actual = sword.compareTo(staff);
		expected = 29;
		assertEquals("Incorrect result", expected, actual);

		// compare to stronger Staff
		sword = new Sword(20, 45);
		staff = new Staff(30, 67);
		actual = sword.compareTo(staff);
		expected = -22;
		assertEquals("Incorrect result", expected, actual);

	}

	/*************
	 * Test Bows *
	 *************/

	@Test
	public void testBowsAreWeapons() {
		Bow bow = new Bow(37);
		assertTrue(bow instanceof Weapon);
	}

	@Test
	public void testBowEquals() {
		Bow bow1, bow2;
		boolean actual;

		// equal to itself
		bow1 = new Bow(37);
		actual = bow1.equals(bow1);
		assertTrue("Incorrect result", actual);

		// equal to another Bow same strength
		bow1 = new Bow(63);
		bow2 = new Bow(63);
		actual = bow1.equals(bow2);
		assertTrue("Incorrect result", actual);
	}

	@Test
	public void testBowNotEquals() {
		Bow bow1, bow2;
		boolean actual;

		// not equal to Bow with different strength
		bow1 = new Bow(37);
		bow2 = new Bow(23);
		actual = bow1.equals(bow2);
		assertFalse("Incorrect result", actual);

		// not equal to null
		bow1 = new Bow(73);
		actual = bow1.equals(null);
		assertFalse("Incorrect result", actual);

		// not equal to some other object
		bow1 = new Bow(48);
		actual = bow1.equals("A Bow");
		assertFalse("Incorrect result", actual);

	}

	/****************
	 * Test Weapons *
	 ****************/

	@Test
	public void testWeaponGetStrength() {
		Weapon[] weapons = new Weapon[3];
		int expected, actual;

		weapons[0] = new Staff(23, 65);
		weapons[1] = new Sword(84, 56);
		weapons[2] = new Bow(93);

		actual = weapons[0].getStrength();
		expected = 23;
		assertEquals("Incorrect result", expected, actual);

		actual = weapons[1].getStrength();
		expected = 84;
		assertEquals("Incorrect result", expected, actual);

		actual = weapons[2].getStrength();
		expected = 93;
		assertEquals("Incorrect result", expected, actual);

	}

	@Test
	public void testWeaponChangeStrength() {
		Weapon[] weapons = new Weapon[3];
		int expected, actual;

		weapons[0] = new Staff(23, 65);
		weapons[1] = new Sword(84, 56);
		weapons[2] = new Bow(93);

		weapons[0].changeStrength(-45);
		actual = weapons[0].getStrength();
		expected = 0;
		assertEquals("Incorrect result", expected, actual);

		weapons[1].changeStrength(23);
		actual = weapons[1].getStrength();
		expected = 107;
		assertEquals("Incorrect result", expected, actual);

		weapons[2].changeStrength(-35);
		actual = weapons[2].getStrength();
		expected = 58;
		assertEquals("Incorrect result", expected, actual);

	}

}
