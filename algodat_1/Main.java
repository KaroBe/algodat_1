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
				while(!conversion.is_empty() && conversion.peek() >= getPriority(next_char))
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
			
			//RIGHT parenthesis )
			else if (next_char == ')')
			{
				//pop from stack and enqueue operators to postfix expression
				//until matching left parenthesis is found
				while (conversion.peek() != '('){
					postfix.enqueue(conversion.pop());
				}
				conversion.pop(); //pop left parenthesis
				infix.dequeue(); //dequeue right parenthesis
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
	public static int calculate(){
		return 0;
	}
	
	public static void main(String[] args){
		Linked_List testL = new Linked_List();
		testL.pushFront('a');
		System.out.println("a - " + testL.to_string());
		testL.pushFront('b');	
		System.out.println("ba - " + testL.to_string());
		testL.pushFront('c');
		System.out.println("cba - " + testL.to_string());
		testL.popFront();
		System.out.println("ba - " + testL.to_string());
		testL.popRear();
		System.out.println("b - " + testL.to_string());
		testL.popRear();
		System.out.println("empty list - " + testL.to_string());		
		/*
		Queue test = new Queue();
		System.out.println("empty " + test.to_string());
		test.enqueue('a');
		System.out.println("a: " + test.to_string());
		test.enqueue('b');
		System.out.println("a,b: " + test.to_string());
		test.enqueue('c');
		System.out.println("a,b,c: " + test.to_string());
		*/
		
		//Conversion
		try {
			Queue postfix = conversion();
			System.out.println(postfix.to_string());
		} catch (EmptyListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Calculate
		
		//Ausgabe des Ergebnis und der Postfix Expression
	}

}
