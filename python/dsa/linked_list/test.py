from linked_list import LinkedList
from reverse_linked_list.reverse_ll import ReverseLinkedList


def linked_list_test():
    obj = LinkedList()
    obj.add(10)
    obj.add(11)
    obj.add(12)
    obj.add(13)
    obj.print()


def reverse_linked_list():
    obj = LinkedList()
    obj.add(10)
    obj.add(11)
    obj.add(12)
    obj.add(13)

    obj.head = ReverseLinkedList().reverse(obj.head)
    obj.print()


def reverse_linked_list_recursion():
    obj = LinkedList()
    obj.add(1)
    obj.add(2)
    obj.add(3)
    obj.add(4)

    obj.head = ReverseLinkedList().recursive_reverse(obj.head)
    obj.print()


if __name__ == "__main__":
    reverse_linked_list_recursion()
