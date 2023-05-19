

// Implementation of the Binary search Tree
// which was implemented from scratch



public class BinaryTreeImplementation {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(3);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(2);
//        tree.root.right.left = new Node(6);
//        tree.root.right.right = new Node(7);


        tree.recoverTree(tree.root);
    }
    }

