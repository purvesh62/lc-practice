from node import Node


class LinkedList:
    def __init__(self) -> None:
        self.head = None
        self.tail = None

    def add(self, val):
        newNode = Node(val)
        if not self.head:
            self.head = newNode
        else:
            temp = self.head

            while temp.next != None:
                temp = temp.next
            temp.next = newNode
        print(f"Added {val}")

    def print(self):
        temp = self.head
        print("LinkedList: ", end=" ")
        while temp:
            print(temp.val, end=" ")
            temp = temp.next
        print("\n")
