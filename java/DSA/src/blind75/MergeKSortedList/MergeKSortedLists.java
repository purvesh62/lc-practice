package blind75.MergeKSortedList;


public class MergeKSortedLists {
    /**
     * Definition for singly-linked list.
     */


    private static LLNode merge2Lists(LLNode list1, LLNode list2) {
        LLNode mergedList = new LLNode(-1);
        LLNode head = mergedList;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = new LLNode(list1.val);
                head = head.next;
                list1 = list1.next;
            } else {
                head.next = new LLNode(list2.val);
                head = head.next;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            head.next = new LLNode(list1.val);
            head = head.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            head.next = new LLNode(list2.val);
            head = head.next;
            list2 = list2.next;
        }
        return mergedList.next;
    }

    public static LLNode mergeKLists(LLNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        LLNode mergedList = merge2Lists(lists[0], lists[1]);

        for (int i = 2; i < lists.length; i++) {
            mergedList = merge2Lists(mergedList, lists[i]);
        }
        return mergedList;
    }

    public static void main(String[] args) {
        LLNode list1 = new LLNode();
        LLNode list2 = new LLNode(1);
        LLNode[] arr = {null, list2};
        LLNode temp = mergeKLists(arr);

    }


}


class LLNode {
    int val;
    LLNode next;

    LLNode() {
    }

    LLNode(int val) {
        this.val = val;
    }

    LLNode(int val, LLNode next) {
        this.val = val;
        this.next = next;
    }
}
