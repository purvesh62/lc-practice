"""
https://leetcode.com/problems/valid-parentheses/

Input: "()"
Output: true

Input: "()[]{}"
Output: true

Input: "(]"
Output: false
"""


class Solution:
    def isValid(self, s: str) -> bool:
        stack = Stack()
        for char in s:
            if char in ["(", "[", "{"]:
                stack.push(char)
            elif char == ")" and "(" != stack.pop():
                return False
            elif char == "]" and "[" != stack.pop():
                return False
            elif char == "}" and "{" != stack.pop():
                return False

        if stack.length() == 0:
            return True
        return False

    def isValid(self, s):
        mapping = {']': '[', '}': '{', ')': '('}
        stack = []
        for i in s:
            if i not in mapping:
                stack.append(i)
            else:
                if len(stack) == 0:
                    return False
                if mapping[i] != stack.pop():
                    return False

        return True if len(stack) == 0 else False


class Stack:
    def __init__(self):
        self.stack = []

    def push(self, value: str) -> None:
        self.stack.append(value)

    def pop(self) -> str | None:
        if len(self.stack) > 0:
            return self.stack.pop()
        return None

    def length(self):
        return len(self.stack)


if __name__ == "__main__":
    print(Solution().isValid("{{()[]{}}}"))
