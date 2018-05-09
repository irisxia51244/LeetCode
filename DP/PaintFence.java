/**
 * 276，【Easy】，【Dynamic Programming】
 * LeetCode 276. Paint Fence
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int numWays(int n, int k) {
        if(n == 0) return 0;
        /* cols: same diff, rows: 1 - n
        */
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = k;
        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = (dp[i-1][0] + dp[i-1][1]) * (k-1);
        }
        return dp[n-1][0] + dp[n-1][1];
    }
}
