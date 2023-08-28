package dataStructures.stack;

public class Stack {
    Node top = null;

    int height = 0;

    public Stack(int value) {
        top = new Node(value);
        height++;
    }

    public int push(int value) {
        Node newNode = new Node(value);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
        height++;
        return value;
    }

    public Node pop() {
        if (top == null) {
            return null;
        } else {
            Node temp = top;
            top = top.next;
            temp.next = null;
            height--;
            return temp;
        }
    }

    public void print() {
        Node temp = top;
        System.out.println("Stack: ");
        while (temp != null) {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
    }
}
