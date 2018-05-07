/**
 * 36，【Medium】，【HashTable】
 * LeetCode 36. Valid Sudoku
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(mn), Space Complexity: O();
 */


class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue;
                if(!valid(board, i, j)) return false;
            }
        }
        return true;
    }
    
    private boolean valid(char[][] board, int i, int j){
        for(int row = 0; row < board.length; row++){
            if(row == i) continue;
            if(board[row][j] == board[i][j]) return false;
        }
        
        for(int col = 0; col < board[0].length; col++){
            if(col == j) continue;
            if(board[i][col] == board[i][j]) return false;
        }
        
        for(int row = (i/3)*3; row < (i/3+1)*3; row++){
            for(int col= (j/3)*3; col < (j/3+1)*3; col++){
                if(row == i && col == j) continue;
                if(board[row][col] == board[i][j]) return false;
            }
        }
        
        return true;
    }
}
