/**
 * 134，【Medium】，【Greedy】
 * LeetCode 134. Gas Station
 * Related Topics: Greedy
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
        int res = 0;
        int cur = 0;
        int sum = 0;
        for(int i = 0; i < gas.length; i++){
            cur += gas[i] - cost[i];
            if(cur < 0){
                sum += cur;
                cur = 0;
                res = i+1;
            }
        }
        sum += cur;
        return sum<0?-1:res;
    }
}
