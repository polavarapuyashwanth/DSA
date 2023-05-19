
// Program to implement vertical traversing of a binary tree

import java.util.*;

public class VerticalTraversing {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);
//        tree.root.right.right.left = new Node(8);
//        tree.root.right.right.right = new Node(9);

      verticalTraversal(tree.root);
    }

    // Method to get max height of binary tree
    public static int maxHeight(Node node){
        if(node == null)
            return 0;

        int left = maxHeight(node.left);
        int right = maxHeight(node.right);

        return 1 + Math.max(left,right);
    }


    // Method to implement vertical traversal using level order traversal
    public static void verticalTraversal(Node node){
        if(node == null)
            return ;

        // Taking queue to implement level order traversal
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(node,0,0));

        // Map to store the elements
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        while(!queue.isEmpty()) {
            int size = queue.size();

           for (int i = 0; i < size; i++) {
                Tuple tuple = queue.poll();
                Node temp = tuple.node;
                int vert = tuple.vert;
                int hor = tuple.hor;

                if (!map.containsKey(vert)) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(temp.data);
                    map.put(vert, new ArrayList<>(tempList));
                } else {
//                    List<Integer> tempList = new ArrayList<>();
//                    tempList = map.get(vert);
//                    tempList.add(temp.data);
//                    map.put(vert, tempList);
                }

                if (temp.left != null) {
                    queue.offer(new Tuple(temp.left, vert - 1, hor + 1));
                }
                if(temp.right != null){
                    queue.offer(new Tuple(temp.right, vert + 1, hor + 1));
                }
            }
        } // end of while loop

        for(List<Integer> ans : map.values()){
            System.out.println(ans);
        }
    }
}



 class Tuple{
    Node node;
    int vert;
    int hor;

    Tuple(Node _node, int _vert, int _hor){
        node = _node;
        vert = _vert;
        hor = _hor;
    }
 }
