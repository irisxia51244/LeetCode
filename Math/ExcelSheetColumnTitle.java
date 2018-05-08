/**
 * 168，【Easy】，【Math】
 * LeetCode 168. Excel Sheet Column Title
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n--;
            sb.append((char)('A' + n%26));
            n/=26;
        }
        return sb.reverse().toString();
    }
}
