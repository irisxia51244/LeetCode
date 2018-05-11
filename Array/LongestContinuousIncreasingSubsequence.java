/**
 * 674，【Easy】，【Array】
 * LeetCode 674. Longest Continuous Increasing Subsequence
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] < nums[i]){
                count++;
                max = Math.max(count, max);
            }else{
                count = 1;
            }
        }
        return max;
    }
}
