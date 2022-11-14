package StackInitial;

public class stackUsingLL {
	private Node head;
	private int size;
	public stackUsingLL(){
		head=null;
		size=-1;
	}
	public void push(int data) {
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;
		size++;
		
	}
	public int pop() throws  StackEmptyException{
		if(head==null) {
			throw new StackEmptyException();
		}
		Node temp=head;
		size--;
		head=head.next;
		return temp.data;
		
	}
	
	public int peek() throws StackEmptyException {
		if(head==null) {
			throw new StackEmptyException();
		}
		return head.data;
		}
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	
	public int isSize() {
		return size+1;
	}
	}

 class Node{
	int data;
	Node next;
	public  Node(int data) {
		this.data=data;
	}
}
