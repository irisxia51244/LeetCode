/**
 * 125，【Easy】，【Two Pointers】【String】
 * LeetCode 125. Valid Palindrome
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null ||s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
}
