import linkedlist.LinkedList;
import doublyLinkedList.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(1);
        list.append(2);
        list.append(3);
        list.remove(1);
        list.insert(2, 4);
        list.printList();
    }
}
