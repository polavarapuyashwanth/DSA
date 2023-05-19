
// Program to check whether tree is balanced binary tree or not
// Leetcode - 110 : Balanced binary tree

public class CheckBalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.levelOrderTraversal(tree.root);
        System.out.println();
        System.out.println(checkBalanced(tree.root));


    }

    // Check balanced or not
    public static boolean checkBalanced(Node node) {
        if(node == null)
            return true;
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);

       boolean ans =  (leftDepth - rightDepth) > 1 ? false : true;
       return ans;

    }

    // Depth of tree
    public static int getDepth(Node n){
        if(n == null)
            return 0;

        int leftHeight = getDepth(n.left);
        int rightHeight = getDepth(n.right);

        return 1 + Math.max(leftHeight,rightHeight);
    }
}
