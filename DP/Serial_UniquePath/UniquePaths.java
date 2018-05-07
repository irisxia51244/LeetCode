/**
 * 62，【Medium】，【Array】【DP】
 * LeetCode 62. Unique Paths
 * Related Topics: Array, Dynamic Programming
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2: 
 */

class Solution {
    //Method1: Math
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;
        int r = m-1;
        int d = n-1;
        if(r < d){
            r = r+d;
            d = r-d;
            r = r-d;
        }
        long res = 1;
        for(int i = 1, j = r+1; i<=d ; i++, j++){
            res *= j;
            res /= i;
        }
        return (int)res;
    }
    
    //Method2: DP
}
