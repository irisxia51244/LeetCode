/**
 * 44， 【Hard】，【String】【DP】【Backtracking】【Greedy】
 * LeetCode 44. Wildcard Matching
 * Related Topics: String, Dynamic Programming, Backtracking, Greedy
 * @author Iris Xia
 * Time Complexity: O(mn), Space Complexity: O(1);
 */


class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int idxS = 0, idxP = 0, match = 0, star = -1;
        while(idxS < s.length()){
            if(idxP < p.length() && (s.charAt(idxS) == p.charAt(idxP) || p.charAt(idxP) == '?')){
                idxS++;
                idxP++;
            }else if(idxP < p.length() && p.charAt(idxP) == '*'){
                star = idxP;
                idxP++;
                match = idxS;
            }else if(star != -1){
                idxP = star+1;
                match++;
                idxS = match;
            }else return false;
        }
        while(idxP < p.length() && p.charAt(idxP) == '*'){
            idxP++;
        }
        return idxP == p.length();
    }
}
