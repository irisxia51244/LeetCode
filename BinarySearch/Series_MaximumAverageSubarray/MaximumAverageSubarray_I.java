/**
 * 643，【Easy】，【Array】
 * LeetCode 643. Maximum Average Subarray I
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(count < k){
                sum += nums[i];
                max = sum;
                count++;
            }
            else{
                sum = sum - nums[i-k] + nums[i];
                max = Math.max(sum, max);
            }
        }
        return (double)max/k;
    }
}
