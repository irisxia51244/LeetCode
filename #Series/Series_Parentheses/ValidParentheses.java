/**
 * 20，【Medium】，【String】【Stack】
 * LeetCode 20. Valid Parentheses
 * Related Topics: String, Stack
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(n);
 */
 
 class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') 
                stack.push(')');
            else if(c == '{') 
                stack.push('}');
            else if(c == '[') 
                stack.push(']');
            else if(stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}
