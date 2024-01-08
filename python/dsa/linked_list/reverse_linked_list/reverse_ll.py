from node import Node
from linked_list import LinkedList


class ReverseLinkedList(LinkedList):
    def __init__(self) -> None:
        super().__init__()

    def reverse(self, head: Node) -> Node:
        """
        Reverse linked list using Two-Pointers.
        """
        prev, current = None, head

        while current != None:
            temp = current.next
            current.next = prev
            prev = current
            current = temp
        return prev

    def recursive_reverse(self, head: Node) -> Node:
        if not head:
            return None
        
        newHead = head
        if head.next:
            newHead = self.recursive_reverse(head.next)
            head.next.next = head
        head.next = None

        return newHead
    
