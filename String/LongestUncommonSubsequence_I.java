/**
 * 521，【Easy】，【String】
 * LeetCode 521. Longest Uncommon Subsequence I
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
