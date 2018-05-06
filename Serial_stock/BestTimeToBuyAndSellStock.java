import java.util.*;
/**
 * 121，【Easy】，【Array】【DP】
 * LeetCode 121. Best Time to Buy and Sell Stock
 * Related Topics: Array, Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for(int p: prices){
            if(p < minPrice){
                minPrice = p;
            }else{
                maxProfit = Math.max(maxProfit, p - minPrice);
            }
        }
        return maxProfit;
    }
}
