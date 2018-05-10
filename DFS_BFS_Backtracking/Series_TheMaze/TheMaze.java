/**
 * 490，【Medium】，【DFS】【BFS】
 * LeetCode 490. The Maze
 * Related Topics: DFS, BFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0) return false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }
    
    public boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination){
        if(start[0] < 0 || start[0] > maze.length-1 || start[1] < 0 
           || start[1] > maze[0].length -1 || visited[start[0]][start[1]]) return false;
        
        visited[start[0]][start[1]] = true;
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i = 0; i < 4; i++){
            int row = start[0];
            int col = start[1];
            while(row >= 0 && row < maze.length && col >= 0 
                  && col < maze[0].length && maze[row][col] != 1){
                row += dir[i][0];
                col += dir[i][1];
            }
            row -= dir[i][0];
            col -= dir[i][1];
            if(dfs(maze, visited, new int[]{row, col}, destination)) return true;
        }
        return false;
    }
}
