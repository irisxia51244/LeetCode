/**
 * 53，【Easy】，【Array】【Divide&Conquer】【DP】
 * LeetCode 53. Maximum Subarray
 * Related Topics: Array, Divide and Conquer, Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int sum = max;
        for(int i = 1; i < nums.length; i++){
            sum = nums[i] + (sum > 0?sum : 0);
            max = Math.max(sum, max);
        }
        return max;
    }
}
