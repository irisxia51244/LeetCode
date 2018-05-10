/**
 * 322，【Medium】，【DP】
 * LeetCode 322. Coin Change
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        for(int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin <= i && dp[i - coin] != -1){
                    min = Math.min(min, dp[i-coin]+1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE?-1:min;
        }
        return dp[amount];
    }
}
