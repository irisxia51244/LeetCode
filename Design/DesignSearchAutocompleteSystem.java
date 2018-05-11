/**
 * 642，【Hard】，【Design】【Trie】
 * LeetCode 642. Design Search Autocomplete System
 * Related Topics: Design, Trie
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */


class AutocompleteSystem {
    private class TrieNode{
        public Map<Character, TrieNode> children;
        public Map<String, Integer> counts;
        
        public TrieNode(){
            children = new HashMap<>();
            counts = new HashMap<>();
        }
    }
    
    TrieNode root;
    String prefix;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for(int i = 0; i < sentences.length; i++){
            addSentence(sentences[i], times[i]);
        }
    }
    
    public void addSentence(String s, int count){
        TrieNode node = root;
        for(char c: s.toCharArray()){
            TrieNode next = node.children.get(c);
            if(next == null){
                next = new TrieNode();
                node.children.put(c, next);
            }
            node = next;
            next.counts.put(s, node.counts.getOrDefault(s, 0)+count);
        }
    }
    
    public List<String> input(char c) {
        if(c == '#'){
            addSentence(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        
        prefix = prefix + c;
        TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            TrieNode next = node.children.get(ch);
            if(next == null){
                return new ArrayList<String>();
            }
            node = next;
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = 
            new PriorityQueue<>((a,b) -> (a.getValue() == b.getValue()?
                                          a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue()));
        pq.addAll(node.counts.entrySet());
        List<String>res = new ArrayList<String>();
        int i = 3;
        while(!pq.isEmpty() && i > 0){
            res.add(pq.poll().getKey());
            i--;
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
