import java.util.*;
class Node{
int data;
Node next;
Node(int data){
this.data=data;}
}

class Main{
public static void main(String[] args){
Node head=null;
head=create(head);
printlinked(head);
head=mid(head);
System.out.println("mid value="+head.data);
}


public static Node create(Node head){
Node tail=null;
Scanner input=new Scanner(System.in);
System.out.println("enter number:");
int x=input.nextInt();
while(x!=-1){
Node temp=new Node(x);
if(head==null){
head=temp;
tail=temp;
}
else{
tail.next=temp;
tail=temp;}
System.out.println(" enter number:");
x=input.nextInt();
}
return(head);
}


public static void printlinked(Node head){
Node temp=head;
while(temp!=null){
System.out.print(temp.data);
temp=temp.next;
System.out.println(" ");
}}


public static Node mid(Node head){
Node slow=head;
Node fast=head;
while(fast.next!=null && fast.next.next!=null){
fast=fast.next.next;
slow=slow.next;}
return(slow);
}
}