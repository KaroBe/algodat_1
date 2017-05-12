package algodat_1;

public class Stack {
	
	//Attributes
	private Linked_List stack;
	
	//Constructor
	Stack()
	{
		stack = new Linked_List();
	}
	
	void push(char data) throws EmptyListException
	{
		stack.pushFront(data);
	}
	
	char pop() throws EmptyListException
	{
		return stack.popFront();
	}
	
	char peek() throws EmptyListException
	{
		return stack.peekFront();
	}
	
	boolean is_empty()
	{
		return stack.isEmpty();
	}
}
