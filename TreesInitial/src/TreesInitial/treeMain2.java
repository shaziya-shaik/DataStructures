package TreesInitial;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
public class treeMain2{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("enter k depth value:");
	int k=input.nextInt();
		treeNode<Integer> root=create(true,0,true);
		print(root);
	//	System.out.println("preorder");
	//	preOrder(root);
	//	System.out.println();
	//	System.out.println("postorder");
	//	postOrder(root);
		//System.out.println();
		//System.out.println("inorder");
		//inOrder(root);
		//System.out.println();
	//	System.out.println(" NumberOfNodes"+NumberOfNodes(root));
	//	System.out.println();
//		System.out.println("largeNumber"+largeNumber(root));
//		System.out.println();
	//	System.out.println("numberOfLeafNodes"+numberOfLeafNodes(root));
		//System.out.println();
//		System.out.println("heightOftree"+heightOftree(root));
	//	System.out.println();
		//kDepthOfNode(root,k);
		System.out.println(isBal(root));
		System.out.println(isBetterBal(root).isBal);
		//System.out.println(Diameter(root));
		//System.out.println(BetterDiameter(root).Diameter);
		//LevelOrder(root);
		//mirror(root);
		//print(root);
		//ArrayList<treeNode<Integer>> arr=new ArrayList<>();
		//System.out.println("enter node value:");
	//	int sum=input.nextInt();
		//pathSum(root,sum,arr);
	//	System.out.println("enter node value:");
	//	int n=input.nextInt();
		//treeNode<Integer> node=new treeNode<>(n);
		//kDepth(root,k,node);
		//ZigZag(root);
	}
	
	public static treeNode<Integer> create(boolean isRoot,int parent_data,boolean isLeft){
		Scanner input=new Scanner(System.in);
		if(isRoot==true) {
			System.out.println("enter root node");
		}
		else {
			if(isLeft==true) {
				System.out.println("enter left node of"+parent_data);
			}
			else {
				System.out.println("enter right node of"+parent_data);
			}
		}
		int x=input.nextInt();
		if(x==-1) {
			return null;
		}
		treeNode<Integer> root=new treeNode<Integer>(x);
		treeNode<Integer> Left=create(false,root.data,true);
		treeNode<Integer> Right=create(false,root.data,false);
		root.left=Left;
		root.right=Right;
		return root;
	}
	public static void print(treeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+":");
		if(root.left!=null) {
			System.out.print("L:"+root.left.data+",");
		}
		if(root.right!=null) {
			System.out.println("R:"+root.right.data+",");
		}
		System.out.println();
		print(root.left);
		print(root.right);
	}
	public static void preOrder(treeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(treeNode<Integer> root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	public static void inOrder(treeNode<Integer> root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	
	}
	public static int NumberOfNodes(treeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int Left=NumberOfNodes(root.left);
		int Right=NumberOfNodes(root.right);
		int ans=1+Left+Right;
		return ans;
	}
	public static int largeNumber(treeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int Left=largeNumber(root.left);
		int Right=largeNumber(root.right);
		int ans=Math.max(root.data, Math.max(Left, Right));
		return ans;
	}
	
	public static int numberOfLeafNodes(treeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			System.out.println("leaf nodes are"+root.data);
			return 1;
		}
		int Left=numberOfLeafNodes(root.left);
		int Right=numberOfLeafNodes(root.right);
		int ans=Left+Right;
		return ans;
	}
	public static int heightOftree(treeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int Left=heightOftree(root.left);
		int right=heightOftree(root.right);
		int ans=1+Math.max(Left, right);
		return ans;
	}
	
	public static void kDepthOfNode(treeNode<Integer> root,int k) {
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.println("kDepthOfNode"+root.data);
		}
		kDepthOfNode(root.left,k-1);
		kDepthOfNode(root.right,k-1);
		
	}
	
	public static boolean isBal(treeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int lheight=heightOftree(root.left);
		int rheight=heightOftree(root.right);
		if(Math.abs(lheight-rheight)>1) {
			return false;
		}
		boolean leftBal=isBal(root.left);
		boolean rightBal=isBal(root.right);
		return leftBal && rightBal;
	}
	
	public static treebal isBetterBal(treeNode<Integer> root) {
		if(root==null) {
			treebal ans=new treebal(0,true);
			return ans;
		}
		treebal lBal=isBetterBal(root.left);
		treebal rBal=isBetterBal(root.right);
		int leftHeight=lBal.height;
		int rightHeight=rBal.height;
		boolean leftBal=lBal.isBal;
		boolean rightBal=rBal.isBal;
		int finalHeight=1+(Math.max(leftHeight,rightHeight));
		boolean isBal=true;
		if(Math.abs(leftHeight-rightHeight)>1) {
			isBal=false;
		}
		if(!leftBal || !rightBal) {
			isBal=false;
		}
		treebal ans=new treebal(finalHeight,isBal);
		return ans;
	}
	public static int Diameter(treeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int lheight=heightOftree(root.left);
		int rheight=heightOftree(root.right);
		int mainDiameter=1+lheight+rheight;
		int leftDiameter=Diameter(root.left);
		int rightDiameter=Diameter(root.right);
		int Diameter=Math.max(mainDiameter, Math.max(leftDiameter, rightDiameter));
		return Diameter;
	}
	
	
	public static  treeHD BetterDiameter(treeNode<Integer> root) {
		if(root==null) {
			treeHD ans=new treeHD(0,0);
			return ans;
		}
		treeHD leftDiameter=BetterDiameter(root.left);
		treeHD rightDiameter=BetterDiameter(root.right);
		int lheight=leftDiameter.height;
		int lDiameter=leftDiameter.Diameter;
		int rheight=rightDiameter.height;
		int rDiameter=rightDiameter.Diameter;
		int mainDiameter=1+lheight+rheight;
		int height=1+Math.max(lheight,rheight);
		int Diameter=Math.max(mainDiameter, Math.max(lDiameter, rDiameter));
		treeHD ans=new treeHD(height,Diameter);
		return ans;
	}
	
	
	public static void LevelOrder(treeNode<Integer> root) {
		Queue<treeNode<Integer>> q=new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			treeNode<Integer> r=q.remove();
			System.out.print(r.data+" ");
			if(r.left!=null) {
				q.add(r.left);
			}
			if(r.right!=null) {
				q.add(r.right);
			}
		}
	}

     public static treeNode<Integer> mirror(treeNode<Integer> root) {
    	 if(root==null) {
    		 return null;
    	 }
    	 mirror(root.left);
    	 mirror(root.right);
    	 treeNode<Integer> temp=root.left;
    	 root.left=root.right;
    	 root.right=temp;
    	 return root;
     }
     
     
     public static void pathSum(treeNode<Integer> root,int sum,ArrayList<treeNode<Integer>> arr){
    	if(root==null) {
    		return;
    	}
    	 arr.add(root);
    	 sum=sum-root.data;
    	 if(root.left==null && root.right==null) {
    		 if(sum==0) {
    			 for(treeNode<Integer> i:arr) {
    				System.out.print(i.data+" "); 
    			 }
    			 System.out.println();
    		 }
    		 arr.remove(arr.size()-1);
    		 return;
    	 }
    	pathSum(root.left,sum,arr);
    	pathSum(root.right,sum,arr);
    	 arr.remove(arr.size()-1);
     }
     
     
     
     
     
     
     public static int kDepth(treeNode<Integer> root,int k,treeNode<Integer> node) {
    	 if(root==null) {
    		 return -1;
    	 }
    	 if(node.data==root.data) {
    		 kDepthOfNode(root,k);
    		 return 0;
    	 }
    	 int left_Distance=kDepth(root.left,k,node);
    	 if(left_Distance!=-1) {
    		if(left_Distance+1==k) {
    			System.out.println(root.data+" ");
    		} 
    		else {
    			kDepthOfNode(root.right,k-left_Distance-2);
    		}
    		return left_Distance+1;
     }
    	 int right_Distance=kDepth(root.right,k,node);
    	 if(right_Distance!=-1) {
    		 if(right_Distance+1==k) {
    			 System.out.println(root.data+" ");
    		 }
    		 else {
    			 kDepthOfNode(root.left,k-right_Distance-2);
    		 }
    		 return right_Distance+1;
    	 }
    	 return -1;
     }
     
    public static  void ZigZag(treeNode<Integer> root) {
    	Queue<treeNode<Integer>> q=new LinkedList<treeNode<Integer>>();
    	int level=1;
    	q.add(root);
    	q.add(null);
    	Stack<treeNode<Integer>> st = new Stack<treeNode<Integer>>();
    	while(!q.isEmpty()) {
    		
    		treeNode<Integer> r=q.remove();
    		if(r==null) {
    			if(level%2!=0) {
    				while(!st.isEmpty()) {
    				System.out.print(st.pop().data);
    				}
    				st = new Stack<treeNode<Integer>>();
    			}
    			level++;
    			q.add(null);
    			continue;
    		}
    			if(level%2!=0) {
    				System.out.println(r.data);
    		}
    			if(r.left!=null) {
    				q.add(r.left);
    				if(level%2!=0) {
        				System.out.println(r.data);
        		}
    			}
    			if(r.right!=null) {
    				q.add(r.right);
    				if(level%2!=0) {
        				System.out.println(r.data);
        		}
    			}
    	}
    }
     
}