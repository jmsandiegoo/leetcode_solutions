
/*
 * have a hashmap for values already exist if already in hashmap then it means its duplicate
 */

import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> occurenceMap = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (occurenceMap.containsKey(nums[i]))
                return true;

            occurenceMap.put(nums[i], true);
        }

        return false;
    }
}