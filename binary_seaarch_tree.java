package TreesInitial;
import java.util.Scanner;
public class binary_seaarch_tree {
	Scanner input=new Scanner(System.in);
	public static void main(String[] aargs) {
		Scanner input=new Scanner(System.in);
	//	treeNode<Integer> root=create(true,true,0);
		//print(root);
		//System.out.println("enter Searching value:");
		//int value=input.nextInt();
	//System.out.println(Search(root,value));
		//System.out.println("enter minimum range:");
//		int n=input.nextInt();
	//	System.out.println("enter  maximum range:");
		//int m=input.nextInt();
//		printRange( root, n, m);
	System.out.println("enter array size:");
	int x=input.nextInt();
	int[] arr=new int[x];
	for(int i=0;i<arr.length;i++) {
		arr[i]=input.nextInt();
	}
	print(convertArrayToBST(arr,0,x));
		
	}
	
	
	
	public static treeNode<Integer> create(boolean isRoot,boolean isLeft,int parent) {
		Scanner input=new Scanner(System.in);
		if(isRoot==true) {
			System.out.println("enter root number:");
		}
		else {
		if(isLeft==true) {
			System.out.println("enter left node of "+parent);
		}
		else {
			System.out.println("enter right node of "+parent);
		}
		}
		int x=input.nextInt();
		if(x==-1) {
			return null;
		}
		treeNode<Integer> root=new treeNode<Integer>(x); 
		treeNode<Integer>left=create(false,true,root.data);
		treeNode<Integer>right=create(false,false,root.data);
		root.left=left;
		root.right=right;
		return root;
	}
	
	
	public static void print(treeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data);
		if(root.left!=null) {
			System.out.print("L: "+root.left.data);
		}
		if(root.right!=null) {
			System.out.print("R: "+root.right.data);
		}
		System.out.println();
		print(root.left);
		print(root.right);
	}
	
	public static boolean Search(treeNode<Integer> root,int value) {
		if(root==null) {
			return false;
		}
		if(value==root.data)
		return true;
		else	if(value<root.data) {
		return Search(root.left,value);
		}
		else {
			return Search(root.right,value);
		}
	}
	
	
	public static void printRange(treeNode<Integer> root, int n,int m) {
		if(root==null) {
			return ;
		}
		if(root.data<n)
		printRange(root.right,n,m);
		else if(root.data>m) {
			printRange(root.left,n,m);
		}
		else if(n<=root.data && root.data<=m) {
			System.out.println(root.data);
			printRange(root.left,n,m);
			printRange(root.right,n,m);
		}
	}
	
	public static treeNode<Integer> convertArrayToBST(int arr[],int start,int end){
		if(start>end) {
			return null;
		}
		int mid=(start+end)/2;
		treeNode <Integer> root=new treeNode<>(arr[mid]);
		treeNode <Integer> lroot=convertArrayToBST(arr,start,mid-1);
		treeNode <Integer> rroot=convertArrayToBST(arr,mid+1,end);
		root.left=lroot;
		root.right=rroot;
		return root;
	}
	
}
