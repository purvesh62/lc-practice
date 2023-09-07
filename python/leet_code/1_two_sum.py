# Input
# nums = [2,7,11,15]
# target = 9
# Output
# [0,1] -> because 2 + 7 = 9
from typing import List


class Solution:
    def two_sum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for index, value in enumerate(nums):
            x = target - value
            if map.get(x, None) != None:
                return [map.get(x), index]
            else:
                map[value] = index
        return None


if __name__ == "__main__":
    ip_arr = [2, 7, 11, 15]
    ip_target = 9
    print(Solution().two_sum(ip_arr, ip_target))

    ip_arr = [3, 2, 4]
    ip_target = 6
    print(Solution().two_sum(ip_arr, ip_target))

    ip_arr = [3, 3]
    ip_target = 6
    print(Solution().two_sum(ip_arr, ip_target))
