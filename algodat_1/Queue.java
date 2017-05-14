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
	
	//!! THIS LEAVES THE QUEUE EMPTY !!
	String to_string()
	{
		return queue.to_string();
	}
	
	//tostring für ausgabe der Präfix Expression
}
