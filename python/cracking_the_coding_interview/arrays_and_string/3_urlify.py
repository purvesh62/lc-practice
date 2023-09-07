"""

"""


class Solution:
    def urlify(self, string: str, length: int) -> str:
        string = string[:length]
        str_array = string.split(" ")
        return "%20".join(str_array)

if __name__ == "__main__":
    print(Solution().urlify("Mr John Smith     ", 13))
