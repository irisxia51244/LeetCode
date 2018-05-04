import java.util.*;
/**
 * 463，【EASY】
 * LeetCode 463. Island Perimeter
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(mn), Space Complexity: O(1);
 */

class Solution {
  //for '1', += 4, -= 2 for each neighboring '1' up and left
  public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res += 4;
                    if(i > 0 && grid[i-1][j] == 1) res -= 2;
                    if(j > 0 && grid[i][j-1] == 1) res -= 2;
                }
            }
        }
        return res;
    }
 
    //Naive way, check four dirs
    public int islandPerimeter2(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(i == 0 || grid[i-1][j] == 0){
                        res++;
                    }
                    if(j == 0 || grid[i][j-1] == 0){
                        res++;
                    }
                    if(i == grid.length-1 || grid[i+1][j] == 0){
                        res++;
                    }
                    if(j == grid[0].length-1 || grid[i][j+1] == 0){
                        res++;
                    }   
                }
            }
        }
        return res;
    }
}
