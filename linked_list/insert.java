import java.util.*;
class Node{
int data;
Node next;
Node(int data){
this.data=data;
}}


class Main{
public static void main(String[] args){
Scanner input=new Scanner(System.in);
Node head=null;
Node tail=null;
System.out.println("enter number:");
int x=input.nextInt();
while(x!=-1)
{
Node temp=new Node(x);
if(head==null)
{
head=temp;
tail=temp;
}
else{
tail.next=temp;
tail=temp;
}
x=input.nextInt();
}
printlinked(head);
head=before(head);
printlinked(head);
head=first(head);
printlinked(head);
head=after(head,tail);
printlinked(head);
head=last(head,tail);
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
public static Node before(Node head){
Node temp=head;
Node s=head;
System.out.println("enter number which we inserted before:");
Scanner k=new Scanner(System.in);
int p=k.nextInt();
System.out.println("enter new element:");
int n=k.nextInt();
Node tempp=new Node(n);
while(temp.data!=p && temp.next!=null){
temp=temp.next;
}
if(temp.data!=p && temp.next==null)
{
System.out.println("given number is not in linked list");
}
else if(temp.data==p && temp==head)
{
tempp.next=head;
head=tempp;

}
else{
tempp.next=temp;
while(s.next.data!=p){
s=s.next;
}
s.next=tempp;
}
return(head);
}
public static Node first(Node head){
Scanner k=new Scanner(System.in);
System.out.println("enter new element:");
int n=k.nextInt();
Node tempp=new Node(n);
tempp.next=head;
head=tempp;
return(head);
}


public static Node last(Node head,Node tail) {
		Node temp=head;
		Scanner k=new Scanner(System.in);
		System.out.println("enter new element:");
		int n=k.nextInt();
		Node tempp=new Node(n);
		while(temp.next!=null) {
			temp=temp.next;
			}
		if(temp.next==null)
		{
			temp.next=tempp;
			tail=temp;
		}
return(head);
	}

public static Node after(Node head,Node tail){
Node temp=head;
Scanner k=new Scanner(System.in);
System.out.println("enter element which we enter after:");
int p=k.nextInt();
System.out.println("enter new element:");
int s=k.nextInt();
Node tempp=new Node(s);
while(temp.data!=p && temp.next!=null){
temp=temp.next;
}
if(temp.data!=p && temp.next==null){
System.out.println("number is not found:");
return(head);
}
else if(temp.data!=p && temp.next==null){
temp.next=temp;
tail=temp;
return(head);
}
else if(temp.data!=p && head==temp){
tempp.next=head.next;
head.next=tempp;
return(head);
}
else{
tempp.next=temp.next;
temp.next=tempp;
}
return(head);
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
if(temp==head && temp==tail && i==mid){
head.next=tempp;
tail=tempp;
}
else if(i==mid && temp==head){
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