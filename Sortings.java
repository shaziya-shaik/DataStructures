package dataStructure;
import java.util.Scanner;
public class  Sortings{
	public static void main(String[] args) {
		Sortings s=new Sortings(); 
		Scanner sc=new Scanner(System.in);
		System.out.println("enter array size");
		int x=sc.nextInt();
		int arr[]=new int[x];
		System.out.println("enter numbers in the array:");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("before swapping");
		for(int a:arr) {
			System.out.print(" "+a);
		}
		//arr=s.bubbleSort(arr);
		//arr=s.selectionSort(arr);
		//arr=s.insertionSort(arr);
		//s.mergeSort(arr,0,arr.length-1);
	    //s.QuickSort(arr,0,arr.length-1);
	    //s.shellSort(arr);
		//arr=s.countSort(arr);
	//	arr=s.radixSort(arr);
		System.out.println("after swapping");
		for(int a:arr) {
			System.out.print(" "+a);
		}
	}

	
	//bubbleSort
	public int[] bubbleSort(int arr[]) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
	
	//selectionSort
	public int[] selectionSort(int arr[]) {
		for(int i=0;i<arr.length-1;i++) {
			int min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		return arr;
	}
	
	//insertionSort
	
	public int[] insertionSort(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			int j=i-1;
			int current=arr[i];
			while(j>=0 && arr[j]>current) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=current;
		}
		return arr;
	}
	
//mergeSort
	public void mergeSort(int arr[],int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	public void merge(int arr[],int low,int mid,int high) {
		int n1=mid-low+1;
		int n2=high-mid;
		int L[]=new int[n1];
		int R[]=new int[n2];
		for(int i=0;i<n1;i++) {
			L[i]=arr[i+low];
		}
		for(int j=0;j<n2;j++) {
			R[j]=arr[mid+1+j];
		}
		int i=0,j=0,k=low;
		while(i<n1 && j<n2) {
			if(L[i]<R[j]) {
				arr[k++]=L[i++];
			}
			else {
				arr[k++]=R[j++];
			}
		}
		while(i<n1) {
			arr[k++]=L[i++];
		}
		while(j<n2) {
			arr[k++]=R[j++];
		}
	}
	
	
	//QuickSort
	public void QuickSort(int arr[],int low,int high) {
		if(low<high) {
			int q=partition(arr,low,high);
			QuickSort(arr,low,q-1);
			QuickSort(arr,q+1,high);
		}
	}
	public int partition(int arr[],int low,int high) {
		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(pivot>=arr[j]) {
				i++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		i++;
		int temp=arr[i];
		arr[i]=arr[high];
		arr[high]=temp;
		return i;
	}
	
	
	//shellSort
	public void shellSort(int arr[]) {
		for(int gap=(arr.length)/2;gap>0;gap=gap/2) {
			for(int j=gap;j<arr.length;j++) {
				for(int i=j-gap;i>=0;i=i-gap) {
					if(arr[i+gap]<arr[i]) {
						int temp=arr[i];
						arr[i]=arr[i+gap];
						arr[i+gap]=temp;
					}
				}
			}
		}
	}
	
	
	//countSort
	public int[] countSort(int arr[]) {
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		int c[]=new int[max+1];
		for(int i=0;i<=max;i++) {
			c[i]=0;
		}
		for(int i=0;i<arr.length;i++) {
			c[arr[i]]++;
		}
		for(int i=1;i<=max;i++) {
			c[i]=c[i]+c[i-1];
		}
		int b[]=new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			b[--c[arr[i]]]=arr[i];
		}
		return b;
	}
	
	
	//radixSort
	public int[] radixSort(int arr[]) {
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		for(int pass=1;max/pass>0;pass=pass*10) {
			arr=count(arr,pass);
		}
		return arr;
	}
	public int[] count(int arr[],int pass) {
		int c[]=new int[11];
		for(int i=0;i<10;i++) {
			c[i]=0;
		}
		for(int i=0;i<arr.length;i++) {
			c[(arr[i]/pass)%10]++;
		}
		
		for(int i=1;i<=10;i++) {
			c[i]=c[i]+c[i-1];
		}
		int b[]=new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			b[--c[(arr[i]/pass)%10]]=arr[i];
		}
		return b;
	}
	
}