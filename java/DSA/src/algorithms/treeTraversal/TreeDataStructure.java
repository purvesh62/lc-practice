package algorithms.treeTraversal;

class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int key) {
        data = key;
        leftChild = rightChild = null;
    }
}

public class TreeDataStructure {
    Node root = null;

    void inorder_traversal(Node node) {
        if (node != null) {
            inorder_traversal(node.leftChild);
            System.out.print(node.data + " ");
            inorder_traversal(node.rightChild);
        }
    }

    void pre_order_traversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            pre_order_traversal(node.leftChild);
            pre_order_traversal(node.rightChild);
        }
    }

    void post_order_traversal(Node node) {
        if (node != null) {
            post_order_traversal(node.leftChild);
            post_order_traversal(node.rightChild);
            System.out.print(node.data + " ");
        }
    }
}