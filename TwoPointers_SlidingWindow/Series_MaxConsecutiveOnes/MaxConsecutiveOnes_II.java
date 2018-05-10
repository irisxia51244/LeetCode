/**
 * 487，【Medium】，【Two Pointers】
 * LeetCode 487. Max Consecutive Ones II
 * Related Topics: Two Pointers 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
 class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int i = 0;
        int j = 0;
        int lastIndex = -1;
        int max = 0;
        while(i < n){
            if(nums[i] == 0){
                j = lastIndex+1;
                lastIndex = i;
            }
            max = Math.max(max, i-j+1);
            i++;
        }
        return max;
    }
}
