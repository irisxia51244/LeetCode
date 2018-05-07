/**
 * 71，【Medium】，【String】【Stack】
 * LeetCode 71. Simplify Path
 * Related Topics: String, Stack
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        String res = "";
        for(String s: paths){
            if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            } else if(!s.equals(".") && !s.equals("")){
                stack.push(s);
            }
        }
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        if(res.length() == 0) return "/";
        return res;
    }
}
