"""
hard

"""


class Solution:
    def hcp_calculate(self, num1: int, num2: int) -> int:
        max_common_factor = 1
        for i in range(1, min(num1, num2)):
            if num1 % i == 0 and num2 % i == 0:
                max_common_factor = max(max_common_factor, i)

        return max_common_factor


if __name__ == "__main__":
    print(Solution().hcp_calculate(70, 15))
