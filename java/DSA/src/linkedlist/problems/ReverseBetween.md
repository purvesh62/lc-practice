# Reverse Between

## Prompt

In the LinkedList class, implement a method called `reverseBetween` that reverses the nodes of the list between indexes
m and n (inclusive).

- Method signature: `public void reverseBetween(int m, int n)`

The method should not return any value, and it should modify the original linked list.

The positions m and n are 0-indexed.

## Example

Given the following linked list:

1 -> 2 -> 3 -> 4 -> 5

Calling reverseBetween(1, 3) should result in the following modified linked list:

1 -> 4 -> 3 -> 2 -> 5

## Notes:

- The Linked List does not have a tail which will make the implementation easier
- The method should not duplicate any of the existing nodes, only rearranging the existing nodes in the list.
- However, the creation of a limited number of new nodes is allowed (e.g., dummy nodes to facilitate the partitioning
  process).
- The method should not use any extra data structures such as arrays or lists.

```java
class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        myList.reverseBetween(1, 3);
    }
}
```