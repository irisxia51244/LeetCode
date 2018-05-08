/**
 * 159，【Hard】，【HashTable】【Two Pointers】【String】
 * LeetCode 159. Longest Substring with At Most Two Distinct Characters
 * Related Topics: HashTable, Two Pointers, String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        int i = 0, j = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            char c = s.charAt(j);
            map.put(c, j);
            if(map.size() > 2){
                int leftmost = s.length();
                for(int idx: map.values()){
                    leftmost = Math.min(leftmost, idx);
                }
                i = leftmost + 1;
                map.remove(s.charAt(leftmost));
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}
