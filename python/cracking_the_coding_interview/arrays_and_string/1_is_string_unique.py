"""
Is Unique:
    Implement an algorithm to determine if a string has all unique characters.
    What if you cannot use additional data structures?

Intuition:
    - If used hash then it is easily doable.
    - If the input is in ASCII or Unicode?
    - Assuming ASCII value.
"""


class Solution:

    def is_unique(self, string: str) -> bool:
        """

        :param string: Input string
        :return: Boolean return True if all characters in the string are unique else False.ß
        """
        print(f"Running test\nInput: {string}")
        if not string:
            return False

        if len(string) > 1:
            char_map = [False] * 127
            for i in string:
                if char_map[ord(i)]:
                    return False
                else:
                    char_map[ord(i)] = True
            return True
        else:
            return True


if __name__ == "__main__":
    print(Solution().is_unique("abcde"))
    print(Solution().is_unique("abcdeabas"))
