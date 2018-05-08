/**
 * 340，【Hard】，【HashTable】【String】
 * LeetCode 340. Longest Substring with At Most K Distinct Characters
 * Related Topics: HashTable, String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            char c = s.charAt(j);
            map.put(c, j);
            if(map.size() > k){
                int leftmost = s.length();
                for(int idx : map.values()){
                    leftmost = Math.min(leftmost, idx);
                }
                map.remove(s.charAt(leftmost));
                i = leftmost + 1;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}
