# Has Loop

## Prompt

Implement a method called `hasLoop` that checks whether the list contains a loop or not.

If the list contains a loop, the method should return `true` otherwise, it should return `false`.

- Method signature: `public boolean hasLoop()`

## Example

```java
class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);

        boolean result = myList.hasLoop(); // Output: false

        // Manually create a loop for testing purposes
        myList.getHead().next.next.next = myList.getHead().next;

        result = myList.hasLoop(); // Output: true   
    }
}
```