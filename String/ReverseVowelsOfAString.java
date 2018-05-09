/**
 * 345，【Easy】，【Two Pointers】【String】
 * LeetCode 345. Reverse Vowels of a String
 * Related Topics: Two Pointers, String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private static final String vowels = "aeiouAEIOU";
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int left = 0, right = s.length()-1;
        char[] chars = s.toCharArray();
        while(left < right){
            while(left < right && vowels.indexOf(chars[left]) == -1){
                left++;
            }
            while(left < right && vowels.indexOf(chars[right]) == -1){
                right--;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
