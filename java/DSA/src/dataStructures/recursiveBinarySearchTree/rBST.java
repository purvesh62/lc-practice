package dataStructures.recursiveBinarySearchTree;

public class rBST {
    private Node root;

    public rBST(int value) {
        root = new Node(value);
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        } else {
            if (currentNode.value == value) {
                return true;
            } else if (currentNode.value > value) {
                return rContains(currentNode.left, value);
            } else {
                return rContains(currentNode.right, value);
            }
        }
    }


    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        rInsert(root, value);
    }

    public boolean rContains(int value) {
        if (root == null) {
            root = new Node(value);
        }
        return rContains(root, value);
    }

    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    private int maxValue(Node currentNode) {
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode.value;
    }

    private Node rDelete(Node currentNode, int value) {
        // Base case
        if (currentNode == null) {
            return null;
        }

        if (value < currentNode.value) {
            currentNode = rDelete(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode = rDelete(currentNode.right, value);
        } else {
            /* Possible cases;
             *
             *
             */
            if (currentNode.left != null && currentNode.right != null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int minValue = minValue(currentNode.right);
                currentNode.value = minValue;
                currentNode.right = rDelete(currentNode.right, minValue);
            }
        }
        return currentNode;
    }

    public Node rDelete(int value) {
        return rDelete(root, value);
    }
}

