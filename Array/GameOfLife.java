/**
 * 289，【Medium】，【Array】
 * LeetCode 289. Game of Life
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private final int[][] neighbors = {{0,-1},{0,1},{-1,-1},{-1,0},{-1,1},{1,-1},{1,0},{1,1}};
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int countLive = 0;
                for(int[] nb: neighbors){
                    int x = i + nb[0];
                    int y = j + nb[1];
                    if(x < 0 || x > m-1 || y < 0 || y > n-1 || board[x][y] < 1){
                        continue;
                    }
                    countLive++;
                }
                if(board[i][j] == 0){
                    if(countLive == 3) board[i][j] = -1;
                }else{
                    if(countLive < 2 || countLive > 3) board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == -1) board[i][j] = 1;
                else if(board[i][j] == 2) board[i][j] = 0;
            }
        }
        return;
    }
}
