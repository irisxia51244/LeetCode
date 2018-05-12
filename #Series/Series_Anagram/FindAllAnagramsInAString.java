/**
 * 438，【Easy】，【HashTable】
 * LeetCode 438. Find All Anagrams in a String
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(n), Space Complexity: O(1);
 */

class Solution {
    /*
      Sliding Window问题：
        建bucket，遍历pattern string，[c]++
        count为需要match的char个数，即pattern长度
        for loop (two pointers, j为left, i为right):
            bucket[charAt(i)]--，如果原本>0，count--(说明match到一个)
            当count为0时，如果长度是pattern长度(说明是anagram),add
                         移动j并bucket[charAt(j)]++,如果>0,count++(说明之前match到的一位在window外了)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length()) return res;
        int[] bucket = new int[26];
        int count = p.length();
        for(char c: p.toCharArray()){
            bucket[c-'a']++;
        }
        for(int i = 0, j = 0; i < s.length(); i++){
            if(bucket[s.charAt(i)-'a']-- > 0) count--;
            while(count == 0){
                if(i-j+1 == p.length()) res.add(j);
                if(++bucket[s.charAt(j++) - 'a'] > 0) count++;
            }
        }
        return res;
    }
}
