package Assignment4;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RobotShortTest {

	private final String EOL = System.getProperty("line.separator");
	private static String INPUT = "input.txt";
	private static String OUTPUT = "output.txt";

	private PrintStream console;
	private ByteArrayOutputStream buffer;

	@Before
	public void thisMethodRunsBeforeEachTest() {
		// redirect output to a stream
		console = System.out;
		buffer = new ByteArrayOutputStream();
		System.setOut(new PrintStream(buffer));
	}

	@After
	public void thisMethodRunsAfterEachTest() {
		// return console to its rightful owner
		System.setOut(console);
	}

	/*
	 * Testing bad input
	 */

	@Test
	public void testNoInputFile() {
		INPUT = "input35.txt";
		OUTPUT = "output35.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);
		// delete I/O file (if one existed)
		inputFile.delete();
		outputFile.delete();

		// invoke program
		Robot.readInstructions(INPUT, OUTPUT);
		// program should print to console: "Input file not found."
		final String FILE_NOT_FOUND = "Input file not found." + EOL;
		assertEquals(FILE_NOT_FOUND, buffer.toString());
	}

	/*
	 * Testing Correct Non-Destruction Instructions
	 */

	@Test
	public void testOneLineWithNoCommands() {
		try {
			INPUT = "input36.txt";
			OUTPUT = "output36.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("9   8  7   6"); //deployment, no instruction
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and is correct
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was likely not closed in program.", output.hasNext());
			String actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 6", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			assertTrue(outputFile.delete());

			// your program should not print anything to the console.
			assertEquals("", buffer.toString());
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}

	@Test
	public void testMultiLineManyTests() {
		try {
			INPUT = "input37.txt";
			OUTPUT = "output37.txt";

			File inputFile = new File(INPUT);
			File outputFile = new File(OUTPUT);

			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 4"); //8 5
			input.println("7 6 5 4 E 1 E 1 E 1 E 1"); //terminated
			input.println("9 7 1 1 S 1 E 1 S 1 E 1 S 1 E 1 S 1 E 1 N 3 W 3 E 1"); //2 3
			input.println("4 5 7 3 S 2 W 5"); //terminated
			input.println("9 8 3 6 S 2 S 3 N 1"); //7 6
			input.println("9 12 7 4 E 3 E 2 E 1"); //7 10
			input.println("10 10 5 5 E 2 N 3 E 1 S 2 W 3 N 2 S 6"); //8 5
			input.println("7 6 5 4 S 1 W 3 E 2 N 5 N 3"); //terminated
			input.close();

			// invoke program
			Robot.readInstructions(INPUT, OUTPUT);

			// verify OUTPUT file exists and has values
			assertTrue(outputFile.exists());
			Scanner output = new Scanner(outputFile);
			assertTrue("Output file was likely not closed in program.", output.hasNext());
			String actual;
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "8 5", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "2 3", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 6", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "7 10", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "8 5", actual);
			actual = output.nextLine();
			assertEquals("Expected value in output file doesn't match.", "terminated", actual);
			assertFalse("There should not be more data in output file.", output.hasNext());
			output.close();

			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			assertTrue(outputFile.delete());

			// your program should not print anything to the console.
			assertEquals("", buffer.toString());
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		}
	}
	
	@Test
	public void testMultiLineOkExceptionDestroyed() {
		INPUT = "input38.txt";
		OUTPUT = "output38.txt";

		File inputFile = new File(INPUT);
		File outputFile = new File(OUTPUT);

		try {
			// create INPUT file
			PrintWriter input = new PrintWriter(inputFile);
			input.println("12 15 6 8 N 1 W 3 S 4 N 2 E 2 N 2 E 2 S 3 W 4"); //this is OK
			input.println("7 ! 5 E 3 4"); //this is bad
			input.println("7 6 5 4 E 1 E 1 E 1 E 1"); //this should not execute
			input.close();

			// invoke program, should throw exception
			Robot.readInstructions(INPUT, OUTPUT);
			fail("InvalidRobotInstructionException should be thrown.");
		} catch (IOException e) {
			fail("No IOException should be thrown in this Robot scenario.");
		} catch (InvalidRobotInstructionException e) {
			// delete I/O files (if they exist)
			assertTrue("Input file was not closed in program.", inputFile.delete());
			try { // outputFile should still contain data from previous correct
					// experiments
				assertTrue(outputFile.exists());
				Scanner output = new Scanner(outputFile);
				assertTrue("Output file was likely not closed in program.", output.hasNext());
				String actual;
				actual = output.nextLine();
				assertEquals("Expected value in output file doesn't match.", "8 5", actual);
				assertFalse("There should not be more data in output file.", output.hasNext());
				output.close();
				outputFile.delete();

			} catch (IOException e2) {
				fail("No IOException should be thrown in this Robot scenario.");
			}
		}
	}
}
