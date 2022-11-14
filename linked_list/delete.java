import java.util.*;
class Node{
int data;
Node next;
Node(int data){
this.data=data;
}
}

class Main{
public static void main(String[] args){
Scanner input=new Scanner(System.in);
System.out.println("enter number:");
int x=input.nextInt();
Node head=null;
Node tail=null;
while(x!=-1){
Node temp=new Node(x);
if(head==null){
head=temp;
tail=temp;
}
else{
tail.next=temp;
tail=temp;
}
System.out.println("enter number:");
x=input.nextInt();
}
printlinked(head);
head=delete(head,tail);
printlinked(head);
}

public static void printlinked(Node head){
Node temp=head;
while(temp!=null){
System.out.println(temp.data);
temp=temp.next;
}
}


public static Node delete(Node head,Node tail){
int i=0;
Node temp=head;
Node pre=head;
Scanner input=new Scanner(System.in);
System.out.println("enter position:");
int k=input.nextInt();
while(i!=k && temp!=null){
i++;
pre=temp;
temp=temp.next;
}
if(i!=k){
System.out.println("position is not found");
}
if(i==k && temp==head && temp==tail){
System.out.println("no elements in linked list:");
}
else if(i==k && temp==head){
head=head.next;
}
else if(i==k && temp==null){
pre.next=temp.next;
tail=pre;
}
else{
pre.next=temp.next;
}
return(head);
}
}