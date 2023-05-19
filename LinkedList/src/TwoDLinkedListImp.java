
// Implementation of 2-D linked list


public class TwoDLinkedListImp {
    public static void main(String[] args) {
        TwoDimensionalLinkedLIst list = new TwoDimensionalLinkedLIst();
        list.insertNextElement(5);
        list.insertChildren(7);
        list.insertChildren(8);
        list.insertChildren(30);
        list.insertNextElement(10);
        list.insertChildren(20);
        list.insertNextElement(19);
        list.insertChildren(22);
        list.insertChildren(50);


        //list.display(list.head);

        list.flatten();
    }
}
