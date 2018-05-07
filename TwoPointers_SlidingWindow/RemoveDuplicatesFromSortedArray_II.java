/**
 * 80，【Medium】，【Array】【Two Pointers】
 * LeetCode 80. Remove Duplicates from Sorted Array II
 * Related Topics: Array, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length < 3) return nums.length;
        int count = 1;
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] == nums[i-1] && nums[i] == nums[i+1]) continue;
            nums[count++] = nums[i];
        }
        nums[count++] = nums[nums.length-1];
        return count;
    }
}
