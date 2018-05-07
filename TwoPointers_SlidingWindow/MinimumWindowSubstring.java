/**
 * 76，【Hard】，【HashTable】【Two Pointers】【String】
 * LeetCode 76. Minimum Window Substring
 * Related Topics: HashTable, Two Pointers, String
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        int from = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;
        for(char c: t.toCharArray()){
            count[c]++;
        }
        
        for(int i = 0, j = 0; i < s.length(); i++){
            if(count[s.charAt(i)]-- > 0) total--;
            while(total == 0){
                if(i - j + 1 < min){
                    min = i-j+1;
                    if(min == t.length()) return s.substring(j, i+1);
                    from = j;
                }
                if(++count[s.charAt(j++)] > 0) total++;
            }
        }
        
        return min == Integer.MAX_VALUE? "":s.substring(from, from+min);
    }
}
