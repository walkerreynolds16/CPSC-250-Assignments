package Assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordSearchTest {

private final static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static boolean containsOriginalWords(String originalGrid, String filledGrid){
		
		for(int i = 0; i < originalGrid.length(); i++){
			if(letters.contains("" + originalGrid.charAt(i))){
				if(originalGrid.charAt(i) != filledGrid.charAt(i)){
					return false;
				}
				
			}
		}
		
		return true;
	}
	
	/*****************************************
	 * Test Constructors
	 *****************************************/
	
	@Test
	public void testGridStringDefault() {
		WordSearch search = new WordSearch();
		String actual = search.gridToString();
		String expected = "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		assertEquals("Issue with default constructor and use of - character",expected, actual);
	}
		
	@Test
	public void testGridStringConstructed() {
		WordSearch search = new WordSearch(5,3);
		String actual = search.gridToString();
		String expected = "- - -\n"
						+ "- - -\n"
						+ "- - -\n"
						+ "- - -\n"
						+ "- - -\n";
		assertEquals("Issue with constructor and use of - character",expected, actual);
	}
	
	@Test
	public void testWordStringEmpty(){
		WordSearch search = new WordSearch(5,3);
		String actual = search.wordsToString();
		String expected = "";
		assertEquals("list of words should be an empty array list after construction", expected, actual);
	}
	
	/*****************************************
	 * Test Horizontal Adds
	 *****************************************/
	
	@Test
	public void testAddOneWordHorizontallyBeginning() {
		WordSearch search = new WordSearch();
		Boolean add = search.addWordH(0, 0, "APPLES");
		String expected = "A P P L E S - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		String actual = search.gridToString();
		assertTrue("Should return true for correct add", add);
		assertEquals("Word not added correctly horizontally", expected, actual);
	}
	
	@Test
	public void testAddOneWordHorizontallyNoFit() {
		WordSearch search = new WordSearch();
		Boolean add = search.addWordH(2, 5, "APPLES");
		String expected = "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		String actual = search.gridToString();
		assertFalse("Should return false, word does not fit",add);
		assertEquals("Word should not be added horizontally", expected, actual);
	}
	
	@Test
	public void testAddOneWordHorizontallyBadWord() {
		WordSearch search = new WordSearch();
		Boolean add = search.addWordH(1, 1, "APPLES!");
		String expected = "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		String actual = search.gridToString();
		assertFalse("Should return false, word contains non-letter", add);
		assertEquals("Word should not be added horizontally",  expected, actual);
	}
	
	/*****************************************
	 * Test Vertical Adds
	 *****************************************/
	
	
	@Test
	public void testAddOneWordVerticallyBeginning() {
		WordSearch search = new WordSearch();
		Boolean add = search.addWordV(0, 0, "PUPPY");
		String expected = "P - - - - - - - - -\n"
						+ "U - - - - - - - - -\n"
						+ "P - - - - - - - - -\n"
						+ "P - - - - - - - - -\n"
						+ "Y - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		String actual = search.gridToString();
		assertTrue("Should return true for correct add", add);
		assertEquals("Word not added correctly vertically",expected, actual);
	}
	
	@Test
	public void testAddOneWordVerticallyNoFit() {
		WordSearch search = new WordSearch();
		Boolean add = search.addWordV(7, 3, "PUPPY");
		String expected = "- - - - - - - - - -\n"
				 		+ "- - - - - - - - - -\n"
				 		+ "- - - - - - - - - -\n"
				 		+ "- - - - - - - - - -\n"
				 		+ "- - - - - - - - - -\n"
				 		+ "- - - - - - - - - -\n"
				 		+ "- - - - - - - - - -\n"
				 		+ "- - - - - - - - - -\n"
				 		+ "- - - - - - - - - -\n"
				 		+ "- - - - - - - - - -\n";
		String actual = search.gridToString();
		assertFalse("Should return false, word does not fit", add);
		assertEquals("Word should not be added vertically", expected, actual);
	}
	
	@Test
	public void testAddOneWordVerticallyBadWord() {
		WordSearch search = new WordSearch();
		Boolean add = search.addWordV(1, 1, "*PUPPY*");
		String expected = "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		String actual = search.gridToString();
		assertFalse("Should return false, word contains non-letter", add);
		assertEquals("Word should not be added vertically", expected, actual);
	}
	
	/*****************************************
	 * Test Diagonal Adds
	 *****************************************/
	
	@Test
	public void testAddOneWordDiagonallyBeginning() {
		WordSearch search = new WordSearch();
		Boolean add = search.addWordD(0, 0, "FLOWER");
		String expected = "F - - - - - - - - -\n"
						+ "- L - - - - - - - -\n"
						+ "- - O - - - - - - -\n"
						+ "- - - W - - - - - -\n"
						+ "- - - - E - - - - -\n"
						+ "- - - - - R - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		String actual = search.gridToString();
		assertTrue("Should return true for correct add", add);
		assertEquals("Word not added correctly diagonally", expected, actual);
	}
	
	@Test
	public void testAddOneWordDiagonallyNoFit() {
		WordSearch search = new WordSearch();
		Boolean add = search.addWordD(7, 5, "FLOWER");
		String expected = "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		String actual = search.gridToString();
		assertFalse("Should return false, word does not fit", add);
		assertEquals("Word should not be added diagonally", expected, actual);
	}
	
	
	@Test
	public void testAddOneWordDiagonallyBadWord() {
		WordSearch search = new WordSearch();
		Boolean add = search.addWordH(1, 1, "#FLOWER");
		String expected = "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		String actual = search.gridToString();
		assertFalse("Should return false, word contains non-letter", add);
		assertEquals("Word should not be added diagonally", expected, actual);
	}
	
	/*****************************************
	 * Test Fills
	 *****************************************/
	
	@Test
	public void testFillEmpty(){
		WordSearch search = new WordSearch();
		search.fillIn();
		String grid = search.gridToString();
		int actual = grid.indexOf('-');
		int expected = -1;
		assertEquals("grid contains -",expected, actual);
		
		//System.out.print(grid);
		grid = grid.trim();
		String lines[] = grid.split("\n");
		boolean correctFill = true;
		for(int i = 0; i < lines.length; i++){
			for(int k = 0; k < lines[i].length(); k+=2){
				if(!letters.contains("" + lines[i].charAt(k))){
					correctFill = false;
					break;
				}
			}
		}
		assertTrue("grid contains non-letter fill", correctFill);
	}
	
	
	@Test 
	public void testFillOneWordHorizontal(){
		WordSearch search = new WordSearch();
		search.addWordH(3, 3, "APPLES");
		String originalGrid = "- - - - - - - - - -\n"
							+ "- - - - - - - - - -\n"
							+ "- - - - - - - - - -\n"
							+ "- - - A P P L E S -\n"
							+ "- - - - - - - - - -\n"
							+ "- - - - - - - - - -\n"
							+ "- - - - - - - - - -\n"
							+ "- - - - - - - - - -\n"
							+ "- - - - - - - - - -\n"
							+ "- - - - - - - - - -\n";
		search.fillIn();
		String grid = search.gridToString();
		
		int actual = grid.indexOf('-');
		int expected = -1;
		assertEquals("grid contains -",expected, actual);
		
		assertTrue("grid does not contain word APPLES", WordSearchTest.containsOriginalWords(originalGrid, grid));
		
		//System.out.print(grid);
		grid = grid.trim();
		String lines[] = grid.split("\n");
		boolean correctFill = true;
		for(int i = 0; i < lines.length; i++){
			for(int k = 0; k < lines[i].length(); k+=2){
				if(!letters.contains("" + lines[i].charAt(k))){
					correctFill = false;
					break;
				}
			}
		}
		assertTrue("grid contains non-letter fill", correctFill);
	}
	

	/*****************************************
	 * Test Words in the Way
	 *****************************************/
	
	@Test
	public void testOneLetterCross(){
		WordSearch search = new WordSearch();
		search.addWordD(1, 2, "FLOWER");
		boolean addCross = search.addWordV(2,5, "PUPPY");
		
		String expected = "- - - - - - - - - -\n"
						+ "- - F - - - - - - -\n"
						+ "- - - L - - - - - -\n"
						+ "- - - - O - - - - -\n"
						+ "- - - - - W - - - -\n"
						+ "- - - - - - E - - -\n"
						+ "- - - - - - - R - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		
		String actual = search.gridToString();
		assertFalse("Should return false, word would overwrite another word",addCross);
		assertEquals("Word should not be added, overwrites another word",expected, actual);
		
	}
	
	@Test
	public void testMultiLetterCross(){
		WordSearch search = new WordSearch();
		search.addWordH(3, 3, "APPLES");
		boolean addCross = search.addWordH(3, 1, "ORANGES");
		String expected = "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - A P P L E S -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - - - - - - - -\n";
		
		String actual = search.gridToString();
		assertFalse("Should return false, word would overwrite another word",addCross);
		assertEquals("Word should not be added, overwrites another word",expected, actual);
		
	}
	
	/*****************************************
	 * Test add multiple words
	 *****************************************/
	
	@Test
	public void testTwoWordsAdd(){		
		WordSearch search = new WordSearch();
		search.addWordD(1, 2, "FLOWER");
		search.addWordH(8,2, "APPLES");
		
		String expected = "- - - - - - - - - -\n"
						+ "- - F - - - - - - -\n"
						+ "- - - L - - - - - -\n"
						+ "- - - - O - - - - -\n"
						+ "- - - - - W - - - -\n"
						+ "- - - - - - E - - -\n"
						+ "- - - - - - - R - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - A P P L E S - -\n"
						+ "- - - - - - - - - -\n";
		
		String actual = search.gridToString();
		assertEquals("Two words should be added: FLOWER and APPLES", expected, actual);
		
	}
	
	@Test
	public void testTwoWordsFill(){
		WordSearch search = new WordSearch();
		search.addWordD(1, 2, "FLOWER");
		search.addWordH(8,2, "APPLES");
		
		String originalGrid = "- - - - - - - - - -\n"
							+ "- - F - - - - - - -\n"
							+ "- - - L - - - - - -\n"
							+ "- - - - O - - - - -\n"
							+ "- - - - - W - - - -\n"
							+ "- - - - - - E - - -\n"
							+ "- - - - - - - R - -\n"
							+ "- - - - - - - - - -\n"
							+ "- - A P P L E S - -\n"
							+ "- - - - - - - - - -\n";
		
		search.fillIn();
		String grid = search.gridToString();
		
		int actual = grid.indexOf('-');
		int expected = -1;
		assertEquals("grid contains -",expected, actual);
		
		assertTrue("grid does not contain words FLOWER and APPLES", WordSearchTest.containsOriginalWords(originalGrid, grid));
		
		//System.out.print(grid);
		grid = grid.trim();
		String lines[] = grid.split("\n");
		boolean correctFill = true;
		for(int i = 0; i < lines.length; i++){
			for(int k = 0; k < lines[i].length(); k+=2){
				if(!letters.contains("" + lines[i].charAt(k))){
					correctFill = false;
					break;
				}
			}
		}
		assertTrue("grid contains non-letter fill", correctFill);
		
	}
	
	@Test
	public void testWordAlreadyAdded(){
		WordSearch search = new WordSearch();
		search.addWordD(1, 2, "FLOWER");
		search.addWordH(8,3, "APPLES");
		search.addWordV(4, 1, "CAT");
		boolean addRepeat = search.addWordV(0,8, "APPLES");
		
		assertFalse("APPLES should not be added twice", addRepeat);
		
		String expected = "- - - - - - - - - -\n"
						+ "- - F - - - - - - -\n"
						+ "- - - L - - - - - -\n"
						+ "- - - - O - - - - -\n"
						+ "- C - - - W - - - -\n"
						+ "- A - - - - E - - -\n"
						+ "- T - - - - - R - -\n"
						+ "- - - - - - - - - -\n"
						+ "- - - A P P L E S -\n"
						+ "- - - - - - - - - -\n";
		
		String actual = search.gridToString();
		assertEquals("APPLES should be on board only once after duplicate add", expected, actual);
		
	}
}
