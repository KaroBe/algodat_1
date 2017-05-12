package algodat_1;

import java.util.Scanner;

public class Main {

	//Conversion return Queue
	//String einlesen und in Queue schreiben (push string(1) usw: front 4 3 2 1 rear ->)
	//Queue durchgehen und für jedes Element entscheiden, ob es auf den stack kommt, berechnet wird usw.
	//Ausgabe: Präfix Expression als Queue (front 4 3 2 1 rear ->) sodass beim Auslesen wieder
	//"richtige Reihenfolge"
	
	public Queue conversion(){
		
		//Einlesen von input stream
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();
		inputScanner.close();
		System.out.println(input);
		
		Queue infix = new Queue();
		
		for (int i = 0; i < input.length(); ++i)
		{
			char read = input.charAt(i);
			if(read != ' ')
			{
				infix.enqueue(read);
			}
		}
		
		Queue praefix = new Queue();
		Stack conversion = new Stack();
		
		char peek;
		try {
			peek = infix.peek();
		} catch (EmptyListException e) {
			e.printStackTrace();
			System.out.println("falsche eingabe?");
		}
		String peekS = Character.toString(peek);		
		boolean match = peekS.matches("[+-*/]");
		if (match == true)
		{
			//vergleich und
			//in stack
		}
		else
		{
			//Zahl in Queue
		}	
		
		//
		
		return new Queue();
	}
	
	//Calculate return int
	//Präfix Expression in Queue einlesen / schon in Queue speichern??
	//Auslesen und berechnen
	
	public int calculate(){
		return 0;
	}
	
	public static void main(String[] args) {
		//Conversion

		//Calculate
		
		//Ausgabe des Ergebnis und der Präfix Expression
	}

}
