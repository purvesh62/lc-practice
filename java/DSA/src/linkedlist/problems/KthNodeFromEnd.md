# Kth linkedlist.Node form End

## Prompt

Implement a method called `findKthFromEnd` that returns the k-th `node` from the end of the list.

- If the list has fewer than k nodes, the method should return `null`.

- Method signature: `public linkedlist.Node findKthFromEnd(int k)`

**Note**: This implementation of the Linked List class does not have the length attribute.

## Example

```java
import linkedlist.Node;

class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        Node result = myList.findKthFromEnd(2); // Output: linkedlist.Node with value 4

        result = myList.findKthFromEnd(5); // Output: linkedlist.Node with value 1

        result = myList.findKthFromEnd(6); // Output: null       
    }
}
```