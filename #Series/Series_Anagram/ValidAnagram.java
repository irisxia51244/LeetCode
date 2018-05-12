/**
 * 242，【Easy】，【HashTable】【Sort】
 * LeetCode 242. Valid Anagram
 * Related Topics: HashTable, Sort
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */


class Solution {
    /*
        Only lowercase alphabet, bucket int[26]
        Only alphabet, bucket int[128]
        Unicode, using HashMap
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < count.length; i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }
}
