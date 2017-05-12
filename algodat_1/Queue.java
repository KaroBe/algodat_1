package algodat_1;

public class Queue {
	
	//Attributes
	Linked_List queue;
	
	//Constructor
	Queue()
	{
		queue = new Linked_List();
	}
	
	void enqueue(char data)
	{
		queue.pushFront(data);
	}
	
	char dequeue()
	{
		return queue.popRear();
	}
	
	char peek()
	{
		return queue.peekRear();
	}
	
	boolean is_empty()
	{
		return queue.isEmpty();
	}
}
