/*
 * intuition:
 * O(n) means one pass algo prob
 * need to memoize the product we can use hashmap where each index has its own product
 * calculate the running prefix then postfix
 * then given i get the i-1 (prefix) and i+1 (postfix) can do it with output array
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        // calculate the prefix product O(n)
        int currPrefix = 1;
        for (int i = 0; i < nums.length; ++i) {
            res[i] = currPrefix;
            currPrefix *= nums[i];
        }

        // caclulate postfix and multiply it directly
        int currPostfix = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            res[i] *= currPostfix;
            currPostfix *= nums[i];
        }

        return res;
    }
}
