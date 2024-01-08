package blind75.MergeKSortedList;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueSolution {

    public static void test() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(5);
        queue.add(2);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return util1(lists);
    }

    public ListNode util1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> (a.val - b.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        ListNode head = null;
        ListNode tail = null;
        while (pq.isEmpty() == false) {
            ListNode popped = pq.poll();
            ListNode toInsert = popped.next;
            if (toInsert != null) {
                pq.add(toInsert);
            }
            if (head == null) {
                head = popped;
                tail = popped;
            } else {
                tail.next = popped;
                tail = tail.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        test();

        ListNode l1 = new ListNode(12);
        ListNode temp = l1;


        temp = new ListNode(16, temp);
        temp = new ListNode(12, temp);
        temp = new ListNode(5, temp);
        temp = new ListNode(6, temp);

        l1 = temp;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}