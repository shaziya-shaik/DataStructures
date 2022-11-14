package queue;

public class queueUsingLL {
	private Node  front;
	private Node rear;
	private int size;
	public queueUsingLL() {
		front=null;
		rear=null;
		size=0;
	}
	
	public int isSize() {
		return (size);
		
	}
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public int front() throws queueEmptyException {
		if(size==0) {
			throw new queueEmptyException();
		}
		return(front.data);
	}
	public void enque(int data) {
		Node newNode=new Node(data);
		if(front==null) {
			front=newNode;
			rear=newNode;
		}
		else {
			rear.next=newNode;
			rear=newNode;
		}
		size++;
	}
	public int deque() throws queueEmptyException {
		if(size==0) {
			throw new queueEmptyException();
		}
		int x=front.data;
		front=front.next;
		size--;
		return x;
	}

}
class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data=data;
	}
}
