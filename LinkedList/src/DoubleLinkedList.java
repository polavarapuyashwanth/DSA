
// Implementation of the Double linked List from scratch


public class DoubleLinkedList {

    // Data
    Node head;

    // Method to insert at Start of list
    public void insertAtStart(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;

    }

    // Method to insert at End with out tail
    public void insertAtEnd(int val){
        if(head == null){
            insertAtStart(val);
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        Node node = new Node(val);
        temp.next = node;
        node.prev = temp;

    }

    // Method to insert after any given value
    public void insert(int afterval, int value){
       Node temp = head;

       while(temp.val != afterval ){
           temp = temp.next;
       }
       Node node = new Node(value);
       node.prev = temp;
       node.next = temp.next;
       temp.next.prev = node;
       temp.next = node;
    }


    //Method to delete at start
    public void deleteAtStart(){
        if(head == null)
            return;
        head = head.next;
        head.prev = null;
    }

    // Method to delete at end
    public void deleteAtEnd(){
        if(head == null)
            return;
        Node temp = head;
        while(temp.next.next != null)
            temp = temp.next;

        temp.next = null;
    }

    // Method to display list
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    //Method to display list in reverse order
    public void displayReverse(){
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        System.out.println();
        System.out.println("Reverse list : ");
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.prev;
        }
    }


    class Node{
        int val;
        Node prev;
        Node next;

        Node(int val){
            this.val = val;
        }

        Node (int val, Node prev, Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
