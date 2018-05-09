/**
 * 380，【Medium】，【Array】【HashTable】【Design】
 * LeetCode 380. Insert Delete GetRandom O(1)
 * Related Topics: Array, HashTable, Design
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class RandomizedSet {
    private HashMap<Integer, Integer> values;
    private HashMap<Integer, Integer> indices;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        values = new HashMap<>();
        indices = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(values.containsKey(val)) return false;
        values.put(val, values.size());
        indices.put(indices.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!values.containsKey(val)) return false;
        int i = values.get(val);
        values.remove(val);
        if(i == indices.size()-1){
            indices.remove(i);
        }
        else{
            int end = indices.get(indices.size()-1);
            values.put(end, i);
            indices.put(i, end);
            indices.remove(indices.size()-1);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int n = rand.nextInt(values.size());
        return indices.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
