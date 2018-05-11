/**
 * 661，【Easy】，【Array】
 * LeetCode 661. Image Smoother
 * Related Topics: Array
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[][] imageSmoother(int[][] M) {
        if(M == null){
            return null;
        }
        int[][] result = new int[M.length][M[0].length];
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                result[i][j] = compute(M, i, j);
            }
        }
        return result;
    }
    
    private int compute(int[][] M, int row, int col){
        int count = 0;
        int sum = 0; 
        for(int i = row-1; i < row+2; i++){
            for(int j = col-1; j < col+2; j++){
                if(isvalid(M, i, j)){
                    count ++;
                    sum += M[i][j];
                }
            }
        }
        return sum/count;
    }
    
    private boolean isvalid(int[][] M, int i, int j){
        if(i < 0 || i > M.length-1 || j < 0 || j > M[0].length-1){
            return false;
        }
        else{
            return true;
        }
       
    }
}
