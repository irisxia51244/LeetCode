/**
 * 268，【Easy】，【Array】【Math】【BitManipulation】
 * LeetCode 268. Missing Number
 * Related Topics: Array, Math, Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        ans = (1+nums.length)*nums.length/2 - sum;
        return ans;
    }
}
