/**
 * 79，【Medium】，【Array】【Backtracking】
 * LeetCode 79. Word Search
 * Related Topics: 
 * @author Iris Xia.
 * Time Complexity: O(4^n), Space Complexity: O();
 */
 
 class Solution {
    private final int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[m][n];
                    if(helper(board, word, visited, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, boolean[][] visited, int pos, int row, int col){
        if(pos == word.length()){
            return true;
        }
        if(row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1 
           || visited[row][col] || word.charAt(pos) != board[row][col]){
            return false;
        }
        visited[row][col] = true;
        for(int[] dir: dirs){
            int x = row + dir[0];
            int y = col + dir[1];
            if(helper(board, word, visited, pos+1, x, y)){
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
