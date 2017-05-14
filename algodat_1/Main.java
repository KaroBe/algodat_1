package algodat_1;

import java.util.Scanner;

public class Main {

	public static int getPriority(char op)
	{
		switch (op)
		{
		case '(':
			return 1;
		case '+':
		case '-':
			return 2;
		case '*':
		case '/':
			return 3;
			
		default: return 100; //eventually add exception
		}
	}
	
	public static Queue readInfix()
	{
		//read from input stream
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Please enter infix expression: (one-digit numbers and operators +-*/() seperated by spaces)");
		String input = inputScanner.nextLine();
		inputScanner.close();
		
		//make queue containing infix expression
		Queue infix = new Queue();
		for (int i = 0; i < input.length(); ++i)
		{
			char read = input.charAt(i);
			if(read != ' ')
			{
				infix.enqueue(read);
			}
		}
		return infix;
	}
	
	public static Queue conversion() throws EmptyListException{
		
		Queue infix = readInfix();
		
		Queue postfix = new Queue();
		Stack conversion = new Stack();
		
		//Conversion of expression -> Iteration over infix expression
		
		while(!infix.is_empty())
		{
			char next_char = infix.peek();
			
			//OPERATOR
			if (next_char == '+' || next_char == '-' || next_char == '*' ||	next_char == '/')
			{
				//while there are operators in stack to compare with
				//pop all operators in the stack that have greater or equal priority to new operator
				while(!conversion.is_empty() && getPriority(conversion.peek()) >= getPriority(next_char))
				{
					postfix.enqueue(conversion.pop());
				}
				//then push operator to conversion stack
				conversion.push(infix.dequeue());
			}
			
			//LEFT parenthesis (
			else if (next_char == '('){
				conversion.push(infix.dequeue());
			}
			
			//RIGHT parenthesis ) -> means that a left parenthesis appeared some time ago
			else if (next_char == ')')
			{
				//pop from stack and enqueue operators to postfix expression
				//until matching left parenthesis is found
				
				//solange das oberste Element kein ( ist
				while(conversion.peek() != '(')
				{
					//hau das oberste Element in die postfix
					char x = conversion.pop();
					postfix.enqueue(x);
				}
				//wenn du dann das ( gefunden hast, pop es, ohne es irgendwo
				//hin zu schreiben und schmeiß das ) auch weg aus der infix
				conversion.pop();
				infix.dequeue();
			}
			
			//OPERAND enqueue operands
			else{
				postfix.enqueue(infix.dequeue());
			}
		}
		
		while(!conversion.is_empty())
		{
			postfix.enqueue(conversion.pop());
		}
		
		return postfix;
	}

	/* TODO 
	 * Calculate return int
	 * Postfix Expression in Queue einlesen / schon in Queue speichern??
	 * Auslesen und berechnen
	 */
	public static int calculate(Queue postfix) throws EmptyListException{
		Stack calculate = new Stack();
		
		//solange queue nicht leer
		while(!postfix.is_empty())
		{
			char next_char = postfix.peek();
			//wenn op
			if (next_char == '+' || next_char == '-' || next_char == '*' ||	next_char == '/')
			{
				/* TODO
				 * implement template class thing for linked list, so that either
				 * float or int can be contained
				float x = (float)Character.getNumericValue(calculate.pop());
				float y = (float)Character.getNumericValue(calculate.pop());
				*/
				
				int x = Character.getNumericValue(calculate.pop());
				int y = Character.getNumericValue(calculate.pop());
				
				switch (next_char)
				{
				case '+':
					calculate.push((char)(x + y));
					break;
				case '-':
					calculate.push((char)(x - y));
					break;
				case '*':
					calculate.push((char)(x * y));
					break;
				case '/':
					calculate.push((char)(x / y));
					break;
				}			
				
				postfix.dequeue();
			}
			//wenn zahl
			else
			{
				calculate.push(postfix.dequeue());
			}
		}
		return calculate.pop();
	}
	
	public static void main(String[] args){
		//Conversion and Calculation of infix expression
		try {
			Queue postfix = conversion();
			System.out.println("Postfix expression: " + postfix.to_string());
			int result = calculate(postfix);
			System.out.println("Result: " + result);
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
