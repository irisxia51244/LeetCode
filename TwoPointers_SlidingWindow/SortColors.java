/**
 * 75，【Medium】，【Array】【Two Pointers】【Sort】
 * LeetCode 75. Sort Colors
 * Related Topics: Array, Two Pointers, Sort
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */


class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int left = 0, right = nums.length - 1;
        for(int i = 0; i <= right; i++){
            if(nums[i] == 0) swap(nums, i, left++);
            else if(nums[i] == 2) swap(nums, i--, right--);
        }
        return;
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
