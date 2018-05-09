/**
 * 425，【Hard】，【Backtracking】【Trie】
 * LeetCode 425. Word Squares
 * Related Topics: Backtracking, Trie
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    private class TrieNode{
        TrieNode[] children;
        List<String> words;
        
        public TrieNode(){
            words = new ArrayList<>();
            children = new TrieNode[26];
        }
    }
    
    private TrieNode root;    
        
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        root = new TrieNode();
        int len = words[0].length();
        for(String word : words){
            addWord(word);
        }
        
        for(String word : words){
            List<String> list = new ArrayList<>();
            list.add(word);
            helper(len, res, list);
        }
        return res;
    }
    
    private void helper(int len, List<List<String>> res, List<String> list){
        if(list.size() == len){
            res.add(new ArrayList<>(list));
            return;
        }
        int pos = list.size();
        StringBuilder sb = new StringBuilder();
        for(String s: list){
            sb.append(s.charAt(pos));
        }
        List<String>  candidate = searchPrefix(sb.toString());
        for(String s: candidate){
            list.add(s);
            helper(len, res, list);
            list.remove(list.size() - 1);
        }
    }
    
    private void addWord(String s){
        TrieNode cur = root;
        for(char c: s.toCharArray()){
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur.children[c - 'a'].words.add(s);
            cur = cur.children[c - 'a'];
        }
    }
    
    private List<String> searchPrefix(String prefix){
        List<String> res = new ArrayList<>();
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.children[c - 'a'] == null) return res;
            cur = cur.children[c - 'a'];
        }
        res.addAll(cur.words);
        return res;
    }
}
