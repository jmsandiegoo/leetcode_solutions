/*
* have a hashmap of frequency for the items but using avl tree is O(nlogn) operations
* so we can just traverse each hashmap record and just take the highest
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        int maxFreq = 0;
        for (int i = 0; i < nums.length; ++i) { // O(N)
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            if (freqMap.get(nums[i]) > maxFreq) {
                maxFreq = freqMap.get(nums[i]);
            }
        }

        ArrayList<Stack<Integer>> freqDat = new ArrayList<>(maxFreq + 1);
        for (int i = 0; i < maxFreq; ++i) {
            freqDat.add(new Stack<>());
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Stack<Integer> stack = freqDat.get(entry.getValue());
            stack.push(entry.getKey());
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = maxFreq; i >= 0; --i) {
            if (k <= 0)
                break;
            Stack<Integer> s = freqDat.get(i);
            if (s.isEmpty())
                continue;
            while (k > 0 && !s.isEmpty()) {
                res[idx++] = s.pop();
                --k;
            }
        }

        return res;
    }
}