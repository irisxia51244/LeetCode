/**
 * 395，【Medium】
 * LeetCode 395. Longest Substring with At Least K Repeating Characters
 * Related Topics: 
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int longestSubstring(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        return helper(s, k, 0, s.length());
    }
    
    private int helper(String s, int k, int start, int end){
        if(end - start < k) return 0;
        int[] bucket = new int[26];
        for(int i = start; i < end; i++){
            bucket[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++){
            if(bucket[i] > 0 && bucket[i] < k){
                for(int j = start; j < end; j++){
                    if(s.charAt(j) == i + 'a'){
                        int left = helper(s, k, start, j);
                        int right = helper(s, k, j+1, end);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end-start;
    }
}
