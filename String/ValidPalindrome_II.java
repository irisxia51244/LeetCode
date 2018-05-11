/**
 * 680，【Easy】，【String】
 * LeetCode 680. Valid Palindrome II
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while(l<r){
            if(chars[l] != chars[r]){
                return helper(chars, l+1, r) || helper(chars, l, r-1);
            }
            l++;
            r--;
        }
        return true;
    }
    
    private boolean helper(char[] chars, int l, int r){
        while(l<r){
            if(chars[l] != chars[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
