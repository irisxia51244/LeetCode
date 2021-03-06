/**
 * 227，【Medium】，【String】
 * LeetCode 227. Basic Calculator II
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(n);
 */

class Solution {
    /*
        遍历string，if digit:
                            读完整个数字
                            '+' push num, '-' push -num, '*' push(pop() * num), '/' push(pop()/num) 
                   if符号:
                            sign = 符号
        累加stack中的数
     */
    public int calculate(String s) {
        int res = 0;
        if(s == null || s.length() == 0) return res;
        Stack<Integer> stack = new Stack<>();
        int num = 0;;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num = s.charAt(i) - '0';
                while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + s.charAt(i+1) - '0';
                    i++;
                }
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ' || i == s.length()-1){
                if(sign == '+') stack.push(num);
                else if(sign == '-') stack.push(-num);
                else if(sign == '*') stack.push(stack.pop() * num);
                else if(sign == '/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
