package queue;

import java.util.*;
public class queueMain {


		public static void main(String[] args)throws  queueFullException,queueEmptyException {
			queueUsingArray q=new queueUsingArray();
			int choice;
			int k;
			Scanner s=new Scanner(System.in);
		do {
			System.out.println("enter Your option:");
			System.out.println("1.enque");
			System.out.println("2.deque");
			System.out.println("3.front");
			System.out.println("4.isEmpty");
			System.out.println("5.isSize");
			System.out.println("6.display");
			System.out.println("7.Exit");

			 choice=s.nextInt();
		switch(choice) {
		case 1:
			System.out.println("enter queue elements:");
			 k=s.nextInt();
			q.enque(k);
			break;
		case 2:
			System.out.println(q.deque());
			break;
		case 3:
			System.out.println(q.front());
			break;
		case 4:
			System.out.println(q.isEmpty());
			break;
		case 5:
			System.out.println(q.isSize());
			break;
		case 6:
			q.display();
			break;
		}
		}
		while(choice!=7);
		System.out.println("exit");
		}
	}

