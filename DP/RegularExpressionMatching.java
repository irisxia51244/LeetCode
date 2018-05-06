/**
 * 10，【Hard】，【String】【DP】【Backtracking】
 * LeetCode 10. Regular Expression Matching
 * Related Topics: String, Dynamic Programming, Backtracking
 * @author Iris Xia
 * Time Complexity: O(mn), Space Complexity: O(mn);
 */
 
class Solution {
    public boolean isMatch(String s, String p) {      
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        
        for(int i = 2; i < dp[0].length; i++){
            if(p.charAt(i-1) == '*') dp[0][i] = dp[0][i-2];
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //if match, [i][j] = [i-1][j-1]
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                        dp[i][j] = dp[i][j-2];
                        if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
                            dp[i][j] = dp[i][j] || dp[i-1][j];
                        }
                    }
            }
        }
        return dp[s.length()][p.length()];
    }
}
