/**
 * 266，【Easy】，【HashTable】
 * LeetCode 266. Palindrome Permutation
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(!set.add(s.charAt(i))){
                set.remove(s.charAt(i));
            }
        }
        return set.size() == 0 || set.size() == 1;
    }
}
