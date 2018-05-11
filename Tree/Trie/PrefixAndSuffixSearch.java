/**
 * 745，【Hard】，【Trie】
 * LeetCode 745. Prefix and Suffix Search
 * Related Topics: Trie
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class WordFilter {
    private class TrieNode{
        public TrieNode[] children = new TrieNode[27];
        public int index;
    }
    
    private TrieNode root = new TrieNode();
    
    public WordFilter(String[] words) {
        TrieNode node = root;
        node.children['{' - 'a'] = new TrieNode();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j <= words[i].length(); j++){
                for(int k = j; k < words[i].length(); k++){
                    char c = words[i].charAt(k);
                    if(node.children[c - 'a'] == null){
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                }
                if(node.children['{' - 'a'] == null){
                    node.children['{'-'a'] = new TrieNode();
                }
                
                node = node.children['{'-'a'];
                node.index = i;
                
                for(char c : words[i].toCharArray()){
                    if(node.children[c - 'a'] == null){
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                    node.index = i; 
                }
                node = root;
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode node = suffix.length() == 0?root:helper(suffix, root);
        if(suffix.length()!=0 && node == null) return -1;
        node = node.children['{' - 'a'];
        if(node!=null){
            if(prefix.length() == 0) return node.index;
            else{
                node = helper(prefix, node);
                if(node != null) return node.index;
            }
        }
        return -1;
    }
    
    public TrieNode helper(String s, TrieNode node){
        for(int i = 0; i < s.length() && node!=null; i++){
            char c = s.charAt(i);
            node = node.children[c - 'a'];
        }
        return node;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
