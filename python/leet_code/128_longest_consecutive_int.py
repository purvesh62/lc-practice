from typing import List


class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums_set = set(nums)
        count = 1
        for i in nums:
            if i - 1 not in nums_set:
                temp_count = 1
                j = i
                while (i + temp_count) in nums_set:
                    temp_count += 1

                count = max(count, temp_count)
        return count


        # maxLen = 0
        # for num in nums:
        #     if not(num-1 in numSet):
        #         tempLen = 1
        #         while num+tempLen in numSet:
        #             tempLen += 1
        #         if tempLen > maxLen:
        #             maxLen = tempLen
        #             if maxLen > len(nums)/2:
        #                 return maxLen
        # return maxLen

if __name__ == "__main__":
    print(Solution().longestConsecutive([100, 4, 200, 1, 3, 2]))
