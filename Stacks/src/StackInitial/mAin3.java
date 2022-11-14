package StackInitial;
import java.util.*;
import java.util.Stack;
public class mAin3 {
	public static void main(String[] args) {
		String s;
		int i;
		Scanner input=new Scanner(System.in);
		do {
			System.out.println("enter other than -1 otherwise it terminates:");
			i=input.nextInt();
			switch(i) {
			case 1:
			System.out.println("enter string:");
			 s=input.next();
			System.out.println(balancedParanthesis(s));
			System.out.println(minReverseParanthesis(s));
			break;
			case 2:
				int arr[]= {50,65,50,70,40,100,50};
				int ans[]=new int[arr.length];
				ans=stockStack(arr);
				for(int k=0;k<ans.length;k++) {
					System.out.print(ans[k]+" ");
				}
				break;
			case 3:
				Stack<Integer> st=new Stack<Integer>();
				st.push(10);
				st.push(20);
				st.push(30);
				st.push(40);
				reverse(st);
				while(!st.isEmpty()) {
					System.out.println(st.pop());
				}
				break;
			case 4:
				int arr1[]= {6,2,5,4,5,1,6};
				System.out.println(histagramMaxArea(arr1));
				break;
			case 5:
				int[] arr2= {11,2,1,3,21};
				int[] answ1=nextGreatestElement(arr2);
				System.out.println(answ1.length);
				for(int m=0;m<answ1.length;m++) {
					System.out.print(answ1[m]+" ");
				}
				break;
			case 6:
				int[][] Matrix= {{0,1,1,0},
						{1,1,1,1},
						{1,1,1,1},
						{1,1,0,0}};
				int v= matrixHistagramMaxArea(Matrix);
				System.out.println(v);
				break;
				}
		}
		while(i!=-1);
		System.out.println("program terminates");
	}
public static  boolean balancedParanthesis(String str) {
	Stack<Character> st=new Stack<Character>();
	for(int i=0;i<str.length();i++) {
		if(str.charAt(i)=='(') {
			st.push('(');
		}
		else {
			if(st.isEmpty()) {
				return false;
			}
			else {
				st.pop();
			}
		}
	}
	return (st.isEmpty());
}


public static int minReverseParanthesis(String str) {
	int count=0;
	Stack<Character> st=new Stack<Character>();
	if(str.length()%2!=0) {
		return -1;
	}
	for(int i=0;i<str.length();i++) {
		if(str.charAt(i)=='(') {
			st.push('(');
		}
		else {
			if(!st.isEmpty() && st.peek()=='(') {
				st.pop();
			}
			else {
				st.push(')');
			}
		}
	}
	while(!st.isEmpty()) {
		char x1=st.pop();
		char x2=st.pop();
		if(x1==x2) {
			count+=1;
		}
		else {
			count+=2;
		}
	}
	return count;
}



public static int[] stockStack(int []arr) {
	Stack<Integer> st=new Stack<Integer>();
	int []ans=new int[arr.length];
	st.push(0);
	ans[0]=1;
	for(int i=1;i<arr.length;i++) {
		int element=arr[i];
		while(!st.isEmpty()&& element>arr[st.peek()]) {
			st.pop();
		}
		if(st.isEmpty()) {
			ans[i]=i+1;
		}
		else {
			ans[i]=i-st.peek();
		}
		st.push(i);
	}
	return ans;
}

public static void reverse(Stack<Integer> original) {
	Stack<Integer> taken1=new Stack<Integer>();
	Stack<Integer> taken2=new Stack<Integer>();
	while(!original.isEmpty()) {
		int x=original.pop();
		taken1.push(x);
	}
	while(!taken1.isEmpty()) {
		int x=taken1.pop();
		taken2.push(x);
	}
	while(!taken2.isEmpty()) {
		int x=taken2.pop();
		original.push(x);	
	}
}


public static int[] nextGreatestElement(int[] arr) {
	Stack<Integer> st=new Stack<Integer>();
	int n=arr.length;
	int[] ans=new int[arr.length];
	int i=0;
	while(i<n) {
		if(st.isEmpty() || arr[i]<=arr[st.peek()]) {
			st.push(i);
			i++;
		}
		else {
			while(!st.isEmpty() && arr[i]>arr[st.peek()]) {
			int x=st.pop();
			ans[x]=arr[i];
			}
		}
	}
	while(!st.isEmpty()) {
		int x=st.pop();
		ans[x]=-1;
	}
	return ans;
}

public static int matrixHistagramMaxArea(int[][] arr) {
	int r=arr.length;
	int c=arr[0].length;
	int max_area=histagramMaxArea(arr[0]);
	for(int i=1;i<r;i++) {
		for(int j=0;j<c;j++) {
			if(arr[i][j]==1)
			arr[i][j]+=arr[i-1][j];
		}
		int area=histagramMaxArea(arr[i]);
		max_area=Math.max(max_area, area);
	}
	return max_area;
}


public static int histagramMaxArea(int[] arr) {
	int n=arr.length;
	Stack<Integer> st=new Stack<Integer>();
	int max_area=0;	
	int i=0;
	while(i<n) {
		if(st.isEmpty() || arr[i]>=arr[st.peek()]) {
			st.push(i);
			i++;
		}
		else {
			int x=st.pop();
			int right_most=i;
			int left_most;
			if(st.isEmpty()) {
				left_most=0;
			}
			else {
				left_most=st.peek();
			}
			int area;
			if(st.isEmpty()) {
				area=arr[x]*right_most;
			}
			else {
				area=arr[x]*(right_most-left_most-1);
			}
			max_area=Math.max(area,max_area);
		}
	}
	while(!st.isEmpty()) {
			int x=st.pop();
			int right_most=i;
			int left_most;
			if(st.isEmpty()) {
				left_most=0;
			}
			else {
				left_most=st.peek();
			}
			int area;
			if(st.isEmpty()) {
				area=arr[x]*right_most;
			}
			else {
				area=arr[x]*(right_most-left_most-1);
			}
			max_area=Math.max(area,max_area);
		}
	return max_area;
	
}
}