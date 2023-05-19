
// Children sum property is a concept where the root node data should be equal to sum of its left and right nodes data
// In this program we convert non-children sum tree to children-sum property tree

public class ChildrenSumProperty {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(50);
        tree.root.left = new Node(7);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(30);
//        tree.root.right.right.left = new Node(8);
//        tree.root.right.right.right = new Node(9);

        System.out.println("Before converting to child sum property : " );
        tree.levelOrderTraversal(tree.root);
        System.out.println();

        tree.childSumProperty(tree.root);

        System.out.println("After converting to child sum property");
        tree.levelOrderTraversal(tree.root);

    }


}
