package TreesInitial;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class treeMain {
public static void main(String[] args) {
	treeNode<Integer> root=create(true,true,0);
	print(root);
}
public static treeNode<Integer> create(boolean isRoot,boolean isLeft,int parent_node){
	Scanner input=new Scanner(System.in);
	if(isRoot==true) {
		System.out.println("enter root node:");
	}
	else {
		if(isLeft==true) {
			System.out.println("enter left node of "+parent_node);
		}
		else {
			System.out.println("enter right node of "+ parent_node);
		}
	}
	int x=input.nextInt();
	treeNode<Integer> root=new treeNode<Integer>(x);
	if(x==-1) {
		return null;
	}
	
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
	System.out.print(root.data+" ");
	if(root.left!=null) {
		System.out.print("L:"+root.left.data+",");	
	}
	if(root.right!=null) {
		System.out.print("R:"+root.right.data+",");
	}
	System.out.println();
	print(root.left);
	print(root.right);
	
}

}
