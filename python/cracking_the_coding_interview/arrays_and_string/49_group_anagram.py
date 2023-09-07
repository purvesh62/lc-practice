from collections import defaultdict
from typing import List, Any


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        Complexity ->
            O (m * nlog(n))
            m = number of elements in the list
            n = average size of the string

        :param strs:
        :return:
        """

        s_map = {}

        for i in range(len(strs)):
            sorted_i = ''.join(sorted(strs[i]))
            if s_map.get(sorted_i):
                s_map[sorted_i].append(i)
            else:
                s_map[sorted_i] = [i]

        output = []

        for i in s_map.keys():
            indexes = []
            for j in s_map[i]:
                indexes.append(strs[j])
            output.append(indexes)

        return output

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        """
        Another solution ->
            0 (m * n)
            Where m = number of strings in the list
            n = average length of string

        :param strs:
        :return:
        """

        res = defaultdict(list)

        for str in strs:
            count = [0] * 26

            for c in str:
                count[ord(c) - ord("a")] += 1

            res[tuple(count)].append(str)

        return res.values()




if __name__ == "__main__":
    Solution().groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"])
