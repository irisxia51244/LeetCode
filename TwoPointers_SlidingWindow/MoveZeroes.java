/**
 * 283，【Easy】，【Array】【Two Pointers】
 * LeetCode 283. Move Zeroes
 * Related Topics: Array, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int curIndex = 0;
        for(int num: nums){
            if(num != 0) nums[curIndex++] = num;
        }
        for(int i = curIndex; i < nums.length; i++){
            nums[i] = 0;
        }
        return;
    }
}
