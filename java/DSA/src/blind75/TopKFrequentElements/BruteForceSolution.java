package blind75.TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;

public class BruteForceSolution {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i = 0; i < k; i++) {
            int key = getMax(map);
            arr.add(key);
            map.remove(key);
        }
        int[] op = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            op[i] = arr.get(i);
        }
        return op;
    }

    public static int getMax(HashMap<Integer, Integer> map) {
        int maxElementKey = 0;
        int maxElementFreq = 0;
        for (int i : map.keySet()) {
            if (maxElementFreq < map.get(i)) {
                maxElementFreq = map.get(i);
                maxElementKey = i;
            }
        }
        return maxElementKey;
    }
}
