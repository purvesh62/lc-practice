package algorithms.treeTraversal;

public class Main {
    public static void main(String args[]) {
        TreeDataStructure tree = new TreeDataStructure();
        tree.root = new Node(27);
        tree.root.leftChild = new Node(12);
        tree.root.rightChild = new Node(3);
        tree.root.leftChild.leftChild = new Node(44);
        tree.root.leftChild.rightChild = new Node(17);
        tree.root.rightChild.leftChild = new Node(56);
        System.out.println("\nInorder traversal: ");
        tree.inorder_traversal(tree.root);
        System.out.println("\nPreorder traversal: ");
        tree.pre_order_traversal(tree.root);
        System.out.println("\nPost order traversal: ");
        tree.post_order_traversal(tree.root);
    }
}
