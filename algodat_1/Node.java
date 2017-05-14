package algodat_1;

// Node wrapping chars

public class Node {
	
	//Attribute
	private Node next;
	private Node prev; //previous node
	private char data;
	
	//Konstruktor
	public Node(char data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public void setNextNode(Node next){
		this.next = next;
	}

	public Node getNextNode(){
		//return Node
		return this.next;
	}
	
	public void setPrevNode(Node prev){
		this.prev = prev;
	}

	public Node getPrevNode(){
		return this.prev;
	}
	
	// gibt den gespeicherten Wert zuruck
	public char getValue(){
		return this.data;
	}
}
