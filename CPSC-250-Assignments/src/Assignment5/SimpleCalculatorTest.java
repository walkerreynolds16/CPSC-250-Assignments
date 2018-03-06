package Assignment5;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class SimpleCalculatorTest {

	public static Queue<String> stringToQueue(String str) {
		Scanner scan = new Scanner(str);
		Queue<String> q = new Queue<String>();

		while (scan.hasNext()) {
			q.enqueue(scan.next());
		}

		scan.close();
		return q;

	}

	public static String queueToString(Queue<String> q) {
		String str = "";
		Queue<String> tmp = new Queue<String>();

		while (!q.isEmpty()) {
			String s = q.dequeue();
			tmp.enqueue(s);
			str += s + " ";
		}
		q = tmp;
		return str.trim();
	}

	/*
	 * Simple Infix to Postfix
	 */

	@Test
	public void simpleAddInfixToPostfix() {
		String expression = "( 2 + 3 )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "2 3 +", queueToString(q));
	}

	@Test
	public void simpleSubtractInfixToPostfix() {
		String expression = "( 7 - 2 )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "7 2 -", queueToString(q));
	}

	@Test
	public void simpleMultiplyInfixToPostfix() {
		String expression = "( 3 * 4 )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "3 4 *", queueToString(q));
	}

	@Test
	public void simpleDivideInfixToPostfix() {
		String expression = "( 10 / 2 )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "10 2 /", queueToString(q));
	}

	@Test
	public void simplePowerInfixToPostfix() {
		String expression = "( 2 ^ 3 )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "2 3 ^", queueToString(q));
	}
	
	/*
	 * Infix to Postfix
	 */

	@Test
	public void AddInfixToPostfix() {
		String expression = "( ( 2 + ( 3 + 1 ) ) + 5 )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "2 3 1 + + 5 +", queueToString(q));
	}

	@Test
	public void SubtractInfixToPostfix() {
		String expression = "( 12 - ( ( 7 - 4 ) - 3 ) )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "12 7 4 - 3 - -", queueToString(q));
	}

	@Test
	public void MultiplyInfixToPostfix() {
		String expression = "( 2 * ( 3 * ( 2 * 4 ) ) )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "2 3 2 4 * * *", queueToString(q));
	}

	@Test
	public void DivideInfixToPostfix() {
		String expression = "( ( ( 120 / 5 ) / 4 ) / 3 )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "120 5 / 4 / 3 /", queueToString(q));
	}

	@Test
	public void PowerInfixToPostfix() {
		String expression = "( ( 2 ^ 3 ) ^ 2 )";

		Queue<String> q = SimpleCalculator.infixToPostfix(stringToQueue(expression));

		assertEquals("Postfix not correct", "2 3 ^ 2 ^", queueToString(q));
	}
	
	@Test
	public void infixToPostfix1() {
		String expression = "( ( ( ( 3 ^ 4 ) / 9 ) - 1 ) / 3 )";
		Queue<String>  orig = stringToQueue(expression);
		Queue<String> q = SimpleCalculator.infixToPostfix(orig);

		assertEquals("Postfix not correct", "3 4 ^ 9 / 1 - 3 /", queueToString(q));
		
		//make sure queue is the same
		assertEquals("Queue was changed", "( ( ( ( 3 ^ 4 ) / 9 ) - 1 ) / 3 )", queueToString(orig));
	}

	@Test
	public void infixToPostfix2() {
		String expression = "( ( 7 + ( 5 - ( 1 + 2 ) ) ) - 4.5 )";
		Queue<String>  orig = stringToQueue(expression);
		Queue<String> q = SimpleCalculator.infixToPostfix(orig);

		assertEquals("Postfix not correct", "7 5 1 2 + - + 4.5 -", queueToString(q));
		
		//make sure queue is the same
		assertEquals("Queue was changed", "( ( 7 + ( 5 - ( 1 + 2 ) ) ) - 4.5 )", queueToString(orig));
	}

	@Test
	public void infixToPostfix3() {
		String expression = "( ( ( 3 - 1 ) + 12 ) / 7 )";
		Queue<String>  orig = stringToQueue(expression);
		Queue<String> q = SimpleCalculator.infixToPostfix(orig);

		assertEquals("Postfix not correct", "3 1 - 12 + 7 /", queueToString(q));
		
		//make sure queue is the same
		assertEquals("Queue was changed", "( ( ( 3 - 1 ) + 12 ) / 7 )", queueToString(orig));
	}

	@Test
	public void infixToPostfix4() {
		String expression = "( 24 - ( 4 + ( 2 ^ 3 ) ) )";
		Queue<String>  orig = stringToQueue(expression);
		Queue<String> q = SimpleCalculator.infixToPostfix(orig);

		assertEquals("Postfix not correct", "24 4 2 3 ^ + -", queueToString(q));
		
		//make sure queue is the same
		assertEquals("Queue was changed", "( 24 - ( 4 + ( 2 ^ 3 ) ) )", queueToString(orig));
	}

	/*
	 * Simple Evaluate Postfix
	 */

	@Test
	public void simpleAddEvaluatePostfix() {
		String expression = "2 3 +";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 5.0, result, 0.01);
	}

	@Test
	public void simpleSubtractEvaluatePostfix() {
		String expression = "7 2 -";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 5.0, result, 0.01);
	}

	@Test
	public void simpleEvaluatePostfix() {
		String expression = "3 4 *";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 12.0, result, 0.01);
	}

	@Test
	public void simpleDivideEvaluatePostfix() {
		String expression = "10 2 /";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 5.0, result, 0.01);
	}

	@Test
	public void simplePowerEvaluatePostfix() {
		String expression = "2 3 ^";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 8.0, result, 0.01);
	}
	
	/*
	 * Evaluate Postfix
	 */

	@Test
	public void AddEvaluatePostfix() {
		String expression = "2 3 1 + + 5 +";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 11.0, result, 0.01);
	}

	@Test
	public void SubtractEvaluatePostfix() {
		String expression = "12 7 4 - 3 - -";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 12.0, result, 0.01);
	}

	@Test
	public void MultiplyEvaluatePostfix() {
		String expression = "2 3 2 4 * * *";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 48.0, result, 0.01);
	}

	@Test
	public void DivideEvaluatePostfix() {
		String expression = "120 5 / 4 / 3 /";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 2.0, result, 0.01);
	}

	@Test
	public void PowerEvaluatePostfix() {
		String expression = "2 3 ^ 2 ^";

		Double result = SimpleCalculator.evaluatePostfix(stringToQueue(expression));

		assertEquals("Result not correct", 64.0, result, 0.01);
	}
	
	@Test
	public void evaluatePostfix1() {
		String expression = "3 4 ^ 9 / 1 - 3 /";
		Queue<String>  q = stringToQueue(expression);
		Double result = SimpleCalculator.evaluatePostfix(q);

		assertEquals("Result not correct", 2.6666, result, 0.01);
		
		//make sure queue is the same
		assertEquals("Queue was changed", "3 4 ^ 9 / 1 - 3 /" ,queueToString(q));
	}

	@Test
	public void evaluatePostfix2() {
		String expression = "7 5 1 2 + - + 4.5 -";
		Queue<String>  q = stringToQueue(expression);
		Double result = SimpleCalculator.evaluatePostfix(q);

		assertEquals("Result not correct", 4.5, result, 0.01);
		
		//make sure queue is the same
		assertEquals("Queue was changed", "7 5 1 2 + - + 4.5 -" ,queueToString(q));
	}

	@Test
	public void evaluatePostfix3() {
		String expression = "3 1 - 12 + 7 /";
		Queue<String>  q = stringToQueue(expression);
		Double result = SimpleCalculator.evaluatePostfix(q);

		assertEquals("Result not correct", 2.0, result, 0.01);
		
		//make sure queue is the same
		assertEquals("Queue was changed", "3 1 - 12 + 7 /" ,queueToString(q));
	}

	@Test
	public void evaluatePostfix4() {
		String expression = "24 4 2 3 ^ + -";
		Queue<String>  q = stringToQueue(expression);
		Double result = SimpleCalculator.evaluatePostfix(q);

		assertEquals("Result not correct", 12.0, result, 0.01);
		
		//make sure queue is the same
		assertEquals("Queue was changed", "24 4 2 3 ^ + -" ,queueToString(q));
	}

}
