"""


Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
"""

from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = 1
        output = [1] * len(nums)

        for i in range(len(nums)):
            output[i] = prefix
            prefix = prefix * nums[i]

        postfix = 1
        for i in range(len(nums) - 1, -1, -1):
            output[i] = output[i] * postfix
            postfix = postfix * nums[i]

        return output


if __name__ == "__main__":
    print(Solution().productExceptSelf([1, 2, 3, 4]))
