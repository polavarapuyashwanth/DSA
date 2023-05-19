
// This program is to implement 2D Linked List ( next and down nodes are available for one node)


public class TwoDimensionalLinkedLIst {
    public Node head;
    public Node tail;

    // To insert next elements
    public void insertNextElement(int data){
        if(head == null)
        {
            head = new Node(data);
            tail = head;
            return;
        }

        Node temp = head;
        while(temp.next != null)
            temp = temp.next;

        Node node = new Node(data);
        temp.next = node;

        tail = node;

    }

    // To insert the children or down elements to the given node
    public void insertChildren(int childData){

        if(tail == null && head == null)
            return ;
        else if(tail == null)
            tail = head;

        Node node = tail;
        Node child = new Node(childData);
        if(node.down == null){
            node.down = child;
            return;
        }

        while(node.down != null){
            node = node.down;
        }
        node.down = child;
    }

    public void display(Node node){
        if(node == null)
            return;
        Node temp = node;
        while(temp != null){
            Node temp2 = temp.down;
            System.out.println("\n|");
            System.out.print(temp.data + " -> ");
            while(temp2 != null){
                System.out.print(temp2.data + " ->");
                temp2 = temp2.down;
            }
            System.out.print("End");
            temp = temp.next;
        }
    }

    // Display only next elements
    public void displayNext(Node node){
        if(node == null)
            return;
        Node temp = node;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }


    // Method to flatten two dimensional linked list
    public void flatten(){
        Node root = head;

        // Base condition
        if(root == null || root.next == null)
            return ;

        Node  p1 = root;
        Node p2 = root.next;
        Node p3 = p2.next;
        Node dummyNode = new Node(0);
        Node temp = dummyNode;
        boolean flag = true;
        while(p2 != null || p3 != null){

            // Add 2 sorted lists into one sorted list
            while(p1 != null && p2 != null) {
                if (p1.data <= p2.data) {
                    temp.next = p1;
                    temp = p1;
                    if(flag == true)
                        p1 = p1.down;
                    else
                        p1 = p1.next;
                } else {
                    temp.next = p2;
                    temp = p2;
                    p2 = p2.down;
                }
            }

                // If any p1 elements are remaining
                while(p1 != null){
                    temp.next = p1;
                    temp = p1;
                    p1 = p1.down;
                }

                // If any p2 elements are remaining
                while(p2 != null){
                    temp.next = p2;
                    temp = p2;
                    p2 = p2.down;
                }

                // Moving to next list if available
                p1 = dummyNode.next;
                temp = dummyNode;
                p2 = p3;
                if(p2 != null)
                    p3 = p2.next;

                flag = false;
        }

        displayNext(dummyNode);
    }
}


class Node{
    int data;
    Node next;
    Node down;

    Node(int data){
        this.data = data;
        this.next = null;
        this.down = null;
    }

    Node(int _data, Node _next, Node _down){
        this.data = _data;
        this.next = _next;
        this.down = _down;
    }
}
