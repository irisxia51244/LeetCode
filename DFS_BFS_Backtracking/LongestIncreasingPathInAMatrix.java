/**
 * 329，【Hard】，【DFS】【Topological Sort】【Memoization】
 * LeetCode 329. Longest Increasing Path in a Matrix
 * Related Topics: DFS, Topological Sort, Memoization
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private final int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int len = helper(matrix, dp, i, j);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    
    private int helper(int[][] matrix, int[][] dp, int row, int col){
        if(dp[row][col] > 0) return dp[row][col];
        int max = 1;
        for(int[] dir : dirs){
            int x = row + dir[0];
            int y = col + dir[1];
            if(x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length-1
               ||matrix[x][y] <= matrix[row][col]) continue;
            int len = 1 + helper(matrix, dp, x, y);
            max = Math.max(max, len);
        }
        dp[row][col] = max;
        return max;
    }
}
