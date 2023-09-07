"""

Input1: abcd
"""


class Solution:
    @staticmethod
    def mergeAlternately(word1: str, word2: str) -> str:
        word1_inc = 0
        merged_word = []
        for letter in word1:
            merged_word.append(letter)
            if word1_inc < len(word2):
                merged_word.append(word2[word1_inc])
                word1_inc += 1

        if word1_inc < len(word2):
            merged_word.extend(word2[word1_inc:])
        return ''.join(merged_word)


class BestSolution:
    @staticmethod
    def mergeAlternately(word1: str, word2: str) -> str:
        r = ''
        for i in range(min(len(word1), len(word2))):
            r += word1[i]
            r += word2[i]
        if len(word1) > len(word2):
            r += word1[len(word2):]
        else:
            r += word2[len(word1)]
        return r
