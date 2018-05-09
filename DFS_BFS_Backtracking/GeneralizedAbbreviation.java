/**
 * 320，【Medium】，【Backtracking】【Bit Manipulation】
 * LeetCode 320. Generalized Abbreviation
 * Related Topics: Backtracking, Bit Manipulation
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(word, res, 0, 0, new StringBuilder());
        return res;
    }
    
    private void helper(String word, List<String> res, int pos, int cnt, StringBuilder sb){
        int len = sb.length();
        if(pos == word.length()){
            if(cnt != 0) sb.append(cnt);
            res.add(sb.toString());
        }
        else{
            helper(word, res, pos+1, cnt+1, sb);
            if(cnt != 0) sb.append(cnt);
            helper(word, res, pos+1, 0, sb.append(word.charAt(pos)));
        }
        sb.setLength(len);
        
    }
}
