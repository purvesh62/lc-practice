from typing import List, Any


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        """
        Solution:

        :param nums:
        :param k:
        :return:
        """
        nums_map = {}
        for i in nums:
            nums_map[i] = nums_map.get(i, 0) + 1

        output = sorted(nums_map.items(), key=lambda x: x[1], reverse=True)
        res = []
        for i in range(k):
            res.append(output[i][0])

        return res

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        heap = Heap()
        nums_map: dict = {}
        for i in nums:
            nums_map[i] = nums_map.get(i, 0) + 1

        for key, val in nums_map.items():
            heap.insert(key, val)

        output: List[int] = []

        for i in range(k):
            output.append(heap.remove().value)

        return output


class Node:
    def __init__(self, value, frequency):
        self.value = value
        self.frequency = frequency

    def __str__(self):
        return f"{self.value}: {self.frequency}"


class Heap:
    def __init__(self):
        self.heap: [Node] = []

    def __str__(self):
        print("Heap:")
        for i in self.heap:
            print(f"{i.value}: {i.frequency}")
        return ""

    def _left(self, index: int) -> int:
        return (2 * index) + 1

    def _right(self, index: int) -> int:
        return (2 * index) + 2

    def _parent(self, index: int) -> int:
        return int((index - 1) / 2)

    def _swap(self, index1: int, index2: int) -> None:
        self.heap[index1], self.heap[index2] = self.heap[index2], self.heap[index1]

    def _shrink(self, current: int) -> None:
        maxIndex: int = current
        while True:
            left: int = self._left(current)
            right: int = self._right(current)

            if left < len(self.heap) and self.heap[maxIndex].frequency < self.heap[left].frequency:
                maxIndex = left

            if right < len(self.heap) and self.heap[maxIndex].frequency < self.heap[right].frequency:
                maxIndex = right

            if maxIndex != current:
                self._swap(maxIndex, current)
                current = maxIndex
            else:
                return

    def insert(self, value: int, frequency: int) -> None:
        node = Node(value, frequency)
        self.heap.append(node)
        current = len(self.heap) - 1

        while current > 0 and self.heap[current].frequency > self.heap[self._parent(current)].frequency:
            self._swap(current, self._parent(current))
            current = self._parent(current)

    def remove(self) -> Any | None:
        if len(self.heap) == 0:
            return None

        elif len(self.heap) == 1:
            value = self.heap.pop(0)
            return value
        else:
            value = self.heap.pop(0)
            last_value = self.heap.pop(len(self.heap) - 1)
            self.heap.insert(0, last_value)
            self._shrink(0)
            return value


if __name__ == "__main__":
    print(Solution().topKFrequent([1, 1, 1, 2, 2, 3], 2))
    # print(Solution().topKFrequent([1], 1))
    # heap = Heap()
    # heap.insert(1, 3)
    # heap.insert(2, 2)
    # heap.insert(3, 1)
    # heap.insert(4, 15)
    # heap.insert(5, 12)
    # heap.insert(6, 16)
    # print("Initial")
    # print(heap)
    #
    # temp: Node = heap.remove()
    # print(f"Removed Node -> {temp}")
    #
    # print(heap)
    #
    # temp = heap.remove()
    # print(f"Removed Node -> {temp}")
    #
    # print(heap)
    # temp = heap.remove()
    # print(f"Removed Node -> {temp}")
    #
    # print("Final heap")
    # print(heap)
