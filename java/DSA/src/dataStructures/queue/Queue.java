package dataStructures.queue;

public class Queue {

    Node first;
    Node last;

    int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length++;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        length++;
    }

    public Node dequeue() {
        if (first == null) {
            return null;
        }

        if (first.next == null) {
            first = null;
            last = null;
            length--;
            return null;
        } else {
            Node dequeueNode = first;
            first = first.next;
            dequeueNode.next = null;
            length--;
            return dequeueNode;
        }
    }

    public void print() {
        Node temp = first;
        System.out.println("Queue: ");
        while (temp != null) {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
    }
}
