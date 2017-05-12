package algodat_1;


public class Linked_List {
	
	//Attribute
	Node front;
	Node rear;
	
	
	//Konstruktor
	public Linked_List(){
		this.front = null;
		this.rear = null;
	}
	
	//Gibt zurueck ob die Liste leer ist
	public boolean isEmpty(){
		return front == null;
	}

	//push front
	public void pushFront(char data){
		if (front != null){
			Node former_front = front;
			front = new Node(data);
			front.setNextNode(former_front);
		}
		else{
			front = new Node(data);
			rear = front;
		}
	}
	
	//push rear
		public void pushRear(char data){
			if (rear != null){
				Node former_rear = rear;
				rear = new Node(data);
				former_rear.setNextNode(rear);
				rear.setPrevNode(former_rear);
			}
			else{
				front = new Node(data);
				rear = front;
			}
		}
	
	//popFront
	public char popFront() throws EmptyListException{
		if (front == null)
		{
			throw new EmptyListException();
		}
		Node former_front = front;
		if (front.getNextNode() == null)
		{
			front = null;
			rear = null;
		}
		else
		{
			front = former_front.getNextNode();
		}
		return former_front.data;
	}
	
	//popRear
	//NO EXCEPTION HANDLING FOR EMPTY LISTS
	public char popRear(){
		Node former_rear = rear;
		if (rear.getPrevNode() == null)
		{
			front = null;
			rear = null;
		}
		else
		{
			rear = former_rear.getPrevNode();
		}
		return former_rear.data;
	}
	
	//peek front 	//NO EXCEPTION HANDLING FOR EMPTY LISTS
	public char peekFront(){
		return front.data;
	}
	
	//peek rear 	//NO EXCEPTION HANDLING FOR EMPTY LISTS
	public char peekRear(){
		return rear.data;
	}
	
	
}
