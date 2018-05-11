/**
 * 636，【Medium】，【Stack】
 * LeetCode 636. Exclusive Time of Functions
 * Related Topics: Stack
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        if(logs == null || logs.size() == 0 || n == 0) return ans;
        Stack<Integer> stack = new Stack<>();
        int prev_time = 0;
        
        for(String log: logs){
            String[] temp = log.split(":");
            int id = Integer.parseInt(temp[0]);
            int time = Integer.parseInt(temp[2]);
            if(!stack.isEmpty()){
                ans[stack.peek()] += time - prev_time;
            }
            prev_time = time;
            if(temp[1].equals("start")){
                stack.push(id);
            }
            else{
                ans[stack.pop()]++;
                prev_time++;
            }
        }
        return ans;
    }
}
