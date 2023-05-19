

// Program to call or use the implementation of double linked list

public class DLLImplementation {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.insertAtStart(4);
        dll.insertAtStart(3);
        dll.insertAtStart(2);
        dll.insertAtStart(9);
        dll.insertAtEnd(10);
        dll.insert(2,8);
        dll.display();
       // dll.displayReverse();
        dll.deleteAtEnd();
        dll.deleteAtEnd();
        System.out.println();
        dll.display();
    }
}
