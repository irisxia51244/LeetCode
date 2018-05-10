/**
 * 518，【Medium】
 * LeetCode 518. Coin Change 2
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 1;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int i = coin; i < dp.length; i++){
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
