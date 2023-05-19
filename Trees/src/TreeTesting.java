import java.util.*;
public class TreeTesting {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(5);
        tree.root.right = new Node(1);
        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(2);
        tree.root.right.left = new Node(0);
        tree.root.right.right = new Node(8);
        tree.root.left.right.left = new Node(7);
        tree.root.left.right.right = new Node(4);
        Node p = tree.root.left;
        Node q = tree.root.left.right.right;
        System.out.println(lowestCommonAncestor(tree.root,p,q));

    }

    public static Node lowestCommonAncestor(Node node, Node p, Node q) {
            if(p == null || q == null)
                return null;

            List<Node> list1 = new ArrayList<>();
            List<Node> list2 = new ArrayList<>();

            Node ansNode = node;

            if(getPath(node,p,list1) && getPath(node,q,list2)){

                HashMap<Node,Integer> map = new HashMap<>();
                int size = list1.size();
                for(int i = 0; i < size; i++){
                    map.put(list1.get(i),i);
                }
                int index = -1;
                for(int i = 0; i < list2.size(); i++){
                    if(map.containsKey(list2.get(i))){
                        if(index <= map.get(list2.get(i))){
                            ansNode = list2.get(i);
                            index = map.get(list2.get(i));
                        }
                    }
                }
            }
            return ansNode;
        }

        // Method to get Path of nodes
        public static boolean getPath(Node node, Node p,List<Node> list){
            if(node == null)
                return false;

            if(node == p){
                list.add(node);
                return true;
            }

            list.add(node);
            if(getPath(node.left,p,list) || getPath(node.right,p,list))
                return true;
            list.remove(list.size() - 1);

            return false;
        }
}
