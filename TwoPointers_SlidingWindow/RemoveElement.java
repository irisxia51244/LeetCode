/**
 * 27，【Easy】，【Array】【Two Pointers】
 * LeetCode 27. Remove Element
 * Related Topics: Array, Two Pointers
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */


class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        for(int n: nums){
            if(n != val){
                nums[i++] = n;
            }
        }
        return i;
    }
}
