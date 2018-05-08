/**
 * 198， 【Easy】, 【DP】
 * LeetCode 198. House Robber
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] pre = new int[2];
        for(int n : nums){
            int temp = pre[0];
            pre[0] = Math.max(pre[0], pre[1]);
            pre[1] = temp + n;
        }
        return Math.max(pre[0], pre[1]);
    }
}
