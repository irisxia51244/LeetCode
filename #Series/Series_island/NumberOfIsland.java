import java.util.*;
/**
 * 200，【Medium】，【DFS】【BFS】【Union Find】
 * LeetCode 200. Number of Islands
 * Related Topics: DFS, BFS, Union Find
 * @author Iris Xia
 * Time Complexity: O(mn), Space Complexity: O( );
 */

class Solution {
    private final int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
  
    //DFS
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    helper(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void helper(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i > m-1 || j < 0 || j > n-1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for(int[] dir : dirs){
            helper(grid, i+dir[0], j+dir[1]);
        }
    }
}
