"""
Problem 217. Contains Duplicate

Given an integer array nums, return true if any value appears at least
twice in the array, and return false if every element is distinct.

Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

"""

from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        unique_nums = set(nums)
        if len(unique_nums) != len(nums):
            return True
        else:
            return False


if __name__ == "__main__":
    print(Solution().containsDuplicate([1, 1, 1, 3, 3, 4, 3, 2, 4, 2]))
    print(Solution().containsDuplicate([1, 2, 3, 4]))
    print(Solution().containsDuplicate([1, 2, 3, 1]))