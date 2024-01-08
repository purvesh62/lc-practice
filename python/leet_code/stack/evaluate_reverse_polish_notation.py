from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # stack = Stack()
        stack = []
        for char in tokens:
            if char in ["+", "-", "*", "/"]:
                n1 = stack.pop()
                n2 = stack.pop()
                stack.append(int(eval(f"{n2} {char} {n1}")))
            else:
                stack.append(char)
        return int(stack.pop())


class Stack:
    def __init__(self):
        self.stack = []

    def push(self, val):
        self.stack.append(val)

    def pop(self):
        if self.stack:
            return self.stack.pop()


if __name__ == "__main__":
    print(Solution().evalRPN(["4", "13", "5", "/", "+"]))
