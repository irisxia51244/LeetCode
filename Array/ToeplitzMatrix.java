/**
 * 766，【Easy】，【Array】
 * LeetCode 766. Toeplitz Matrix
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for(int i = 0; i < matrix.length-1; i++){
            for(int j = 0; j < matrix[i].length-1; j++){
                if(matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
