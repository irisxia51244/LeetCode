/**
 * 22，【Medium】，【String】【Backtracking】
 * LeetCode 22. Generate Parentheses
 * Related Topics: String, Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, n, 0, new StringBuilder());
        return res;
    }
    
    private void helper(List<String> res, int n, int left, int right, StringBuilder sb){
        if(sb.length() == n*2){
            res.add(sb.toString());
        }
        if(left > 0){
            sb.append('(');
            helper(res, n, left-1, right+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right > 0){
            sb.append(')');
            helper(res, n, left, right-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
