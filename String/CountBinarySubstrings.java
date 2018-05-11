/**
 * 696，【Easy】，【String】
 * LeetCode 696. Count Binary Substrings
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int countBinarySubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int cur = 1, pre = 0;
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)) cur++;
            else{
                res += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(pre, cur);
    }
}
