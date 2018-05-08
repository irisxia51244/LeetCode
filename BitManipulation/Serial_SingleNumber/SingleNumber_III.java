/**
 * 260，【Medium】，【Bit Manipulation】
 * LeetCode 260. Single Number III
 * Related Topics: Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            diff ^= nums[i];
        }
        diff = diff&(~(diff -1));
        
        for(int i = 0; i < nums.length; i++){
            if((diff & nums[i]) == 0){
                ans[0] ^= nums[i];
            }
            else{
                ans[1] ^= nums[i];
            }
        }
        return ans;
    }
}
