
// This program is to implement Linked List from scratch
// by doing basic operations like - Insertion, deletion, traversal etc.
// The Implementation class used is - LinkedList

public class LLImplementation {

    public static void main(String[] args) {
        LinkedList_local list1 = new LinkedList_local();

        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(3);
        list1.insertAtEnd(7);
//        list1.insertAtEnd(8);
//        list1.insertAtEnd(9);
        list1.display(list1.head);
        list1.reArrange(list1.head);
        list1.display(list1.head);


       // list2.mergeTwoLists(list1.head,list2.head);

        //list1.insert(5,3);

       // list1.deleteFirstNode();
        //list1.deleteFirstNode();
        //list1.display();
        //list1.insert_rec(9,2);
       // list1.display();
       // list1.insert_rec(7,3);
//        list1.display();
//        list1.deleteAsc();
//        list1.display();

    }
}
