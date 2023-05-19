
// This class is to implement LinkedList from scratch including all basic operations
// Insertion
// Traversal
// Deletion etc.

public class LinkedList_local {

    public Node head;
    private Node tail;

    private  int size;

    LinkedList_local(){  // called at the time of object creation
        this.size = 0;
    }

    // Method to insert New node at head
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;  // to connect previous first element to the new element
        head = node;

        if(tail == null)
            tail = head;

        size += 1;
    }

    // Method to insert New node at end
    public void insertAtEnd(int val){
        // If Linked List is empty
        if(tail == null ){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;

        size += 1;
    }


    // Method to insert node at any given index
    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertAtEnd(val);
            return;
        }

        Node temp = head;

        for(int i = 1; i < index; i++)
            temp = temp.next;

        Node node = new Node(val,temp.next);
        temp.next = node;
    }

    // Insert Node after any given node
    public void insert(Node node, Node base){
        node.next = base.next;
        base.next = node;
        return;
    }


    // Method to insert node at any given index using recursion
    public void insert_rec(int val, int index){
        if(index == 0) {
            insertFirst(val);
            return;
        }
        Node temp = head;
        temp = insert_rec(val,index - 1,temp);

     //   inserting new node at given index
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
        temp = node;
        size++;
    }

    // Helper function to do insertion
    private Node insert_rec(int val, int index, Node temp){
        if(index == 0){
            return temp;
        }

         return insert_rec(val,index - 1, temp.next);

    }

    //Insert Node for new_head
    public Node insertNode(Node node, Node new_head){
        Node temp = new Node(node.data);
        if(new_head == null)
            new_head = temp;
        new_head.next = temp;
        new_head = temp;
        return new_head;
    }



    // Method to display or travers the linked list
    public void display() {
        System.out.println();
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Method to display given head list
    public void display(Node given_head) {
        System.out.println();
        Node temp = given_head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    // Reverse a Linked list
    public void reverse(){
        if(head == null || head.next == null){
            display(head);
            return;
        }
        Node temp = head;
        Node current = head.next;
        temp.next = null;
        while(current != null){
            temp = current;
            current = current.next;
            temp.next = head;
            head = temp;
        }
        System.out.println("Reversed Single Linked list");
        display(head);
    }

    // Reverse a LinkedList using Recursion
    public void reverse_rec(){
        if(head == null || head.next == null){
            display(head);
            return;
        }
        Node temp = head;
        Node current = head.next;
        head.next = null;
        head = helper(head,temp,current);

        System.out.println("Reversed Single Linked list");
        display(head);

    }

    // Helper method to reverse a linkedlist using recursion
    private Node helper(Node head, Node temp, Node current){
         if(current == null)
             return head;
         temp = current;
         //current = current.next;
         temp.next = head;
         head = temp;
         return helper(head,temp,current);
    }



    // Method to reverse between given left and right indexes (Leet code : 92. Reverse Linked list 2)
    public void reverse(int left, int right){
        if(head == null || head.next == null || left == right){
            display(head);
            return;
        }

            Node temp = head;
            Node temp_left = null;
            // For finding left node
            for(int i = 1; i < left; i++) {
                if(i == left - 1)
                    temp_left = temp;
                temp = temp.next;
            }

           Node left_node = temp;

           temp = head;

            //For finding right node
            for(int i = 1; i <= right; i++)
                temp = temp.next;

            Node temp_right = temp;

            temp = left_node;
            Node current = left_node.next;
            left_node.next = temp_right;


            while(current != temp_right) {
                temp = current;
                current = current.next;
                temp.next = left_node;
                left_node = temp;

            }
            if(temp_left == null) {
                System.out.println("Reversed Linked list : ");
                display(temp);
                return;
            }
        temp_left.next = temp;

        System.out.println("Reversed Linked list : ");
        display(head);
        }


    // Method to find Palindrome Linked list by creating a new list and comparing it with old one
    // Leetcode (234. Palindrome Linked List)

    public boolean isPalindrome(Node head) {
        Node head2 = reverseList(head);

        while(head != null || head2 != null){
            if(head.data != head2.data)
                return false;

            head = head.next;
            head2 = head2.next;
        }
        return true;

    }

    // Method to reverse linked list by creating new one;
    public Node reverseList(Node head){
        Node temp = head;
        Node current = head.next;
        Node new_head =  new Node(head.data);
        while(current != null){
            temp = current;
            Node new_node = new Node(temp.data);
            new_node.next = new_head;
            new_head = new_node;
            current = current.next;

        }

        return new_head;
    }



    // Method to reverse K-nodes at a time in linked list
    // Leetcode (25. Reverse Nodes in k-Group)
    public void reverseKGroup(Node head, int k) {
        if(head == null || head.next == null)
            return;

        Node dummy = new Node();
        dummy.next = head;
        head = dummy;
        Node first = dummy;
        Node last = null;
        Node current = head.next;
        Node temp = null;
        Node left = null;
        while(current != null){
           // System.out.println("starting of while loop");
            //display(head);
            temp = first;     // To attach the left part of the reversed list
            first = current;
            for(int i = 1; i < k; i++)
                current = current.next;
            if(current == null)
                break;
            last = current;
            current = current.next;
            left = reversekList(first,last);
            temp.next = left;
            //System.out.println("After reversal");
            // display(head);
        }
        System.out.println("Final list : ");

        display(head.next);
    }


    // Method to reverse a linked list
    public Node reversekList(Node first, Node last){
        if(first.next == null)
            return first;
        Node current = first.next;
        Node temp = first;
        Node head_temp = temp;
        temp.next = last.next;
        Node stop_cond = last.next;
        while(current != null && current != stop_cond){
            temp = current;
            current = current.next;
            temp.next = head_temp;
            head_temp = temp;
        }
        return temp;
    }


    // Method to reverse k nodes at a time
    public void reverseKNodes(Node root, int n, int[] b){
        // Creating dummy node will help at starting point for reversing list
        Node dummy = new Node(0);
        dummy.next = head;

        Node left = dummy;
        Node right = head;
        Node end = right;

        for(int i = 0; i < n && right != null; i++){
            int count = b[i];
            while(end != null && count > 0){
                end = end.next;
                count--;
            }
            // 5 7 8 2 4 -1    // 3  // 1 0 2
            if(b[i] != 0) {
                Node newHead = reverseList(left.next, b[i]);
                //System.out.println("Right node " + right.data + "\nleft node:" + left.data + " \n newNode : " + newHead.data);
                left.next = newHead;
                right.next = end;
                left = right;
                right = end;
            }
        }

       display(dummy.next);
    }

    // Method linked to above method reverseKNodes
    public static Node  reverseList(Node node, int k){
        Node curr = node.next;
        Node temp = node;
        Node newHead = node;

        while(curr != null && k - 1 > 0){
            temp = curr;
            curr = curr.next;
            temp.next = newHead;
            newHead = temp;
            k--;
        }
        return temp;
    }



    // Method to re-arrange linked list
    public void reArrange(Node head){
        if(head == null || head.next == null || head.next.next == null)
            return;
        Node mid = getMid(head);
        Node temp = head;
        Node current = head.next;
        Node mid_temp = mid;
        Node mid_next = mid.next;
        while(temp!= mid.next && mid_next != null){
            insert(temp,mid_temp);
            mid_temp = mid_next;
            mid_next = mid_next.next;
            temp = current;
            current = current.next;
        }
    }


    // Method to deleteFirst node
    public void deleteFirstNode(){
        System.out.println("deleted : " + head.data);
        head = head.next;
        if(head == null)
            tail = null;

        size -= 1;
    }


    // Method to delete duplicates if list is in ascending
    public void deleteAsc(){
             if(head == null || head.next == null)
            return;

        Node temp = head;
        while(temp != null && temp.next != null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

   // Code to sort the Linked list using Merge sort using -
    // 1.getMid Node
    // 2.Merging two sorted lists
    public void sortList(Node head){
        display(head);
        Node node = mergeSort(head);
        display(node);
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null)
            return head;

        Node mid = getMid(head);
        Node temp = mid.next;
        mid.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(temp);

        return merge(left,right);
    }

    // Method to find middle node of Linked list -
    // We use the slow-fast pointer method to find middle
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head;
        Node temp = head;

        do {
            temp = slow;
            fast = fast.next.next;
            slow = slow.next;
        }while(fast != null && fast.next != null);

        return temp;

    }

    // Method to merge two sorted linked lists - used extensively in merge sort
    public Node merge(Node list1, Node list2){
        Node merged_head = new Node();
        Node temp = merged_head;

        while(list1 != null && list2 != null){
            if(list1.data > list2.data){
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
            else{
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
        }

        // If any one of the nodes of lists are remaining
        if(list1 != null)
            temp.next = list1;
        if(list2 != null)
            temp.next = list2;

        return merged_head.next;
    }


    // Merger two list2
    public void mergeTwoLists(Node list1, Node list2){
        Node ans = new Node();
        Node new_head = ans;
        new_head = mergeTwoLists(list1,list2,new_head);
        display(ans);

    }

    private Node mergeTwoLists(Node list1, Node list2, Node new_head) {

        if(list1 == null && list2 == null)
            return list1;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        while(list1 != null && list2 != null){
            //checking both head nodes
            if(list1.data == list2.data){
                new_head = insertNode(list1,new_head);
                new_head = insertNode(list2,new_head);
                if(list1.next == null || list2.next == null)
                    break;
                if(list1.next != null )
                    list1 = list1.next;
                if(list2.next != null)
                    list2 = list2.next;

            }
            else if(list1.data > list2.data){
                new_head = insertNode(list2,new_head);
                if(list2.next != null)
                 list2 = list2.next;
                else
                    break;
            }
            else{
                new_head = insertNode(list1,new_head);
                if(list1.next != null)
                   list1 = list1.next;
                else
                    break;
            }
        }

        // if the lists are different sizes
        while(list1.next !=  null){
           new_head =  insertNode(list1,new_head);
           list1 = list1.next;
        }
        while(list2.next != null){
            new_head =  insertNode(list2,new_head);
            list2 = list2.next;
        }


        return new_head;
    }




    // Class for Node
    class Node{
        private int data;
        private Node next;

        public Node(){

        }

        public Node(int data){        // Constructor with data parameter
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next){   // Constructor with data and next parameter
            this.data = data;
            this.next = next;
        }

    }
}


