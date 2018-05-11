/**
 * 677，【Medium】，【Trie】
 * LeetCode 677. Map Sum Pairs
 * Related Topics: Trie
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class MapSum {

    /** Initialize your data structure here. */
    HashMap<String, Integer> map;
    int sum;
    public MapSum() {
        map = new HashMap<>();
        sum = 0;
        
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(String s: map.keySet()){
            if(s.indexOf(prefix) == 0){
                sum += map.get(s);
            }
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
