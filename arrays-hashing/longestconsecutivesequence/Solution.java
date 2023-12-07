/*
 * have a hashmap of the occurences
 * start with the lowest number in the array
 * check consecutive if in hashtable then ++counter
 * if not found reset counter and ++base
 */

import java.util.HashMap;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> occurenceMap = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) { // O(n)
            if (occurenceMap.containsKey(nums[i])) continue;
            occurenceMap.put(nums[i], true);
        }

        int largestCount = 0;
        for (int i = 0; i < nums.length; ++i) { // O(n) 
            if (occurenceMap.containsKey(nums[i])) continue;

            int currCount = 1;
            int seqCurrNo = nums[i];
            while (occurenceMap.containsKey(++seqCurrNo)) {
                ++currCount;
            }

            if (currCount > largestCount) largestCount = currCount;
        }

        return largestCount;
    }
}