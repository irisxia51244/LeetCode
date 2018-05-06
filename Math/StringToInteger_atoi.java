/**
 * 8，【Medium】，【Math】【String】
 * LeetCode 8. String to Integer (atoi)
 * Related Topics: Math, String
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int i = 0, num = 0, sign = 1;
            
        while(str.charAt(i) == ' '){
            i++;
        }
        
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            sign = (str.charAt(i) == '-')?-1:1;
            i++;
        }else if(!Character.isDigit(str.charAt(i))){
            return 0;
        }
                 
        while(i < str.length()){
            int cur = str.charAt(i) - '0';
            if(cur < 0 || cur > 9) break;
            if(num > Integer.MAX_VALUE/10 || num == Integer.MAX_VALUE/10 && cur > 7){
                return sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num*10 + cur;
            i++;
        }
        return sign*num;
    }
}
