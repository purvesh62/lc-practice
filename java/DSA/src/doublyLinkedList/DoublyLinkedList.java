package doublyLinkedList;


public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        System.out.print("DoublyLinkedList: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
            length = 1;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            length++;
        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        } else if (length == 1) {
            Node temp = head;
            head = null;
            tail = null;
            length = 0;
            return temp;
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
            head.prev = null;
            length--;
            return temp;
        }
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        } else if (length == 1) {
            Node temp = head;
            head = null;
            tail = null;
            length = 0;
            return temp;
        } else {
            Node temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            return temp;
        }
    }


    public Node get(int index) {
        if (length == 0 || index > length) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public void set(int index, int value) {
        if (index > 0) {
            Node node = get(index - 1);
            Node temp = get(value);
            temp.next = node.next;
            temp.prev = node;
            node.next = temp;
            length++;
        } else {
            head.value = value;
        }
    }

    public void insert(int index, int value) {
        if (index < 0 || index > length) {
            return;
        } else if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node before = get(index - 1);
            Node after = before.next;
            Node newNode = new Node(value);

            // Set after
            newNode.next = after;
            after.prev = newNode;

            // Set before
            newNode.prev = before;
            before.next = newNode;
        }
    }

    public Node remove(int index) {
        // index = 3
        Node nodeToRemove = get(index);

        if (nodeToRemove != null) {
            Node before = nodeToRemove.prev;
            Node after = nodeToRemove.next;

            before.next = after;
            after.prev = before;

            nodeToRemove.prev = null;
            nodeToRemove.next = null;
            length--;
            return nodeToRemove;
        }
        return null;
    }
}
