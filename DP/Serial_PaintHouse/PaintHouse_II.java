/**
 * 265，【Hard】，【Dynamic Programming】
 * LeetCode 265. Paint House II
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int preIndex = -1;
        int[][] dp = new int[costs.length+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i < dp.length; i++){
            int index = 0;
            for(int j = 0; j < costs[0].length;j++){
                int cost = costs[i-1][j] + ((j==preIndex)?dp[i-1][1]:dp[i-1][0]);
                if(dp[i][0] == 0 || cost <= dp[i][0]){
                    dp[i][1] = dp[i][0];
                    dp[i][0] = cost;
                    index = j;
                }else if(dp[i][1] == 0 || cost < dp[i][1]){
                    dp[i][1] = cost;
                }
            }
            preIndex = index;
        }
        return dp[costs.length][0];
    }
}
