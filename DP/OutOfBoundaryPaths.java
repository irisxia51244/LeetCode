/**
 * 576，【Medium】，【DP】【DFS】
 * LeetCode 576. Out of Boundary Paths
 * Related Topics: Dynamic Programming, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if(N <= 0) return 0;
        final int mod = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int res = 0;
        
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int k = 0; k < N; k++){
            int[][] temp = new int[m][n];
            for(int row = 0; row < m; row++){
                for(int col = 0; col < n; col++){
                    for(int[] dir : dirs){
                        int r = row + dir[0];
                        int c = col + dir[1];
                        if(r < 0 || r > m-1 || c < 0 || c > n-1){
                            res = (res + dp[row][col])%mod;
                        }
                        else{
                            temp[r][c] = (temp[r][c] + dp[row][col])%mod;
                        }
                    }
                }
            }
            dp = temp;
        }
        return res;
    }
}
