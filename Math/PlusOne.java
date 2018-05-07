/**
 * 66，【Easy】，【Array】【Math】
 * LeetCode 66. Plus One
 * Related Topics: Array, Math
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */


class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        return newDigits;
    }
}
