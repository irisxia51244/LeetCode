/**
 * 169，【Easy】，【Array】【Divide&Conquer】【Bit】
 * LeetCode 169. Majority Element
 * Related Topics: Array, Divide and Conquer, Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                num = nums[i];
                count = 1;
            }
            else if(num == nums[i]){
                count ++;
            }
            else{
                count --;
            }
        }
        return num;
    }
}
