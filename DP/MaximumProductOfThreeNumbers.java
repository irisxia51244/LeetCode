/**
 * 628，【Easy】，【Array】【Math】
 * LeetCode 628. Maximum Product of Three Numbers
 * Related Topics: Array, Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int maximumProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 3){
            return nums[0]*nums[1]*nums[2];
        }
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;
        int max3 = Integer.MAX_VALUE;
        int min1 = Integer.MIN_VALUE;
        int min2 = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(max1 == Integer.MAX_VALUE || nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
                
            }
            else if(max2 == Integer.MAX_VALUE || nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }
            else if(max3 == Integer.MAX_VALUE || nums[i] > max3){
                max3 = nums[i];
            }
            
            if(min1 == Integer.MIN_VALUE || nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(min2 == Integer.MIN_VALUE || nums[i] < min2){
                min2 = nums[i];
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
