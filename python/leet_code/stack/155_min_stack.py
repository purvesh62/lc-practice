class min_stack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    # def push(self, val: int) -> None:
    #     self.stack.append(val)
    # 
    #     if not self.min_stack or val <= self.min_stack[-1]:
    #         self.min_stack.append(val)
    # 
    # def pop(self) -> None:
    #     if self.stack:
    #         if self.stack[-1] == self.min_stack[-1]:
    #             self.min_stack.pop()
    #         self.stack.pop()

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.min_stack:
            val = min(self.min_stack[-1], val)
        self.min_stack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]


if __name__ == "__main__":
    stack = min_stack()
    stack.push(2)
    stack.push(0)
    stack.push(3)
    stack.push(0)
    print(stack.getMin())
    stack.pop()
    print(stack.getMin())
    stack.pop()
    print(stack.getMin())
    stack.pop()
    print(stack.getMin())
