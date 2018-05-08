/**
 * 171，【Easy】，【Math】
 * LeetCode 171. Excel Sheet Column Number
 * Related Topics: Math
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int titleToNumber(String s) {
        int[] value = new int[26];
        for(int i= 0; i < 26; i++){
            value[i] = i+1;
        }
        String letter = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        s = s.toUpperCase();
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            int currentLetter = s.charAt(s.length() - 1 - i);
            int index = letter.indexOf(currentLetter);
            ans += Math.pow(26,i) * value[index];
        }
        return ans;
    }
}
