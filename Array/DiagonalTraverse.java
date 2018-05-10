/**
 * 498，【Medium】
 * LeetCode 498. Diagonal Traverse
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */
 
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int r = 0, c = 0;
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m*n];
        int index = 0;
        for(int i = 0; i < m+n-1; i++){
            if(i % 2 == 0){
                r = i < m?i:m-1;
                c = i < m?0:i-m+1;
                while(r >= 0 && c < n){
                    res[index++] = matrix[r--][c++];
                }
            }else{
                r = i < n?0:i-n+1;
                c = i < n?i:n-1;
                while(c >= 0 && r < m){
                    res[index++] = matrix[r++][c--];
                }
            }
        }
        return res;
    }
}
