package queue;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
public class reverseQueue {
		public static void main(String[] args)throws queueEmptyException {
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(10);
			q.add(20);
			q.add(30);
			q.add(40);
			q.add(50);
			ReverseQueue(q);
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
		}
		
		public static  void ReverseQueue(Queue<Integer> q) {
			Stack<Integer> st=new Stack<Integer>();
			while(!q.isEmpty()) {
				int x=q.poll();
				st.push(x);
			}
			while(!st.isEmpty()) {
				int x=st.pop();
				q.add(x);
			}
		}

}
