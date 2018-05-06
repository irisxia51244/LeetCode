/**
 * 55，【Medium】，【Array】【Greedy】
 * LeetCode 55. Jump Game
 * Related Topics: Array, Greedy
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > max) return false;
            max = Math.max(max, nums[i] + i);
            if(max >= nums.length-1) break;
        }
        return true;
    }
}
