package StackInitial;
import java.util.*;

public class Main {
	public static void main(String[] args)throws  StackEmptyException {
		stackUsingArray st=new stackUsingArray();
		int choice;
		int k;
		Scanner s=new Scanner(System.in);
	do {
		System.out.println("enter Your option:");
		System.out.println("1.push");
		System.out.println("2.pop");
		System.out.println("3.top");
		System.out.println("4.isEmpty");
		System.out.println("5.isSize");
		System.out.println("6.display");
		System.out.println("7.Exit");

		 choice=s.nextInt();
	switch(choice) {
	case 1:
		System.out.println("enter stack elements:");
		 k=s.nextInt();
		st.push(k);
		break;
	case 2:
		System.out.println(st.pop());
		break;
	case 3:
		System.out.println(st.peek());
		break;
	case 4:
		System.out.println(st.isEmpty());
		break;
	case 5:
		System.out.println(st.isSize());
		break;
	case 6:
		st.display();
		break;
	}
	}
	while(choice!=7);
	System.out.println("exit");
	}
}