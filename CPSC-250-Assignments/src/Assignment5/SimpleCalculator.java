package Assignment5;

public class SimpleCalculator {
	
	/**
	 * Author: Walker Reynolds
	 * Version: 12/3/15
	 * 
	 */

	public static Queue<String> infixToPostfix(Queue<String> infix) {

		Queue<String> tempInfix = new Queue<String>(); //Queue for the copy of the parameter
		Stack<String> tempStack = new Stack<String>(); //stack used to move items of the infix around
		Queue<String> postFix = new Queue<String>(); //Queue that holds the final result

		
		while(!infix.isEmpty()){ // takes everything from the infix parameter and puts it in the tempInfix queue
			tempInfix.enqueue(infix.dequeue());
		}
		
		while (!tempInfix.isEmpty()) {
			
			String peek = tempInfix.peek();
			infix.enqueue(peek); //adds the peek of the tempInfix back to the original infix queue
			
			if (peek.matches("[-+]?\\d*\\.?\\d+")) {//if the peek is a number, add it to the postfix queue
				postFix.enqueue(peek);
				tempInfix.dequeue();
			} else if (peek.matches("[+-/*^]")) { //if the peek is an operator, push it to the stack
				tempStack.push(peek);
				tempInfix.dequeue();
			} else if (peek.equals("(")) {// if the peek is a left parenthesis, add it the stack
				tempStack.push(peek);
				tempInfix.dequeue();
			} else if (peek.equals(")")) {//if the peek is a right parenthesis, go through the stack and add all the operators to the queue until you hit a left parenthesis
				tempInfix.dequeue();
				while (!tempStack.peek().equals("(")) {
					postFix.enqueue(tempStack.peek());
					tempStack.pop();
				}
				tempStack.pop();
			}

		}
		
		
		return postFix;

	}
	
	
	public static double evaluatePostfix(Queue<String> postFix){
		
		
		Queue<String> tempPostfix = new Queue<String>(); //temp postFix queue
		Stack<String> tempStack = new Stack<String>(); //temp stack 
		
		while(!postFix.isEmpty()){ //add everything from the postfix parameter to the temp queue
			tempPostfix.enqueue(postFix.dequeue());
		}
		
		while(!tempPostfix.isEmpty()){ //go through the whole postFix queue
			String peek = tempPostfix.peek();
			postFix.enqueue(peek); //add the peek back to the original queue
			
			if(peek.matches("[-+]?\\d*\\.?\\d+")){ //if the peek is a number
				tempStack.push(peek);
				tempPostfix.dequeue();
			}else {
				double tempOne = Double.parseDouble(tempStack.peek());//first number off the stack (second number in operation)
				tempStack.pop();
				
				double tempTwo = Double.parseDouble(tempStack.peek());//second number off the stack (fist number in the operation)
				tempStack.pop();
				
				String operator = peek; 
				tempPostfix.dequeue();
				
				double result = 0;
				
				//do the operation to the two numbers depending on the operator 
				
				if(operator.equals("+")){
					result = tempTwo + tempOne;
				}else if(operator.equals("-")){
					result = tempTwo - tempOne;
				}else if(operator.equals("*")){
					result = tempTwo * tempOne;
				}else if(operator.equals("/")){
					result = tempTwo / tempOne;
				}else if(operator.equals("^")){
					result = Math.pow(tempTwo, tempOne);
				}
				
				tempStack.push(new String(result + "")); //push the result back to the stack
				
			}
			
			
		}
		
		
		return Double.parseDouble(tempStack.peek()); // return the only thing on the stack
	}
}
