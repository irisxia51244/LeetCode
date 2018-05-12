/**
 * 125，【Easy】，【Two Pointers】【String】
 * LeetCode 125. Valid Palindrome
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null ||s.length() == 0) return true;
        
        int left = 0, right = s.length() - 1;
        char cLeft, cRight;
        while(left < right){
            cLeft = s.charAt(left);
            cRight = s.charAt(right);
            if(!Character.isLetterOrDigit(cLeft)){
                left++;
            }else if(!Character.isLetterOrDigit(cRight)){
                right--;
            }else if(Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)){
                    return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}
