package blind75;

// Problem 21

import dataStructures.linkedlist.LinkedList;

public class MergeSortedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        list1.append(2);
        list1.append(4);


        LinkedList list2 = new LinkedList(1);
        list2.append(3);
        list2.append(4);


        mergeTwoList(list1.getHead(), list2.getHead());
    }

    private static LinkedList mergeTwoList(dataStructures.linkedlist.Node head1, dataStructures.linkedlist.Node head2) {
        dataStructures.linkedlist.Node temp1 = head1;
        dataStructures.linkedlist.Node temp2 = head2;
        LinkedList mergedList = new LinkedList(-1);
        LinkedList head = mergedList;
        while (temp1 != null && temp2 != null) {
            if (temp1.value > temp2.value) {
                head.append(temp2.value);
                temp2 = temp2.next;
            } else {
                head.append(temp1.value);
                temp1 = temp1.next;
            }
        }

        while (temp1 != null) {
            head.append(temp1.value);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            head.append(temp2.value);
            temp2 = temp2.next;
        }
        mergedList.removeFirst();
        mergedList.printList();
        return mergedList;
    }
}
