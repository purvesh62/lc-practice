from typing import List


class Solution:
    """
    @param: strs: a list of strings
    @return: encodes a list of strings to a single string.
    """

    def encode(self, strs: List) -> str:
        # write your code here
        encoded_str = ""
        for element in strs:
            encoded_str += str(len(element)) + "#" + element
        return encoded_str

    """
    @param: str: A string
    @return: decodes a single string to a list of strings
    """

    def decode(self, str: str) -> List:
        output = []
        i = 0
        while str != "":
            count = int(str[i])
            output.append(str[i + 2:i + 2 + count])
            str = str[i + 2 + count:]
        return output


if __name__ == "__main__":
    input = ["#we#", "say#", ":", "yes#"]
    encoded_string = Solution().encode(input)
    print(encoded_string)

    output: List = Solution().decode(encoded_string)
    print(output)
