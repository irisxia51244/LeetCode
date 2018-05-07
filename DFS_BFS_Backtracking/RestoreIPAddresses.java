/**
 * 93，【Medium】，【Stirng】【Backtracking】
 * LeetCode 93. Restore IP Addresses
 * Related Topics: String, Backtracking
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        helper(s, res, 0, 0, "");
        return res;
    }
    
    private void helper(String s, List<String> res, int pos, int count,  String s1){
        if(count > 4){
            return;
        }
        if(count == 4 && pos == s.length()){
            res.add(s1);
        }  
        for(int i = 1; i < 4; i++){
            if(pos + i > s.length()) break;
            String temp = s.substring(pos, pos+i);
            if((temp.startsWith("0") && temp.length() > 1) 
               || (i == 3 && Integer.parseInt(temp) > 255)) continue;
            helper(s, res, pos+i, count+1, s1+temp+(count==3?"":"."));
        }
    }
}
