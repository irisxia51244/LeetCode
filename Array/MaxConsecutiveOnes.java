/**
 * 485，【Easy】，【Array】
 * LeetCode 485. Max Consecutive Ones
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int maxCon = 0;
        int currentMax = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                currentMax ++;
                if(currentMax > maxCon){
                    maxCon = currentMax;
                }
            }
            else{
                currentMax = 0;
            }
        }
        return maxCon;
    }
}
