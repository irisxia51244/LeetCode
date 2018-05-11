import java.util.*;
/**
 * 714，【Medium】，【Array】【DP】【Greedy】
 * LeetCode 714. Best Time to Buy and Sell Stock with Transaction Fee
 * Related Topics: Array, Dynamic Programming, Greedy
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1);
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int buy = -prices[0];
        int sell = 0;
        for(int i = 1; i < prices.length; i++){
            int temp = sell;
            sell = Math.max(sell, prices[i] + buy - fee);
            buy = Math.max(buy, temp - prices[i]);
        }
        return Math.max(sell, buy);
    }
}
