/**
 * 471，【Hard】，【DP】
 * LeetCode 471. Encode String with Shortest Length
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String encode(String s) {
        if(s == null || s.length() == 0) return s;
        int n = s.length();
        String[][] dp = new String[n][n];
        
        for(int l = 0; l < n; l++){
            for(int i = 0; i < n-l; i++){
                int j = i+l;
                String cur = s.substring(i, j+1);
                dp[i][j] = cur;
                if(j - i > 3){
                    for(int k = i; k < j; k++){
                        int len1 = dp[i][k].length() + dp[k+1][j].length();
                        int len2 = dp[i][j].length();
                        dp[i][j] = len1 < len2?dp[i][k]+dp[k+1][j]:dp[i][j];
                    }
                    
                    for(int k = 0; k < cur.length(); k++){
                        String pattern = cur.substring(0, k+1);
                        if(pattern != null && cur.length()%pattern.length() == 0
                          && cur.replaceAll(pattern,"").length() == 0){
                            String temp = cur.length()/pattern.length()+"[" + dp[i][i+k] + "]";
                            if(temp.length() < dp[i][j].length()){
                                dp[i][j] = temp;
                            }
                        }
                    }
                }
            }
            
        }
        return dp[0][n-1];
    }
}
