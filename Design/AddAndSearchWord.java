/**
 * 211，【Medium】，【Backtracking】, 【Design】, 【Trie】
 * LeetCode 211. Add and Search Word - Data structure design
 * Related Topics: Backtracking, Design, Trie
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class WordDictionary {
    private class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    } 

    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.children[c -'a'] == null){
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, root, 0);
    }
    
    public boolean helper(String word, TrieNode node, int index){
        if(index == word.length()) return node.isWord;
        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode temp: node.children){
                if(temp != null && helper(word, temp, index+1)){
                    return true;
                }
            }
            return false;
        }else{
            return (node.children[c-'a']!=null && helper(word, node.children[c-'a'], index+1));
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
