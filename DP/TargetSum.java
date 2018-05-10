/**
 * 494，【Medium】，【DP】【DFS】
 * LeetCode 494. Target Sum
 * Related Topics: Dynamic Programming, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        //permutation, brute force, 2^n
        //dp
        int sum = 0;
        for(int n: nums){
            sum+=n;
        }
        if(sum < S || S < -sum) return 0;
        
        int[] dp = new int[2*sum+1];
        dp[sum] = 1;
        for(int i = 0; i < nums.length; i++){
            int[] temp = new int[2*sum+1];
            for(int j = 0; j < 2*sum+1; j++){
                if(dp[j]!=0){
                    temp[j+nums[i]] += dp[j];
                    temp[j-nums[i]] += dp[j];
                }
            }
            dp = temp;
        }
        return dp[sum+S];
    }
}
