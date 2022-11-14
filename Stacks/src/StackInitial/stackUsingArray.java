package StackInitial;
import java.util.*;

public class stackUsingArray {
	Scanner input=new Scanner(System.in);
	private int[] arr;
	private int top;
	public stackUsingArray() {
		System.out.println("enter range of array");
		int  x=input.nextInt();
		 arr=new int[x];
		top=-1;
	}
	
	
	public void push(int ele){
		if(top==arr.length-1) {
			 doubleSize();
		}
		top++;
		arr[top]=ele;
		
	}
	public int pop()throws StackEmptyException {
		if(top==-1) {
			throw new StackEmptyException();
		}
		int rele=arr[top];
		top--;
		return rele;
	}
	
	public int peek() throws StackEmptyException{
		if(top==-1) {
			throw new StackEmptyException();
		}
		
		return arr[top];
	}
	
	public int isSize() {
		
		return top+1;
	}
	
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}
	public void display() throws StackEmptyException {
		if(top==-1) {
			throw new StackEmptyException();
		}
		for(int a1:arr) {
			System.out.print(a1+" ");
		}
		System.out.println();
	}
	public void doubleSize() {
		int []temp=arr;
		arr=new int[2*arr.length];
		for(int i=0;i<temp.length;i++) {
			arr[i]=temp[i];
		}
	}
}
