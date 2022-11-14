package queue;
import java.util.*;
public class queueUsingArray {
	Scanner input=new Scanner(System.in);
	private int []arr;
	private int front;
	private int rear;
	private int size;
	public queueUsingArray() {
	System.out.println("enter size of an array:");
		int x=input.nextInt();
		arr=new int[x];
		front=-1;
		rear=-1;
		size=0;
	}
	public  boolean isEmpty() {
		if(size==0)
			return true;
		return false;
	}
	public  int isSize() {
		return size;
	}
	public int front() throws queueEmptyException{
		if(size==0) {
		throw new queueEmptyException();
	} 
		return(arr[front]);
	}
	public void enque(int data)throws queueFullException {
		if(size==arr.length) {
			throw new queueFullException();
		}
		if(size==0) {
			front++;
		}
		rear++;
		if(rear==arr.length) {
			rear=0;
		}
		arr[rear]=data;
		size++;
	}
	
	public int deque()throws queueEmptyException{
		if(size==0) {
			front=-1;
			rear=-1;
		throw new queueEmptyException();
	} 
		if(front==arr.length) {
			front=0;
		}
		int relement=arr[front];
		front++;
		size--;
		return(relement);
}
	public void display() throws queueEmptyException{
		if(size==0) {
			throw new queueEmptyException();
		}
		int front1=front;
		int size1=size;
		while(front1!=rear) {
			System.out.println(arr[front1]);
			front1++;
			size1--;
			if(front1==arr.length && size1!=0) {
				front1=0;
			}
		}
		if(front1==rear) {
			System.out.println(arr[front1]);
			size1--;
		}
	}
	}
