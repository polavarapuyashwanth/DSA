
// Given the head of a singly linked list, reverse the list, and return the reversed list.
// Ex :
// Input  : 1 -> 2 -> 3 -> 4 -> 5
// output : 5 -> 4 -> 3 -> 2 -> 1

import java.util.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedListTemp list = new LinkedListTemp();
        list.insertBack(1);
        list.insertBack(2);
        list.insertBack(3);
        list.insertBack(4);
        list.insertBack(5);


        System.out.println("Before reversing list");
        list.display();
        list.head = reverseList(list.head);
        System.out.println("\nAfter reversing list");
        list.display();
    }

    // Method to reverse Linked list
    public static Node reverseList(Node head){
        Node temp = head;
        Node curr = head.next;
        temp.next = null;
        while(curr != null){
            temp = curr;
            curr = curr.next;
            temp.next = head;
            head = temp;
        }
        return temp;
    }
}



// This is Local class of linkedlist with some basic operations - Insert at Back and display.
// In most cases this will be already given by test environment you can ignore it if you want.
// we can also use built-in LinkedList class to define and do operations
// Local implementation of LinkedList
class LinkedListTemp{
    Node head;

    // Method to insert Node at Starting of linked list
    public void insertBack(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    // Method to traverse or display linkedlist
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +"-->" );
            temp = temp.next;
        }
        System.out.print("END");

    }

}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data =  data;
        this.next = null;
    }
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
