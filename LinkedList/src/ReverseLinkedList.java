

// Program to Reverse a Linked list


public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList_local ll = new LinkedList_local();

        ll.insertAtEnd(5);
        ll.insertAtEnd(7);
        ll.insertAtEnd(8);
        ll.insertAtEnd(2);
        ll.insertAtEnd(4);
        ll.insertAtEnd(-1);
        ll.display();

        int[] arr = {1, 0, 2};
        int n = 3;
        ll.reverseKNodes(ll.head,n,arr);      //5 7 8 2 4 -1    // 3  // 1 0 2

    }
}
