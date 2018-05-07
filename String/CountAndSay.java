/**
 * 38，【Medium】，【String】
 * LeetCode 38. Count and Say
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */



class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j = 0; j < s.length(); j++){
                if(j == s.length()-1 || s.charAt(j) != s.charAt(j+1)){
                    sb.append(count);
                    sb.append(s.charAt(j));
                    count = 1;
                }else{
                    count++;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
