/**
 * 3，【Medium】，【HashTable】【Two Pointers】【String】
 * LeetCode 3. Longest Substring Without Repeating Characters
 * Related Topics: HashTable, Two pointers, String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int max = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                int lastIndex = map.get(c);
                if(lastIndex >= i){
                    i = lastIndex+1;
                }
            }
            max = Math.max(max, j-i+1);
            map.put(c, j);
            j++;
        }
        return max;
    }
}
