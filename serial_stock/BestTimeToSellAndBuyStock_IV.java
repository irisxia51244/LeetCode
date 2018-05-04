import java.util.*;
/**
 * 188，【Hard】，【DP】
 * LeetCode 188. Best Time to Buy and Sell Stock IV
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(n) best, O(kn), Space Complexity: O(1) best, O(kn);
 */


class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int n = prices.length;
        if(k >= n/2) return helper(prices);
        
        int[][] dp = new int[k+1][n];
        for(int i = 1; i < k+1; i++){
            int temp = -prices[0];
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i][j-1], temp+prices[j]);
                temp = Math.max(temp, dp[i-1][j-1] - prices[j]);
            }
        }
        return dp[k][n-1];
    }
    
    private int helper(int[] prices){
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}
