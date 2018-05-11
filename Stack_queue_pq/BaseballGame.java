/**
 * 682，【Easy】，【Stack】
 * LeetCode 682. Baseball Game
 * Related Topics: Stack
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(String op:ops){
            if(op.equals("+")){
                int pre = stack.pop();
                int pre_pre = stack.pop();
                stack.push(pre_pre);
                stack.push(pre);
                stack.push(pre+pre_pre);
            }
            else if(op.equals("D")){
                stack.push(2*stack.peek());
            }
            else if(op.equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.parseInt(op));
            }
        }
        
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
