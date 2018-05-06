import java.util.*;
/**
 * 694，【Medium】，【HashTable】【DFS】
 * LeetCode 694. Number of Distinct Islands
 * Related Topics: HashTable, DFS
 * @author Iris Xia
 * Time Complexity: O(mn), Space Complexity: O( );
 */

class Solution {
    private final int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numDistinctIslands(int[][] grid) {
        HashSet<List<List<Integer>>> set = new HashSet<>();
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    List<List<Integer>> island = new ArrayList<>();
                    helper(grid, set, i, j, i, j, island);
                    set.add(island);
                }
            }
        }
        return set.size();
    }
    
    private void helper(int[][] grid, HashSet<List<List<Integer>>> set, int i, int j, int x, int y, List<List<Integer>> island){
        int m = grid.length, n = grid[0].length;
        if(i < 0 || i > m-1 || j < 0 || j > n-1 || grid[i][j] == 0) return;
        grid[i][j] = 0;
        island.add(Arrays.asList(i-x, j-y));
        for(int[] dir:dirs){
            helper(grid, set, i+dir[0], j+dir[1], x, y, island);
        }
    }
}
