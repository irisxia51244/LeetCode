import java.util.*;
/**
 * LeetCode 170. Two Sum III - Data structure design
 * 170，【EASY】，【HashTable】【Design】
 * Related Topics: HashTable, Design
 * @author Iris Xia
 * Time Complexity: add-O(1), find-O(n);
 */

class TwoSum {
    private HashMap<Integer, Boolean> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, true);
        }
        else{
            map.put(number, false);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer i: map.keySet()){
            if(2*i == value){
                if(map.get(i)) return true;
            }
            else if(map.containsKey(value-i)) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
