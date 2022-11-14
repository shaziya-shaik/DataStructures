package queue;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class queuePractice {

			public static void main(String[] args)throws queueEmptyException {
				Queue<Integer> q=new LinkedList<Integer>();
				int k;
				int choice;
				Scanner input=new Scanner(System.in);
				do {
					System.out.println("1.enque");
					System.out.println("2.deque");
					System.out.println("3.front");
					System.out.println("4.isEmpty");
					System.out.println("5.isSize");
					System.out.println("6.Exit");
					System.out.println("enter your choice:");
					 choice=input.nextInt();
					 switch(choice) {
					 case 1:
						 System.out.println("enter element which we want to enter:");
						 k=input.nextInt();
						 q.add(k);
						 break;
					 case 2:
					System.out.println( q.remove());
					 break;
					case 3:
						System.out.println(q.peek());
						break;
					case 4:
						System.out.println(q.isEmpty());
						break;
					case 5:
						System.out.println(q.size());
						break;
						}
				}while(choice!=6);
			}
		}

