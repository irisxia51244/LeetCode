import java.util.*;
/**
 * 344，【Easy】，【String】【Two Pointers】
 * LeetCode 344. Reverse String
 * Related Topics: String, Two Pointers
 * @author Iris Xia.
 * Method 1: Time Complexity: O(n), Space Complexity: O(n);
 */

class Solution {
    // Method 1
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int l = 0, r = s.length()-1;
        while(l < r){
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
        return new String(chars);
    }
}
