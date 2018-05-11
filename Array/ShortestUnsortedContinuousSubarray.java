/**
 * 581，【Easy】，【Array】
 * LeetCode 581. Shortest Unsorted Continuous Subarray
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int tail = nums.length - 1;
        int start = 0;
        int end = -1;
        int max = nums[0];
        int min = nums[tail];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(nums[i], max);
            min = Math.min(nums[tail-i], min);
            if(nums[i] < max){
                end = i;
            }
            if(nums[tail-i] > min){
                start = tail - i;
            }
        }
        return end - start + 1;

    }
}
