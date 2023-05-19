
// This Class represents complete implementation of Binary Tress
// From bottom or scratch
import java.util.*;

public class BinaryTree {

    Node root;

    // Method to insert nodes into Tree
    public void insert(int data, Node n) {

    }

    // Method to display Binary Tree - Inorder (left root right)
    public void InOrdertraversal(Node n) {

        // Recursive
//        if (n != null) {
//            InOrdertraversal(n.left);
//            System.out.print(n.data + " ");
//            InOrdertraversal(n.right);
//        }

        // Iterative
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack  = new Stack<>();

        Node node = root;

        if(root == null)
            return;
        
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty())
                    break;
                node = stack.peek();
                list.add(node.data);
                stack.pop();
                node = node.right;
            }

        }
        System.out.println(list);
    }

    // Method to display Binary Tree in Pre-Order Traversal (root left right)
    public void preOrderTraversal(Node n){
        if(n == null)
            return;

        System.out.print(n.data + " ");
        preOrderTraversal(n.left);
        preOrderTraversal(n.right);
    }


    // Method to display Binary Tree in Post-Order Traversal (left right root)
    public void postOrderTraversal(Node n){
        // Recursive approach
//        if(n == null)
//            return;
//        postOrderTraversal(n.left);
//        postOrderTraversal(n.right);
//        System.out.print(n.data + " ");

        Node node = n;
        // Iterative approach using 2 stacks
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(node);

        while(!stack1.isEmpty()){
            Node temp = stack1.pop();
            if(temp.left != null)
                stack1.push(temp.left);
            if(temp.right != null)
                stack1.push(temp.right);
            stack2.push(temp);
        }

        // Printing stack2 using FILO which gives us our desired post-order traversal
        while (!stack2.isEmpty()){
            Node temp = stack2.pop();
            System.out.print(temp.data+ " ");
        }
    }


    // Level-Order Traversal  - We use BFS by using queue as we can't implement this using recursion
    public void levelOrderTraversal(Node n){
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(n);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp_list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node temp = queue.remove();
                temp_list.add(temp.data);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            list.add(temp_list);
        }
        for(List<Integer> a : list){
            for(int i : a){
                System.out.print(i + " ");
            }
        }
        // Method - 2 : DFS (Recursion)
        // TC  : O(n) as we are visiting each node once
        // SC  : O(n) if the tree is steep as stack space for recursion
//        public List<List<Integer>> levelOrder(Node root) {
//            List<List<Integer>> list = new ArrayList<List<Integer>>();
//            levelHelper(list,root,0);
//            return list;
//
//        }
//
//        // Helper function
//        public void levelHelper(List<List<Integer>> list, Node node, int height){
//            //Base conditions
//            if(node == null)
//                return;
//            if(height == list.size()){
//                list.add(new ArrayList<Integer>());
//            }
//
//            list.get(height).add(node.data);
//            levelHelper(list,node.left,height + 1);
//            levelHelper(list,node.right,height + 1);
//        }
    }


    // Method to convert normal tree to child sum property obeying tree
    public void childSumProperty(Node node){
        if(node == null)
            return;

        int childData = 0;

        if(node.left != null)
            childData += node.left.data;
        if(node.right != null)
            childData += node.right.data;

        if(childData < node.data){
            if(node.left != null)
                node.left.data = node.data;
            if(node.right != null)
                node.right.data = node.data;
        }

        childSumProperty(node.left);
        childSumProperty(node.right);

        childData = 0;

        if(node.left != null)
            childData += node.left.data;
        if(node.right != null)
            childData += node.right.data;

        if(node.left != null || node.right != null)
            node.data = childData;
    }

    // Leetcode - recover BST
    Node firstNode = null;
    Node secondNode = null;
    Node prev = new Node(Integer.MIN_VALUE);
    public void recoverTree(Node root) {
        if(root == null) return;

        inorder(root);
        if(firstNode != null && secondNode != null){
            int temp = firstNode.data;
            firstNode.data = secondNode.data;
            secondNode.data = temp;
        }
    }

    // Method to correct BST using inorder traversal
    public void inorder(Node node){
        if(node == null) return;
        inorder(node.left);

        if(prev.data > node.data){
            if(firstNode == null){
                firstNode = node;
                secondNode = prev;
            }
            else
                secondNode = node;
        }
        prev = node;
        inorder(node.right);
    }
}
    // Class Node
     class Node{
         int data;
        Node left,right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

