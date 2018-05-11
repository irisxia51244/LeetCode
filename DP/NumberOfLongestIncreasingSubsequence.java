/**
 * 673，【Medium】，【DP】
 * LeetCode 673. Number of Longest Increasing Subsequence
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int res = 0, max = 0;
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            len[i] = 1; count[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1) count[i] += count[j];
                    else if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if(max == len[i]) res += count[i];
            else if(max < len[i]){
                max = len[i];
                res = count[i];
            }
        }
        return res;
        
    }
}
