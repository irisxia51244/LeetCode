/**
 * 131，【Medium】，【Backtracking】
 * LeetCode 131. Palindrome Partitioning
 * Related Topics: Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        helper(s, res, new ArrayList<>());
        return res;
    }
    
    private void helper(String s, List<List<String>> res, List<String> list){
        if(s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            String cur = s.substring(0,i+1);
            if(isPalindrome(cur)){
                list.add(cur);
                helper(s.substring(i+1), res, list);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int l = 0, r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
