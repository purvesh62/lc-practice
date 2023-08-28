package blind75;

import dataStructures.linkedlist.LinkedList;
import dataStructures.linkedlist.Node;

public class RemoveKthElementFromLastLinkedList {

    public static Node removeKthElement(Node head, int n) {
        Node temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length == n) {
            return head.next;
        }
        temp = head;
        for (int i = 0; i < length - n - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(10);
        ll.append(12);
        ll.append(14);
        ll.append(16);
        ll.append(18);
        ll.append(20);

        ll.printList();

        Node head = removeKthElement(ll.getHead(), 6);
        Node temp = head;

        System.out.println("Output:");
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
