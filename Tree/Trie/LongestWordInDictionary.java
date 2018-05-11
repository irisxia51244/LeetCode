/**
 * 720，【Easy】，【HashTable】【Trie】
 * LeetCode 720. Longest Word in Dictionary
 * Related Topics: HashTable, Trie
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public String longestWord(String[] words) {
        if(words == null || words.length == 0) return "";
        Arrays.sort(words);
        String res = "";
        HashSet<String> set = new HashSet<>();
        for(String s: words){
            if(s.length() == 1 || set.contains(s.substring(0,s.length()-1))){
                res = res.length() < s.length()?s:res;
                set.add(s);
            }
        }
        return res;
    }
}
