
/*
 * Have a hashmap of all the numbers and their indices as the value
 * Loop through input subtract sum with the current number and find the diff in
 * the hashmap
 * return the two index accordingly
 * how to deal with duplicates?
 * have an array of indexes instead
 */

import java.util.ArrayList;
import java.util.HashMap;

/* Not so optimal solution 7ms
 * class Solution {
 * public int[] twoSum(int[] nums, int target) {
 * HashMap<Integer, ArrayList<Integer>> operandMap = new HashMap<>();
 * 
 * for (int i = 0; i < nums.length; ++i) {
 * ArrayList<Integer> idxs = operandMap.getOrDefault(nums[i], new
 * ArrayList<>());
 * idxs.add(i);
 * operandMap.put(nums[i], idxs);
 * }
 * 
 * int[] res = new int[2];
 * 
 * for (int i = 0; i < nums.length; ++i) {
 * int op2 = target - nums[i];
 * ArrayList<Integer> op2Idxs = operandMap.get(op2);
 * if (op2Idxs == null || (op2 == nums[i] && op2Idxs.size() <= 1))
 * continue;
 * 
 * if (op2 == nums[i]) {
 * res = new int[] { i, op2Idxs.get(1) };
 * } else {
 * res = new int[] { i, op2Idxs.get(0) };
 * }
 * 
 * break;
 * }
 * 
 * return res;
 * }
 * }
 */

// More optimal solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> opMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int op2 = target - nums[i];
            int idx = opMap.getOrDefault(op2, -1);

            if (idx >= 0) {
                return new int[] { i, idx };
            }

            opMap.put(nums[i], i);
        }

        return new int[] { -1, -1 };
    }
}
