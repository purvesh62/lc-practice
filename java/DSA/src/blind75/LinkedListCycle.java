package blind75;

// Problem 141

public class LinkedListCycle {
    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode ll = new ListNode(10);
        ll.insert(12);
        ll.insert(13);
        ll.insert(14);
        ll.insert(15);
        ll.printList();
    }
}

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class ListNode {

    Node head;


    public ListNode(int value) {
        head = new Node(value);
    }

    public void insert(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(value);
        }
    }

    public void printList() {
        Node temp = head;
        System.out.println("LinkedList: ");
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}