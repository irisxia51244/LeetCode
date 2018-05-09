/**
 * 394，【Medium】，【Stack】【DFS】
 * LeetCode 394. Decode String
 * Related Topics: Stack, DFS
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        String res = "";
        Stack<Integer> times = new Stack<>();
        Stack<String> strs = new Stack<>();
        
        int i = 0;
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int j = i+1;
                while(j < s.length() && Character.isDigit(s.charAt(j))){
                    j++;
                }
                times.push(Integer.parseInt(s.substring(i, j)));
                i = j-1;
            }
            else if(s.charAt(i) == '['){
                strs.push(res);
                res = "";
            }
            else if(s.charAt(i) == ']'){
                StringBuilder temp = new StringBuilder(strs.pop());
                int time = times.pop();
                for(int k = 0; k < time; k++){
                    temp.append(res);
                }
                res = temp.toString();
            }
            else{
                res += s.charAt(i);
            }
            i++;
        }
        return res;
    }
}
