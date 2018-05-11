/**
 * 575，【Easy】，【HashTable】
 * LeetCode 575. Distribute Candies
 * Related Topics: HashTable
 * @author Iris Xia
 * Time Complexity: O(), Space Complexity: O();
 */

class Solution {
    public int distributeCandies(int[] candies) {
        if(candies == null || candies.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int c: candies){
            set.add(c);
        }
        return set.size() < candies.length/2?set.size():candies.length/2;
    }
}
