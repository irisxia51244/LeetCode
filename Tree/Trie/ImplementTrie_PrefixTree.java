/**
 * 208，【Medium】，【Design】【Trie】
 * LeetCode 208. Implement Trie (Prefix Tree)
 * Related Topics: Design, Trie
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Trie {
    private class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = helper(word);
        return node!=null && node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = helper(prefix);
        return node!=null;
    }
    
    public TrieNode helper(String s){
        TrieNode node = root;
        for(int i = 0; i < s.length() && node!=null ; i++){
            char c = s.charAt(i);
            node = node.children[c - 'a'];
        }
        return node;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
