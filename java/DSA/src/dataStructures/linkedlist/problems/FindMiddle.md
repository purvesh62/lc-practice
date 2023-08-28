# Find Middle

## Prompt

Implement a method called `findMiddleNode` that returns the middle node of the linked list.

If the list has an even number of nodes, the method should return the `second middle node`.


- Method signature: `public dataStructures.linkedlist.Node findMiddleNode()`


## Example

```java
import dataStructures.linkedlist.Node;

class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Node middleNode = myList.findMiddleNode();
        System.out.println(middleNode.value); // Output: 3

        myList.append(6);
        middleNode = myList.findMiddleNode();
        System.out.println(middleNode.value); // Output: 4
    }
}
```