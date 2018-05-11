/**
 * 747，【Easy】，【Array】
 * LeetCode 747. Largest Number At Least Twice of Others
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int dominantIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        int idx_1 = 0;
        int idx_2 = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[idx_1]){
                idx_2 = idx_1;
                idx_1 = i;
            }
            else if(idx_2 == -1 || nums[i] > nums[idx_2]){
                idx_2 = i;
            }
        }
        return nums[idx_1] >= nums[idx_2]*2?idx_1:-1;
    }
}
