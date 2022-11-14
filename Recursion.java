package dataStructure;
import java.util.Scanner;
public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Recursion TowerOfHanoi=new Recursion();
		System.out.println("enter no of disks");
	int n=sc.nextInt();
		//TowerOfHanoi.move(n,'A','C','B');
		Recursion f=new Recursion();
		//int k=f.factorial(n);
		int k=f.fibonacci(n);
		System.out.println(k);
	}
	//example of recursion
	//binarySearch
	//trees
	//mergeSort
	//QuickSort
	//towerOfHonai
	//factorial
	//fibonacci
	public void move(int noOfDisks,char from,char to,char into) {
		if(noOfDisks==0) {
			return;
		}
		move(noOfDisks-1,from,into,to);
		System.out.println("moving disc " +noOfDisks+" from "+from+" to "+to);
		move(noOfDisks-1,into,to,from);
	}
	public int factorial(int n) {
		if(n==0) {
			return 1;
		}
		return(n*(factorial(n-1)));
		
	}
	
	public int fibonacci(int n) {
		if(n==0 || n==1) {
			return n;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
}
