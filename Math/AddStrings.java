/**
 * 415，【Easy】，【Math】
 * LeetCode 415. Add Strings
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null 
           || num1.length() == 0 || num2.length() == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry == 1){
            int a = i < 0? 0: num1.charAt(i) - '0';
            int b = j < 0? 0: num2.charAt(j) - '0';
            sb.append((a + b + carry)%10);
            carry = (a + b + carry)/10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
