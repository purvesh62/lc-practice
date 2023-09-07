"""
Check permutation
Given two strings, write a method to decide if one is a permutation of the other.

Input: abcd edca
Output: False


"""


class Solution:
    def check_permutation(self, string1: str, string2: str) -> bool:
        if len(string1) != len(string2):
            return False

        char_check = [0] * 128

        for i in string1:
            char_check[ord(i)] += 1

        for i in string2:
            char_check[ord(i)] -= 1
            if char_check[ord(i)] < 0:
                return False
        return True


if __name__ == "__main__":
    print(Solution().check_permutation("dog", "god"))
    print(Solution().check_permutation("doogg", "ggood"))
