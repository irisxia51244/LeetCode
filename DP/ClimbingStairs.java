/**
 * 70，【Easy】，【Dynamic Programming】
 * LeetCode 70. Climbing Stairs
 * Related Topics: Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int prev_1 = 1;
        int prev_2 = 1;
        for(int i = 2; i < n; i++){
            int temp = prev_2;
            prev_2 = prev_1 + prev_2;
            prev_1 = temp;
        }
        return 
    }
}
