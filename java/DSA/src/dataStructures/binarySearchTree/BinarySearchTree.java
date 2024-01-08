package dataStructures.binarySearchTree;

public class BinarySearchTree {
    Node root = null;

    public BinarySearchTree() {

    }

    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public boolean insert(int value) {
        // Create a new node
        Node newNode = new Node(value);

        // Assign newNode as root if no node exists
        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;

        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }

            // LEFT SIDE CHECK
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            // RIGHT SIDE CHECK
            else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;

        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }
}
