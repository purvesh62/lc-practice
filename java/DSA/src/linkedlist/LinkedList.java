package linkedlist;

public class LinkedList {
    private Node head = null;

    private Node tail = null;

    private int length = 0;

    // Constructor
    public LinkedList(int value) {
        // Initialize the LinkedList
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Add node to the beginning
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }

        length++;
    }

    // Add node to the end
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }


    // Add node to an index
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        } else if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            int choice = 0;
            if (choice == 0) {
                Node temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                // Cleaner approach
                Node temp = get(index - 1);
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        length++;
        return true;
    }

    // Set value at an index
    public boolean set(int index, int value) {
        if (index >= 0 || index <= length) {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.value = value;
            return true;
        } else {
            return false;
        }
    }

    public void printList() {
        System.out.println("Printing list");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node getHead() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }

    public Node get(int index) {
        if (index >= 0 & index <= length) {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            return null;
        }
    }

    public Node getTail() {
        if (head == null) {
            return null;
        } else {
            return tail;
        }
    }

    public Node removeFirst() {
        Node temp = null;
        // List is empty
        if (head == null) {
            return null;
        } else if (head.next == null) {
            head = null;
            tail = null;
        } else {
            temp = head;
            head = head.next;
            temp.next = null;
        }
        length--;
        return temp;

    }


    public Node remove(int index) {
        if (index < 0 || index > length) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == length) {
            return removeLast();
        } else {
            Node prev = get(index - 1);
            Node temp = prev.next;

            prev.next = temp.next;
            temp.next = null;

            length--;
            return temp;
        }
    }

    public Node removeLast() {
        // If list is empty
        if (head == null) {
            System.out.println("LinkedList is empty.");
            return null;
        }

        // If list has 1 node
        if (head.next == null) {
            head = null;
            tail = null;
            length = 0;
            return null;
        } else {
            // Normal case
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            temp = temp.next;
            return temp;
        }
    }

    public int removeLastCleaner() {
        if (length == 0) return -1;

        Node temp = head;
        Node pre = temp;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp.value;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;

            temp.next = before;

            before = temp;

            temp = after;
        }
    }

    public Node findMiddleNode() {
        if (head == null) {
            return null;
        }
        Node t1 = head;
        Node t2 = head;

        while (t2 != null && t2.next != null) {
            t1 = t1.next;
            t2 = t2.next.next;
        }
        return t1;
    }
}