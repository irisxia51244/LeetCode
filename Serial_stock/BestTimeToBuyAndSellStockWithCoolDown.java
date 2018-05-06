import java.util.*;
/**
 * 309，【Medium】，【DP】
 * LeetCode 309. Best Time to Buy and Sell Stock with Cooldown
 * Related Topics: Dynamic Programming
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int sell = 0, sell_pre = 0;
        int buy = -prices[0];
        for(int i = 1; i < prices.length; i++){
            int temp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell_pre - prices[i]);
            sell_pre = temp;
        }
        return Math.max(sell, buy);
    }
}
