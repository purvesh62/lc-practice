import linkedlist.LinkedList;
import doublyLinkedList.DoublyLinkedList;
import queue.Queue;
import stack.Stack;

public class Main {
    public static void main(String[] args) {
//        DoublyLinkedList list = new DoublyLinkedList(1);
//        list.append(2);
//        list.append(3);
//        list.remove(1);
//        list.insert(2, 4);
//        list.printList();

//        Stack stack = new Stack(10);
//        stack.push(11);
//        stack.push(12);
//        stack.push(13);
//        stack.pop();
//        stack.print();

        Queue queue = new Queue(10);
        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(13);
        queue.dequeue();
        queue.print();
    }
}
