/**
 * 221，【Medium】，【DP】
 * LeetCode 221. Maximal Square
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int dp[][] = new int[rows+1][cols+1];
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        
        return res*res;
    }
}
