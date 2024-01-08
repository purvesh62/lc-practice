package blind75;

import java.util.List;

public class ReorderLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode[] partitionList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;

        return new ListNode[]{head, fast};
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private static ListNode mergeList(ListNode head, ListNode mid) {
        ListNode list1 = head;
        while (mid != null) {
            ListNode temp = list1.next;
            list1.next = new ListNode(mid.val);
            list1.next.next = temp;
            list1 = list1.next.next;
            mid = mid.next;
        }
        return head;
    }

    public static void reorderList(ListNode head) {
        ListNode[] arr = partitionList(head);
        ListNode list1 = arr[0];
        ListNode list2 = arr[1];
        list2 = reverseLinkedList(list2);
        head = mergeList(list1, list2);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        temp.next = new ListNode(2);
        temp = temp.next;

        temp.next = new ListNode(3);
        temp = temp.next;

        temp.next = new ListNode(4);
        temp = temp.next;

//        temp.next = new ListNode(5);
//        temp = temp.next;

        reorderList(head);
    }

}


