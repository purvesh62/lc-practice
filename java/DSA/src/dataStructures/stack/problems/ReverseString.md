# Reverse String

## Prompt


The `reverseString` method takes a single parameter String, which is the string you want to reverse.

Return a new `String` with the letters in reverse order.

This method will be written in the same class as the main method, so it will be `static`.  
For more information on static methods click on "Hints."

This will use the `Stack` class we created in the last two coding exercises:

- Method signature: `public void reverseBetween(int m, int n)`

```java
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);
        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */
    }

    public static reverseString(String ipStr) {
        Stack<Character> dataStructures.stack = new Stack<>();
        String reverseString = "";
        for (char c : ipStr.toCharArray()) {
            dataStructures.stack.push(c);
        }

        while (!dataStructures.stack.isEmpty()) {
            reverseString += dataStructures.stack.pop();
        }
        return reverseString;
    }
}
```