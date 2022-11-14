import java.util.*;
class Node{
int data;
Node next;
Node(int data){
this.data=data;}
}

class Main{
public static void main(String[] args){
Node head1=null;
Node head2=null;
Node head=null;
Node tail=null;
head1=create(head1,tail);
head2=create(head2,tail);
printlinked(head1);
printlinked(head2);
head=merge(head1,head2,tail);
printlinked(head);
}


public static Node create(Node head,Node tail){
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
System.out.print(temp.data+" ");
temp=temp.next;
}
System.out.println(" ");}


public static Node merge(Node head1,Node head2,Node tail){
Node temp1=head1;
Node temp2=head2;
Node temp=null;
Node head=null;
if(temp1.data<=temp2.data){
head=temp1;
temp=head;
tail=temp1;
temp1=temp1.next;}
else{
head=temp2;
temp=head;
tail=temp2;
temp2=temp2.next;}
while(temp1!=null && temp2!=null){
if(temp1.data>=temp2.data){
temp.next=temp2;
tail=temp2;
temp=temp2;
temp2=temp2.next;}
else{
temp.next=temp1;
tail=temp2;
temp=temp1;
temp1=temp1.next;}}
if(temp1==null){
temp.next=temp2;
tail=temp2;
temp=temp2;
temp2=temp2.next;
}
else{
temp.next=temp1;
tail=temp2;
temp=temp1;
temp1=temp1.next;}
return(head);
}
}