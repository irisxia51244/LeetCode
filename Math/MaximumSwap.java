import java.util.*;
/**
 * 670，【Medium】，【Math】【Array】
 * LeetCode 670. Maximum Swap
 * Related Topics: Math, Array
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(n);
 */

class Solution {
    public int maximumSwap(int num) {
        if(num < 10) return num;
        int[] digits = new int[9];
        char[] nums = Integer.toString(num).toCharArray();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i] - '0';
            if(cur != 0) digits[cur - 1] = i;
        }
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 9; j > (nums[i] - '0'); j--){
                if(digits[j-1] > i){
                    return swap(nums, i, digits[j-1]);
                }
            }
        }
        return num;     
    }
    
    private int swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return Integer.valueOf(new String(nums));
    }
}
