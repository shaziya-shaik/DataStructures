package StackInitial;
import java.util.Stack;
public class QueueUsingStack {
	Stack<Integer> st1;
	Stack<Integer> st2;
	public QueueUsingStack() {
		st1=new Stack<Integer>();
		st2=new Stack<Integer>();
	}
	public boolean isEmpty() {
		if(st1.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public int isSize() {
		return st1.size();
	}
	public int front() throws QueueEmptyException {
		
		
		if(st1.size()==0) {
			throw new QueueEmptyException();
		}
		while(st1.size()>1) {
			int p=st1.pop();
			st2.push(p);
		}
		int x=st1.peek();
		while(st2.isEmpty()) {
			int p=st2.pop();
			st1.push(p);
		}
		return x;
		
	}
	public void enque(int data) {
		st1.push(data);
	}
	public int deque() throws QueueEmptyException {
		
		if(st1.isEmpty()) {
			throw new QueueEmptyException();
		}
		while(st1.size()>1) {
			int p=st1.pop();
			st2.push(p);
		}
		int x=st1.pop();
		while(!st2.isEmpty()) {
			int p=st2.pop();
			st1.push(p);
		}
		return x;
	}
}
