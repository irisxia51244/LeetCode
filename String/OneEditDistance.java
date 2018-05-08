/**
 * 161，【Medium】，【String】
 * LeetCode 161. One Edit Distance
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) return false;
        int m = s.length(), n = t.length();
        if(Math.abs(m - n) > 1) return false;
        for(int i = 0; i < Math.min(m, n); i++){
            if(s.charAt(i) == t.charAt(i)) continue;
            if(m == n) return s.substring(i+1).equals(t.substring(i+1));
            if(m < n) return s.substring(i).equals(t.substring(i+1));
            if(m > n) return s.substring(i+1).equals(t.substring(i));
        }
        return m!=n;
    }
}
