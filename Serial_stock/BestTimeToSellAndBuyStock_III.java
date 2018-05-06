import java.util.*;
/**
 * 123，【Hard】，【Array】【DP】
 * LeetCode 123. Best Time to Buy and Sell Stock III
 * Related Topics: Array, Dynamic Programming
 * @author Iris Xia.
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int buy1 = - prices[0], buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for(int p: prices){
            sell2 = Math.max(sell2, buy2 + p);
            buy2 = Math.max(buy2, sell1 - p);
            sell1 = Math.max(sell1, buy1 + p);
            buy1 = Math.max(buy1, -p);
        }
        return sell2;
    }
}
