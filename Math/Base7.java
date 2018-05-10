/**
 * 504，【Easy】
 * LeetCode 504. Base 7
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String convertToBase7(int num) {
        return helper(num);
    }
    
    private String helper(int num){
        if(num < 0){
            return "-" + helper(-num);
        }
        if(num < 7){
            return Integer.toString(num);
        }
        return helper(num/7) + Integer.toString(num%7);
    }
}
