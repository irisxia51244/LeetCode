/**
 * 152，【Medium】，【Math】【Dynamic Programming】
 * LeetCode 152. Maximum Product Subarray
 * Related Topics: Math, Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */
 
 class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int max = res;
        int min = res;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
