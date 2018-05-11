/**
 * 746，【Easy】，【Arrays】【DP】
 * LeetCode 746. Min Cost Climbing Stairs
 * Related Topics: Arrays, Dynamic Programming
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        minCost[0] = cost[0];
        minCost[1] = cost[1];

        for(int i = 2; i <= cost.length; i++){
            int temp = 0;
            if(i == cost.length){
                temp = 0;
            }
            else{
                temp = cost[i];
            }
            
            minCost[i] = Math.min(minCost[i-1] + temp, minCost[i-2] + temp);
        }
        return minCost[cost.length];
    }
}
