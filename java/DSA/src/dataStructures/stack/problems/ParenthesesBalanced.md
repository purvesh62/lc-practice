# Parentheses Balanced

## Prompt

Check to see if a string of parentheses is balanced or not.

By "balanced," we mean that for every open parenthesis, there is a matching closing parenthesis in the correct order.
For example, the string "((()))" has three pairs of balanced parentheses, so it is a balanced string. On the other hand,
the string "(()))" has an imbalance, as the last two parentheses do not match, so it is not balanced. Also, the
string ")(" is not balanced because the close parenthesis needs to follow the open parenthesis.

Your program should take a string of parentheses as input and return `true` if it is balanced, or `false` if it is not. In
order to solve this problem, use a `Stack` data structure.

```java
public class Main {

    public static boolean isBalancedParentheses(String ipStr) {
        Stack<Character> dataStructures.stack = new Stack<>();

        for (char p : ipStr.toCharArray()) {
            if (p == '(') {
                dataStructures.stack.push(p);
            } else if (p == ')') {
                if (dataStructures.stack.isEmpty() || dataStructures.stack.pop() != '(') {
                    return false;
                }
            }
        }
        return dataStructures.stack.isEmpty();
    }


    public static void main(String[] args) {
        String s1 = "()()()";
        String s2 = "()(()";
        String s3 = "(()())";
        System.out.println(isBalancedParentheses(s1)); // true
        System.out.println(isBalancedParentheses(s2)); // false
        System.out.println(isBalancedParentheses(s3)); // true
        
        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
        */
    }
}
```