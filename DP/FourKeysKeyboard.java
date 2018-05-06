import java.util.*;
/**
 * 651 ，【Medium】，【Math】【Dynamic Programming】【Greedy】
 * LeetCode 
 * Related Topics: Math, Dynamic Programming, Greedy
 * @author Iris Xia.
 * Method1: Time Complexity: O(n^2), Space Complexity: O(n);
 * Method2: Time Complexity: O(n)
 */
 
 class Solution {
    //Method1
    public int maxA(int N) {
        if(N < 7) return N;
        int[] dp = new int[N+1];
    
        for(int i = 0; i <= N; i++){
            dp[i] = i;
            for(int j = 1; j <= N-3; j++){
                dp[i] = Math.max(dp[i], dp[j]*(i-j-1));
            }
        }
        return dp[N];
    }
    
    //Method2: need to proof. Only need o consider [i-4]*3 and [i-5]*4
}
