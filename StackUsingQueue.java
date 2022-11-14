package queue;
import java.util.LinkedList;
import java.util.Queue;
public class StackUsingQueue {
	Queue<Integer> q1;
	Queue<Integer> q2;
	public StackUsingQueue() {
		q1=new LinkedList<>();
		q2=new LinkedList<>();
	}
	
	public boolean isEmpty() {
		return q1.isEmpty();
	}
	public int isSize() {
		return q1.size();
	}
	public void push(int data) {
		q1.add(data);
	}
	public int pop() throws StackEmptyException {
		if(q1.isEmpty()) {
			throw new StackEmptyException();
		}
		while(q1.size()>1) {
			int p=q1.poll();
			q2.add(p);
		}
		int x=q1.poll();
		Queue temp=q1;
		q1=q2;
		q2=temp;
		return x;
	}
	
	public int peek() throws StackEmptyException {
		if(q1.isEmpty()) {
			throw new StackEmptyException();
		}
		while(q1.size()>1) {
			int p=q1.poll();
			q2.add(p);
		}
		int x=q1.peek();
		int p=q1.poll();
		q2.add(p);
		Queue temp=q1;
		q1=q2;
		q2=temp;
		return x;
	}
}
