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
System.out.println("enter number:");
int x=input.nextInt();
Node head=null;
Node tail=null;
while(x!=-1){
Node temp=new Node(x);
if(head==null){
head=temp;
tail=temp;}
else{
tail.next=temp;
tail=temp;
}
System.out.println("enter number:");
x=input.nextInt();
}
printlinked(head);
head=duplicate(head);
printlinked(head);
head=reverse(head);
printlinked(head);
}
public static void printlinked(Node head){
Node temp=head;
while(temp!=null){
System.out.print(temp.data+" ");
temp=temp.next;
}
System.out.println();
}
public static Node duplicate(Node head){
Node temp=head;
Node current=temp;
while(current.next!=null){
while(current.next!=null && current.data==temp.data){
current=current.next;
}
if(current.data!=temp.data){
temp.next=current;
temp=current;
}
}
return(head);
}


public static Node reverse(Node head){
Node current=head;
Node prev=null;
Node post=null;
while(current!=null){ 
post=current.next;
current.next=prev;
prev=current;
current=post;
}
head=prev;
return(head);
}

}