/**
 * 348，【Medium】，【Design】
 * LeetCode 348. Design Tic-Tac-Toe
 * Related Topics: Design
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int[] diags;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diags = new int[2];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int n = rows.length;
        rows[row] += player == 1? 1: -1;
        cols[col] += player == 1? 1: -1;
        if(row == col){
            diags[0] += player == 1? 1: -1;
        }
        if(row+col == n-1){
            diags[1] += player == 1?1:-1;
        }
        
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n 
           || Math.abs(diags[0]) == n || Math.abs(diags[1]) == n){
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
