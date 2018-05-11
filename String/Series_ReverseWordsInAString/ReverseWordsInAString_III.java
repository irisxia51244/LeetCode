/**
 * 557，【Easy】，【String】
 * LeetCode 557. Reverse Words in a String III
 * Related Topics: String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            StringBuilder temp = new StringBuilder(str);
            sb.append(temp.reverse() + " ");
        }
        return sb.toString().trim();
    }
}
