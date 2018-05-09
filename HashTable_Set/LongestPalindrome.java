/**
 * 409，【Easy】，【HashTable】
 * LeetCode 409. Longest Palindrome
 * Related Topics: Hash Table
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(char c: s.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
                count++;
            }
            else{
                set.add(c);
            }
        }
        if(!set.isEmpty()) return count*2+1;
        return count*2;
    }
}
