package dataStructure;
import java.util.Scanner;;
public class Searching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Searching s=new Searching(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array size");
		int x=sc.nextInt();
		int arr[]=new int[x];
		System.out.println("enter numbers in the array:");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		for(int a:arr) {
			System.out.print(" "+a);
		}
		System.out.println("enter searching value");
		int n=sc.nextInt();
		//boolean b=s.linearSearch(arr,n);
		//boolean b=s.binarySearch(arr,n,0,arr.length);
		boolean b=s.IbinarySearch(arr,n,0,arr.length);
		if(b==true) {
			System.out.println(n+" is present ");
		}
		else {
			System.out.println(n+" is not found in the given array");
		}
	}
	
	public boolean linearSearch(int arr[],int key) {
		for(int i=0;i<arr.length;i++) {
			if(key==arr[i]) {
				System.out.print("at place of"+(i+1)+" ");
				return true;
			}
		}
			return false;
	}
	
	
	public boolean binarySearch(int arr[],int key,int low,int high) {
		if(low>high) {
			return false;
		}
		else {
			int mid=(low+high)/2;
		if(key==arr[mid]) {
			System.out.print("at place of"+(mid+1)+" ");
			return true;
		}
		else if(key<arr[mid]){
		return	binarySearch(arr,key,low,mid-1);
		}
		else {
		return	binarySearch(arr,key,mid+1,high);
		}
	}
	}
	public boolean IbinarySearch(int arr[],int key,int low,int high) {
		while(low<high) {
			int mid=(low+high)/2;
			if(arr[mid]==key) {
				System.out.print("at place of"+(mid+1)+" ");
				return true;
			}
			else if(key<arr[mid]) {
				high=mid-1;
			}
			else {
				low=mid+1;
			}
		}
		return false; 
	}
}
