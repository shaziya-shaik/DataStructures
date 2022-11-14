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
Node head=null;
head=create(head);
 printlinked(head);
Scanner input=new Scanner(System.in);
System.out.println("enter posotion:");
int pos=input.nextInt();
head= delete(head,pos);
 printlinked(head);
head=reverse(head);
 printlinked(head);
}




public static Node create(Node head){
Node tail=null;
Scanner input=new Scanner(System.in);
System.out.println("enter nunmber:");
int x=input.nextInt();
while(x!=-1){
Node temp=new Node(x);
if(head==null){
head=temp;
tail=temp;}
else{
tail.next=temp;
tail=temp;}
System.out.println("enter nunmber:");
x=input.nextInt();
}
return(head);
}



public static void printlinked(Node head){
Node temp=head;
if(temp==null){
return ;}
System.out.print(temp.data+" ");
printlinked(temp.next);
System.out.println();
}



public static Node delete(Node head,int pos){
if(head==null || head.next==null){
return head;}
if(pos==1){
return head.next;}
Node rhead=delete(head.next,pos-1);
head.next=rhead;
return head;
}



public static Node reverse(Node head){
if(head==null || head.next==null){
return head;}
Node nhead=reverse(head.next);
Node tail=head.next;
tail.next=head;
head.next=null;
return(nhead);

}




}