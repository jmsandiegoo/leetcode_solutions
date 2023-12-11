/*
 * window contains the lowest price (start) and highest price (end)
 * if lower price is detected by end pointer move start pointer to it
 */

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int startPtr = 0;
        int endPtr = 0;
        while (endPtr < prices.length) {
            if (prices[startPtr] > prices[endPtr]) startPtr = endPtr;
            int profit = prices[endPtr] - prices[startPtr];
            if (profit > maxProfit) maxProfit = profit;
            ++endPtr;
        }

        return maxProfit;
    }
}