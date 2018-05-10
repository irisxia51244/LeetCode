/**
 * 486，【Medium】，【DP】【minimax】
 * LeetCode 486. Predict the Winner
 * Related Topics: Dynamic Programming, minimax
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int n = nums.length;
        int[] dp = new int[n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                dp[j] = i == j?nums[i]:Math.max(nums[i] - dp[j], nums[j] - dp[j-1]);
            }
        }
        return dp[n-1] >= 0;
    }
}
