import java.util.*;
/**
 * 122，【Easy】，【Array】【Greedy】
 * LeetCode 122. Best Time to Buy and Sell Stock II
 * Related Topics: Array, Greedy
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int total = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i]-prices[i-1];
            total += diff > 0?diff:0;
        }
        return total;
    }
}
