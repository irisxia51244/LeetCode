/**
 * 724，【Easy】，【Array】
 * LeetCode 724. Find Pivot Index
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        int cur = 0;
        for(int i = 0; i < nums.length; i++){
            if(cur*2 + nums[i] == sum) return i;
            cur += nums[i];
        }
        return -1;
    }
}
