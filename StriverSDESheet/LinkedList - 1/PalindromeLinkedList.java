
// Given the head of a singly linked list, return true if it is a palindrome
// or false otherwise.
// Ex : 1 --> 2 --> 3 --> 2 --> 1
// output : true

public class PalindromeLinkedList {

    public static void main(String[] args) {
        LinkedListPalindrome list = new LinkedListPalindrome();
        list.insertBack(1);
        list.insertBack(2);
        list.insertBack(3);
        list.insertBack(2);
        list.insertBack(1);

        System.out.println(isPalindrome(list.head));
    }

    public static boolean isPalindrome(NodePalindrome head) {

        if(head == null || head.next == null) return true;
        NodePalindrome dummy = head;
        NodePalindrome mid = getMid(head);

        NodePalindrome newHead = reverse(mid.next);
        mid.next = newHead;


        while(dummy != null && newHead != null){
            if(dummy.data != newHead.data)
                return false;

            dummy = dummy.next;
            newHead = newHead.next;
        }

        return true;

    }

    // Method to get Mid element of linkedList
    public static NodePalindrome getMid(NodePalindrome head){
        NodePalindrome fast = head;
        NodePalindrome slow = head;

        while(fast.next != null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    // Method to reverse linkedlist
    public static NodePalindrome reverse(NodePalindrome head){
        NodePalindrome curr = head.next;
        NodePalindrome temp = head;
        NodePalindrome newHead = head;
        temp.next = null;

        while(curr != null){
            temp = curr;
            curr = curr.next;
            temp.next = newHead;
            newHead = temp;
        }

        return temp;
    }
}



// This is Local class of linkedlist with some basic operations - Insert at Back and display.
// In most cases this will be already given by test environment you can ignore it if you want.
// we can also use built-in LinkedList class to define and do operations
// Local implementation of LinkedList
class LinkedListPalindrome {
    NodePalindrome head;

    // Method to insert NodePalindrome at Starting of linked list
    public void insertBack(int data){
        NodePalindrome node = new NodePalindrome(data);
        if(head == null){
            head = node;
            return;
        }
        NodePalindrome temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    // Method to traverse or display linkedlist
    public void display(){
        NodePalindrome temp = head;
        while(temp != null){
            System.out.print(temp.data +"-->" );
            temp = temp.next;
        }
        System.out.print("END");

    }

}

class NodePalindrome{
    int data;
    NodePalindrome next;
    NodePalindrome(int data){
        this.data =  data;
        this.next = null;
    }
    NodePalindrome(int data, NodePalindrome next){
        this.data = data;
        this.next = next;
    }
}