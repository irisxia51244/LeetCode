/**
 * 739，【Medium】，【HashTable】【Stack】
 * LeetCode 739. Daily Temperatures
 * Related Topics: HashTable, Stack
 * @author Iris Xia
 * Method1: Time Complexity: O(), Space Complexity: O();
 * Method2:
 */

class Solution {
    //Method1: array as stack
    //Method2
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[0];
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        stack.push(0);
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        return res;
    }
}
