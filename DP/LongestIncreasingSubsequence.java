/**
 * 300，【Medium】，【Binary Search】【DP】
 * LeetCode 300. Longest Increasing Subsequence
 * Related Topics: Bianry Search, Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int maxLen = 0;
        for(int num: nums){
            int lo = 0, hi = maxLen;
            while(lo != hi){
                int mid = (lo + hi)/2;
                if(tails[mid] < num){
                    lo = mid+1;
                }else{
                    hi = mid;
                }
            }
            tails[lo] = num;
            if(lo == maxLen) maxLen++;
        }
        return maxLen;
    }
}
