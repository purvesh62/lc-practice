"""
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
"""
from typing import List

class Solution:
    def setZeroesBruteForce(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        update_rows_columns = set()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]==0:
                    # Rows of matrix to -1
                    for k in range(len(matrix)):
                        matrix[k][j] = -1
                    
                    # Columns of matrix to -1
                    matrix[i][:] = [-1] * len(matrix[0])

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]==-1:
                    matrix[i][j]=0

        print(matrix)

    def setZeroes(self, matrix: List[List[int]]) -> None:
        r = len(matrix)
        c = len(matrix[0])

        row = [0] * r
        col = [0] * c

        for i in range(r):
            for j in range(c):
                if matrix[i][j] == 0:
                    row[i] = 1
                    col[j] = 1
        
        for i in range(r):
            for j in range(c):
                if row[i] == 1 or col[j] == 1:
                    matrix[i][j] = 0
        
        print(matrix)

# Solution().setZeroesBruteForce([[1,1,1],[1,0,1],[1,1,1]])
Solution().setZeroes([[1,1,1],[1,0,1],[1,1,1]])