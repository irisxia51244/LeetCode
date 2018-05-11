/**
 * 598，【Easy】，【Math】
 * LeetCode 598. Range Addition II
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops == null || ops.length == 0 || ops[0].length == 0) return m*n;
        int row = Integer.MAX_VALUE, col = Integer.MAX_VALUE;
        for(int[] op: ops){
            row = Math.min(row, op[0]);
            col = Math.min(col, op[1]);
        }
        return row*col;
    }
}
