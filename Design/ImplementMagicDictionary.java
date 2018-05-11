/**
 * 676，【Medium】，【HashTable】【Trie】
 * LeetCode 676. Implement Magic Dictionary
 * Related Topics: HashTable, Trie
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class MagicDictionary {
    HashMap<String, List<Character>> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s: dict){
            for(int i = 0; i < s.length(); i++){
                String key = s.substring(0,i) + "*" + s.substring(i+1, s.length());
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<Character>());
                }
                map.get(key).add(s.charAt(i));
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(int i = 0; i < word.length(); i++){
            String key = word.substring(0,i) + "*" + word.substring(i+1, word.length());
            if(map.containsKey(key) && (map.get(key).size() > 1 
                                        || !map.get(key).contains(word.charAt(i)))) return true;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
