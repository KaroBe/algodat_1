package algodat_1;

public class Queue {
	
	//Attributes
	private Linked_List queue;
	
	//Constructor
	Queue()
	{
		queue = new Linked_List();
	}
	
	int size()
	{
		return queue.size();
	}
	
	void enqueue(char data)
	{
		queue.pushFront(data);
	}
	
	char dequeue() throws EmptyListException
	{
		return queue.popRear();
	}
	
	char peek() throws EmptyListException
	{
		return queue.peekRear();
	}
	
	boolean is_empty()
	{
		return queue.isEmpty();
	}
	
	String to_string() throws EmptyListException
	{
		String stringQueue = "";
		
		for (int i = 0; i < this.size(); ++i)
		{
			stringQueue += this.dequeue();
		}
		
		return stringQueue;
	}
	
	//tostring für ausgabe der Präfix Expression
}
