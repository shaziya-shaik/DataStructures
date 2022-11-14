import java.util.*;
class Node{
int data;
Node next;
 Node(int data){
this.data=data;}
}


class Main{
public static void main(String[] args){
Scanner input=new Scanner(System.in);
Node head=null;
Node tail=null;
System.out.println("enter number :");
int x=input.nextInt();
while(x!=-1)
{
Node temp=new Node(x);
if(head==null){
head=temp;
tail=temp;
}
else{
tail.next=temp;
tail=temp;
}
System.out.println("enter nuber:");
x=input.nextInt();
}
printlinked(head);
head=middle(head,tail);
printlinked(head);
}
public static void printlinked(Node head){
Node temp=head;
while(temp!=null){
System.out.println("number:"+temp.data);
temp=temp.next;
}
}




public static Node middle(Node head,Node tail){
Node temp=head;
int count=0,i=0,mid=0;
Scanner k=new Scanner(System.in);
		System.out.println("enter new element:");
		int n=k.nextInt();
		Node tempp=new Node(n);
while(temp!=null){
count++;
temp=temp.next;
}
System.out.println("count"+count);
mid=count/2;
temp=head;
while(i!=mid){
temp=temp.next;
}
 if(i==mid && temp==head){
tempp.next=head.next;
head.next=tempp;
}
else{
tempp.next=temp.next;
temp.next=tempp;
}
return(head);
}
}