"""
Problem 121. Best time to buy and sell stock

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.


Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

"""
from typing import List


class Solution:

    # Two pointers
    def max_profit(self, prices: List[int]) -> int:
        profit = 0
        pointer1 = 0
        pointer2 = 1

        while pointer2 < len(prices):
            if prices[pointer1] < prices[pointer2]:
                profit = max(profit, prices[pointer2] - prices[pointer1])
                pointer2 += 1
            else:
                pointer1 = pointer2
                pointer2 += 1
        return profit

    def brute_force_max_profit(self, prices: List[int]) -> int:
        profit = 0

        for i in range(len(prices)):
            for j in range(i + 1, len(prices)):
                diff = prices[j] - prices[i]
                if profit < diff:
                    profit = diff

        return profit


if __name__ == "__main__":
    print(Solution().max_profit([7, 1, 5, 3, 6, 4]))
    print(Solution().max_profit([7, 6, 4, 3, 1]))
