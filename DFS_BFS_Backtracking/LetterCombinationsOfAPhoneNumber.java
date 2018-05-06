/**
 * 17，【Medium】，【String】【Backtracking】
 * LeetCode 17. Letter Combinations of a Phone Number
 * Related Topics: String, Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private final String[] buttons = new String[]{"","","abc", "def","ghi","jkl","mno",
                                      "pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        helper(res, digits, "", 0);
        return res;
    }
    
    private void helper(List<String> res, String digits, String s, int cur){
        if(cur == digits.length()){
            res.add(s);
            return;
        }
        String letters = buttons[digits.charAt(cur) - '0'];
        for(int i = 0; i < letters.length(); i++){
            helper(res, digits, s+letters.charAt(i), cur+1);
        }
    }
}
