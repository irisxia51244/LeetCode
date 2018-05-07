/**
 * 73，【Medium】，【Array】
 * LeetCode 73. Set Matrix Zeroes
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(mn), Space Complexity: O(1);
 */


class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean first_row = false;
        boolean first_col = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) first_row = true;
                    if(j == 0) first_col = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(first_row){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        
        if(first_col){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        return;
    }
}
