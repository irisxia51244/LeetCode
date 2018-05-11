/**
 * 647，【Medium】，【String】【DP】
 * LeetCode 647. Palindromic Substrings
 * Related Topics: String, Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++){
            count(s, i, i);
            count(s, i, i+1);
        }
        return count;
    }
    public void count(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++; left--; right++;
        }
    }
}
