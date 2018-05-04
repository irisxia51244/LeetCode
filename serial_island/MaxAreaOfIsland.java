import java.util.*;
/**
 * 695，【EASY】，【Array】【DFS】
 * LeetCode 695. Max Area of Island
 * Related Topics: Array, DFS
 * @author Iris Xia
 * Method 1:Time Complexity: O(mn), Space Complexity: O( );
 * Method 2: add visited boolean[][], Space Complexity++
 */

class Solution {
    private int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
  
    //Method 1: Modify input grid
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int maxArea = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, helper(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    
    private int helper(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i > m-1 || j < 0 || j > n-1 || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int area = 1;
        for(int[] dir: dirs){
            area += helper(grid, i+dir[0], j+dir[1]);
        }
        return area;
    }
}
