
// Write Code to remove duplicates from an unsorted Linked lists.
// Follow up : How would you solve this problem if a temporary buffer is not allowed

import java.util.HashSet;

// Approches :
// 1. Using HashSet we can keep track of the Nodes-data and when we find which is already present
//    we could remove that node  (Note : Don't take whole node as nodes data can be different even with same data)
// 2. With out using any extra space we can achieve this only using brute force or O(n2) approach for linked list
public class RemoveDups {
    public static void main(String[] args) {
        LinkedListTemp list = new LinkedListTemp();
        list.insertBack(3);
        list.insertBack(2);
        list.insertBack(2);
        list.insertBack(3);
        list.insertBack(2);


        System.out.println("Before removing duplicates list");
        list.display();
        removeDuplicate2(list.head);
        System.out.println("\nAfter removing duplicates :");
        list.display();
    }

    // Approach - 1 : Using HashSet
    // TC : O(n), SC : O(n)
    public static void removeDuplicate(Node head){
        Node curr = head;
        HashSet<Integer> set = new HashSet<>();
        while(curr.next != null){
            set.add(curr.data);
            if(set.contains(curr.next.data))
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
    }

    // Approach - 2 : Brute force
    // TC : O(n2) , SC : O(1)
    public static void removeDuplicate2(Node head){
        Node p1 = head;

        while(p1 != null && p1.next != null){
            Node p2 = p1.next;
            Node prev = p1;
            while(p2 != null){
                if(p1.data == p2.data)
                    prev.next = p2.next;
                else {
                    prev = p2;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
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

