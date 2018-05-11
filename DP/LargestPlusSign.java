/**
 * 764，【Medium】，【DP】
 * LeetCode 764. Largest Plus Sign
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        int res = 0;
        for(int i = 0; i < N; i++){
            Arrays.fill(grid[i], N);
        }
        
        for(int[] m : mines){
            grid[m[0]][m[1]] = 0;
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0, l = 0; j < N; j++){
                l = grid[i][j] == 0?0:l+1;
                grid[i][j] = Math.min(grid[i][j], l);
            }
            for(int k = N-1, r = 0; k >=0; k--){
                r = grid[i][k] == 0?0:r+1;
                grid[i][k] = Math.min(grid[i][k], r);
            }
            for(int j = 0, u = 0; j < N; j++){
                u = grid[j][i] == 0?0:u+1;
                grid[j][i] = Math.min(grid[j][i], u);
            }
            for(int k = N-1, d = 0; k >= 0; k--){
                d = grid[k][i] == 0?0:d+1;
                grid[k][i] = Math.min(grid[k][i], d);
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }
}
