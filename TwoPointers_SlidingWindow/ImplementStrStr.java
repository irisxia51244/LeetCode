/**
 * 28，【Easy】，【Two Pointers】【String】
 * LeetCode 28. Implement strStr()
 * Related Topics: Two Pointers, String
 * @author Iris Xia
 * Time Complexity: O(mn), Space Complexity: O(1);
 */


class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }
        if(needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length(); i++){
            for(int j = 0; j <= needle.length(); j++){
                if(j == needle.length()){
                    return i;
                }
                if(i+j == haystack.length()){
                    return -1;
                }
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
        }
        return -1;
    }
}
