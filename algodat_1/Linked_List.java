package algodat_1;


public class Linked_List {
	
	//Attribute
	private Node front;
	private Node rear;
	private int size = 0;
	
	
	//Konstruktor
	public Linked_List(){
		this.front = null;
		this.rear = null;
		this.size = 0;
	}
	
	//Gibt zurueck ob die Liste leer ist
	public boolean isEmpty(){
		return front == null;
	}
	
	public int size()
	{
		return size;
	}

	//push front
	public void pushFront(char data){
		if (front != null){
			Node former_front = front;
			front = new Node(data);
			
			front.setNextNode(former_front); //prev = null
			former_front.setPrevNode(front); //next = null or other node
		}
		else{
			front = new Node(data);
			rear = front;
		}
		size += 1;
	}
	
	//push rear
		public void pushRear(char data){
			if (rear != null){
				Node former_rear = rear;
				rear = new Node(data);
				
				former_rear.setNextNode(rear); //prev = null or other node
				rear.setPrevNode(former_rear); //next = null
			}
			else{
				front = new Node(data);
				rear = front;
			}
			size += 1;
		}
	
	//popFront
	public char popFront(){
		if (front == null)
		{
			System.out.println("EmptyList bei PopFront");
			return 'x';
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
		size -= 1;
		return former_front.getValue();
	}
	
	//popRear
	public char popRear(){
		if (rear == null)
		{
			System.out.println("EmptyList bei PopRear");
			size -= 1;
			return 'x';
		}
		else if (front == rear)
		{
			Node former_rear = rear;
			front = null;
			rear = null;
			size -= 1;
			return former_rear.getValue();
		}
		else
		{
			Node former_rear = rear;
			rear = former_rear.getPrevNode(); //rear zeigt auf vorletztes element
			former_rear.getPrevNode().setNextNode(null); //vorletztes element zeigt auf null
			size -= 1;
			return former_rear.getValue();
		}
	}
	
	//peek front 	//NO EXCEPTION HANDLING FOR EMPTY LISTS
	public char peekFront(){
		return front.getValue();
	}
	
	//peek rear 	//NO EXCEPTION HANDLING FOR EMPTY LISTS
	public char peekRear(){
		return rear.getValue();
	}
	
	public String to_string()
	{
		String output = "";
		Node current = this.front;
		if(current == null)
		{
			return output;
		}
		else
		{
			while(current != rear)
			{
				output += current.getValue();
				current = current.getNextNode();
			}
			output += current.getValue();
			return output;
		}
	}
	
	
}
