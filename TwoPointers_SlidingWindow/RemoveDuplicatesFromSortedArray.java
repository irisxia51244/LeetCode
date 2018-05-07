/**
 * 26，【Easy】，【Array】【Two pointers】
 * LeetCode 26. Remove Duplicates from Sorted Array
 * Related Topics: Array, Two pointers
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */
 
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        for(int num : nums){
            if(i == 0 || num > nums[i-1]) nums[i++] = num;
        }
        return i;
    }
}
