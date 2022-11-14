package StackInitial;
import java.util.*;
import java.util.Stack;
public class stackPractice  {
		public static void main(String[] args){
			Stack<Integer> st=new Stack<Integer>();
			int k;
			int choice;
			Scanner input=new Scanner(System.in);
			do {
				System.out.println("1.push");
				System.out.println("2.pop");
				System.out.println("3.peek");
				System.out.println("4.isEmpty");
				System.out.println("5.isSize");
				System.out.println("6.Exit");
				System.out.println("enter your choice:");
				 choice=input.nextInt();
				 switch(choice) {
				 case 1:
					 System.out.println("enter element which we want to enter:");
					 k=input.nextInt();
					 st.push(k);
					 break;
				 case 2:
				System.out.println( st.pop());
				 break;
				case 3:
					System.out.println(st.peek());
					break;
				case 4:
					System.out.println(st.isEmpty());
					break;
				case 5:
					System.out.println(st.size());
					break;
					}
			}while(choice!=6);
		}
	}
