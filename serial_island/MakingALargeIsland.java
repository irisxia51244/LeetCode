import java.util.*;
/**
 * 827，【HARD】，【DFS】
 * LeetCode 827. Making A Large Island
 * Related Topics: DFS
 * @author Iris Xia
 * Time Complexity: O(n^2), Space Complexity: O(number of islands);
 */

class Solution {
    private final int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int largestIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int maxArea = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = grid.length;
        int num = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int area = helper(grid, i, j, num);
                    map.put(num, area);
                    maxArea = Math.max(maxArea, area);
                    num++;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> neighbors = new HashSet<>();
                    int area = 1;
                    for(int[] dir: dirs){
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if(row < 0 || row > n-1 || col < 0 || col > n-1 || grid[row][col] < 2) continue;
                        neighbors.add(grid[row][col]);
                    }
                    for(int k: neighbors){
                        area += map.get(k);
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    
    private int helper(int[][] grid, int i, int j, int num){
        int n = grid.length;
        if(i < 0 || i > n-1 || j < 0 || j > n-1 || grid[i][j] != 1) return 0;
        grid[i][j] = num;
        int area = 1;
        for(int[] dir: dirs){
            area += helper(grid, i+dir[0], j + dir[1], num);
        }
        return area;
    }
}
