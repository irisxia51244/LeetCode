/**
 * 689，【Hard】，【Array】【DP】
 * LeetCode 689. Maximum Sum of 3 Non-Overlapping Subarrays
 * Related Topics: Array, Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //dynamic programming
        int[] ans = new int[3];
        if(nums == null || nums.length < 3*k || k <= 0) return ans;
        
        //dp part
        int n = nums.length;
        int[] sums = new int[n+1];
        for(int i = 1; i < sums.length; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
        
        int[][] dp = new int[n+1][4];//store max sum of 0-3 subarrays in range[0,i]
        int[][] idx = new int[n+1][4];//store idx of the previous subarrays or current if no previous;

        for(int j = 1; j < 4; j++){
            for(int i = j*k; i < dp.length; i++){
                int temp = sums[i] - sums[i-k] + dp[i-k][j-1];
                //if greater than last max, update sum and index, else, same as last
                if(temp > dp[i-1][j]){
                    dp[i][j] = temp;
                    idx[i][j] = i-k;
                }else{
                    dp[i][j] = dp[i-1][j];
                    idx[i][j] = idx[i-1][j];
                }
            }
        }
        //back track the start index
        int pos = n;
        for(int i = 2; i >=0; i--){
            ans[i] = idx[pos][i+1];
            pos = ans[i];
        }
        return ans;
    }
}
