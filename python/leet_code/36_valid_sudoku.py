import collections
from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        cols = collections.defaultdict(set)
        rows = collections.defaultdict(set)
        squares = collections.defaultdict(set)  # key = (r /3, c /3)

        for r in range(9):
            for c in range(9):
                if board[r][c] == ".":
                    continue
                if (board[r][c] in rows[r] or
                        board[r][c] in cols[c] or
                        board[r][c] in squares[(r // 3, c // 3)]):
                    return False
                cols[c].add(board[r][c])
                rows[r].add(board[r][c])
                squares[(r // 3, c // 3)].add(board[r][c])
        return True

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        nums_set = set()

        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num != '.':
                    if (i, num) in nums_set or (num, j) in nums_set or (i // 3, j // 3, num) in nums_set:
                        return False
                    nums_set.add((i, num))
                    nums_set.add((num, j))
                    nums_set.add((i // 3, j // 3, num))

        return True


if __name__ == "__main__":
    Solution().isValidSudoku([["5", "3", ".", ".", "7", ".", ".", ".", "."]
                                 , ["6", ".", ".", "1", "9", "5", ".", ".", "."]
                                 , [".", "9", "8", ".", ".", ".", ".", "6", "."]
                                 , ["8", ".", ".", ".", "6", ".", ".", ".", "3"]
                                 , ["4", ".", ".", "8", ".", "3", ".", ".", "1"]
                                 , ["7", ".", ".", ".", "2", ".", ".", ".", "6"]
                                 , [".", "6", ".", ".", ".", ".", "2", "8", "."]
                                 , [".", ".", ".", "4", "1", "9", ".", ".", "5"]
                                 , [".", ".", ".", ".", "8", ".", ".", "7", "9"]])
