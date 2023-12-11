/*
* sort the array then traverse each unique num as op1
* op2 and op3 find by two pointer two sum method as it is already sorted
* use hashset to check for duplicates with the current op1
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // O(nlogn)
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) { //O(n^2)
            if (i > 0 && nums[i] == nums[i-1]) continue;

            HashSet<Integer> added = new HashSet<>();
            // two pointer sum approach
            int ptr1 = i + 1;
            int ptr2 = nums.length - 1;
            while (ptr1 < ptr2) {
                int sum = nums[i] + nums[ptr1] + nums[ptr2];
                if (sum == 0 && (!added.contains(nums[ptr1]) || !added.contains(nums[ptr2]))) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[ptr1], nums[ptr2])));
                    added.add(nums[ptr1]);
                    added.add(nums[ptr2]);
                    ++ptr1;
                    --ptr2;
                } else if (sum > 0) {
                    --ptr2;
                } else {
                    ++ptr1;
                }
            }
        }

        return res;
    }
}