/**
 * 750，【Medium】，【DP】
 * LeetCode 750. Number Of Corner Rectangles
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int countCornerRectangles(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length-1; i++){
            for(int j = i+1; j < grid.length; j++){
                int count = 0;
                for(int k = 0; k < grid[1].length; k++){
                    if(grid[i][k] == 1 && grid[j][k] == 1) count++;
                }
                if(count > 1) res += count * (count -1) /2;
            }
        }
        return res;
    }
}
