/**
 * 213，【Medium】，【DP】
 * LeetCode 213. House Robber II
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int rob(int[] nums) {
        //if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length-1));
    }
    
     public int helper(int[] nums, int start, int end) {
        //if(nums == null || nums.length == 0) return 0;
        int[] pre = new int[2];
        for(int i = start; i <= end; i++){
            int temp = pre[0];
            pre[0] = Math.max(pre[0], pre[1]);
            pre[1] = temp + nums[i];
        }
        return Math.max(pre[0], pre[1]);
    }
}
