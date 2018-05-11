/**
 * 688，【Medium】，【DP】
 * LeetCode 688. Knight Probability in Chessboard
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        dp[r][c] = 1;
        int[][] dirs = new int[][]{{-2,-1}, {-2,1}, {-1,-2}, {-1, 2}, 
                                   {1, -2}, {1, 2}, {2,-1}, {2, 1}};
        for(int k = 0; k < K; k++){
            double[][] temp = new double[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    for(int[] dir: dirs){
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if(row >= 0 && row < N && col >= 0 && col < N){
                            temp[i][j] += dp[row][col];
                        }
                    }
                }
            }
            dp = temp;
        }
        double sum = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum += dp[i][j];
            }
        }
        
        return sum/Math.pow(8,K);
    }
}
